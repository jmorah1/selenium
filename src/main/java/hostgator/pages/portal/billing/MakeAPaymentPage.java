package hostgator.pages.portal.billing;

import hostgator.pages.paypal.PayPalLogin;
import hostgator.util.StaticData;
import org.openqa.selenium.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MakeAPaymentPage {

    private WebDriver driver;
    private static Logger log = LogManager.getLogger(MakeAPaymentPage.class.getName());

    public MakeAPaymentPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(this.driver, this);
    }

    private void NoInterceptClick(WebElement elementToClick){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", elementToClick);
    }

    public void WaitToBeClickable(WebElement elementToBeClicked) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(elementToBeClicked));
    }
    public void WaitToBeVisible(WebElement elementToBeVisable) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(elementToBeVisable));
    }

    //region Invoice Selection Page Elements
    @FindBy(how = How.CLASS_NAME, using = "check-package")
    private WebElement _prePayCheckBox;

    @FindBy(how = How.CLASS_NAME, using = "button-buy")
    private WebElement _buttonBuy;

    //endregion

    //region Payment Type Selection Page Elements
    @FindBy(how = How.LINK_TEXT, using = "Use New Credit Card")
    private WebElement _newCard;

    @FindBy(how = How.NAME, using = "cardnumber")
    private WebElement _cardNumberField;

    @FindBy(how = How.NAME, using = "security_code")
    private WebElement _securityCodeField;

    @FindBy(how = How.ID, using = "not-paypall")
    private WebElement _checkoutButton;

    @FindBy(how = How.CLASS_NAME, using = "alert-success")
    private WebElement _checkoutSuccess;

    @FindBy(how = How.LINK_TEXT, using = "Use PayPal")
    private WebElement _usePayPal;

    @FindBy(how = How.ID, using = "paypal-one-time")
    private WebElement _paypalOneTime;

    @FindBy(how = How.ID, using = "paypal-button")
    private WebElement _checkoutPayPal;

    @FindBy(how = How.CLASS_NAME, using = "iCheck-helper")
    private WebElement _tosCheckBox;

    //endregion

    //region Invoice Selection Page Methods
    private void SelectPrePayInvoice()
    {
        NoInterceptClick(_prePayCheckBox);
        log.info("Click Checkbox for PrePay Invoice");
    }
    private void ClickContinue()
    {
        WaitToBeClickable(_buttonBuy);
        NoInterceptClick(_buttonBuy);
        log.info("Continued to Checkout");
    }
    //endregion

    //region Payment Type Selection Page Methods
    private void UseNewCard() {
        NoInterceptClick(_newCard);
        log.info("Selected New Card");
    }
    private void EnterCreditCardInfo() {
        _cardNumberField.sendKeys(StaticData.TEST_CREDIT_CARD_NUMBER + Keys.TAB + Keys.TAB + Keys.ARROW_DOWN + Keys.ARROW_DOWN + Keys.ENTER);
        log.info("Entered Credit Card Number and Expiration Date");
    }
    private void EnterSecurityCode() {
        _securityCodeField.sendKeys(StaticData.TEST_CREDIT_CARD_CVV);
        log.info("Entered Credit Card CVV");
    }
    private void ClickTosCheckBox() {
        NoInterceptClick(_tosCheckBox);
        log.info("Checked TOS Box");
    }
    private void ClickCheckoutButton() {
        NoInterceptClick(_checkoutButton);
        log.info("Clicked Complete Checkout");
    }
    private void PaymentSuccessCheck() {
        WaitToBeVisible(_checkoutSuccess);
        log.info("Verified Successful Payment");
    }
    private void SelectPayPal() {
        WaitToBeClickable(_usePayPal);
        NoInterceptClick(_usePayPal);
        log.info("Selected PayPal");
    }
    private void SelectPayPalOneTimePayment() {
        WaitToBeClickable(_paypalOneTime);
        NoInterceptClick(_paypalOneTime);
        log.info("Selected One Time Payment For PayPal");
    }
    private void ClickCheckoutButtonPayPal() {
        WaitToBeClickable(_checkoutPayPal);
        NoInterceptClick(_checkoutPayPal);
        log.info("Proceeding to PayPal Site");
    }
    //endregion

    public void PayWithCreditCard() {
        SelectPrePayInvoice();
        ClickContinue();
        UseNewCard();
        EnterCreditCardInfo();
        EnterSecurityCode();
        ClickTosCheckBox();
        ClickCheckoutButton();
        PaymentSuccessCheck();
    }

    public void PayWithPayPal() {
        PayPalLogin payPalLogin = new PayPalLogin(driver);
        SelectPrePayInvoice();
        ClickContinue();
        SelectPayPal();
        SelectPayPalOneTimePayment();
        ClickTosCheckBox();
        ClickCheckoutButtonPayPal();
        payPalLogin.completePayPalSiteCheckout();
        PaymentSuccessCheck();
    }
}
