package hostgator.Pages.domain;

import hostgator.util.StaticData;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class CartCheckout {

    private static Logger log = LogManager.getLogger(CartCheckout.class.getName());
    Random random = new Random();


    private WebDriver driver;
    public CartCheckout(WebDriver driver)
    {
        this.driver=driver;
    }

    //Your Account
    private By emailField           = By.name("email");
    private By passwordField        = By.name("password");
    private By confirmPasswordfield = By.name("confirm_password");
    private By continueButton       = By.xpath("//*[@id=\"checkout\"]/div[2]/div[1]/div/section/div/div[2]/div[1]/section[1]/div[6]/button");
    private By pinField             = By.name("pin");

    //Payment Options
    private By firstNameField = By.name("first_name");
    private By lastNameField  = By.name("last_name");
    private By homePhoneField = By.name("home_phone");
    private By addressField   = By.name("address");
    private By cityField      = By.name("city");
    private By zipCodeField   = By.name("postal_code");

    //Payment Method
    private By creditCardradio      = By.name("//");
    private By payPalradio          = By.name("//");
    private By nameOnCardField      = By.name("name_on_card");
    private By ccNumerField         = By.name("number");
    private By expDateMonthDropDown = By.name("//");
    private By expDateYearDropDown  = By.name("//");
    private By cvvCodeField         = By.name("cvv");
    private By continueToCheckout   = By.linkText("Continue to Checkout");
    private By tos                  = By.xpath("//*[@id=\"checkout\"]/div[2]/div[3]/div/section/div/div/div[2]/div/div/p[2]/div/ins"); //By.id("accept-tos");

    //order Summary
    private By placeOrderButton = By.xpath("//*[@id=\"checkout\"]/div[2]/div[3]/div/section/div/div/div[4]/ul/li[2]/button");

    //Your Account
    public void enterEmail()
    {
        driver.findElement(emailField).sendKeys(StaticData.domainName +random.nextInt(10000)+"domain" +random.nextInt(100000)+ "@endurance.com");
        log.info("Entered Email");
    }

    public void enterPassword(String password)
    {
        driver.findElement(passwordField).sendKeys(password);
        log.info("Entered Password");
    }

    public void enterConfirmPassword(String password)
    {
        driver.findElement(confirmPasswordfield).sendKeys(password);
        log.info("Entered Confirm Password");
    }

    public void clickContinue(){
        driver.findElement(continueButton).click();
    }

    public void enterPin(String pin){
        driver.findElement(pinField).sendKeys(pin);
    }

    //Payment Options
    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
        log.info("Entered First Name");
    }

    public void enterlastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
        log.info("Entered Last name");
    }

    public void enterHomePhone(String homePhone) {
        driver.findElement(homePhoneField).sendKeys(homePhone);
        log.info("Entered Phone");
    }

    public void enterAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
        log.info("Entered Address");
    }

    public void enterCity(String city) {
        driver.findElement(cityField).sendKeys(city);
        log.info("Entered City");
    }

    public void enterZipCode(String zip) {
        driver.findElement(zipCodeField).sendKeys(zip);
        log.info("Entered Zip");
    }

    public void enterCCName(String ccName) {
        driver.findElement(nameOnCardField).sendKeys(ccName);
        log.info("Entered Zip");
    }

    public void enterCCNumber(String cc) {
        driver.findElement(ccNumerField).sendKeys(cc);
        log.info("Entered CC #");
    }

    public void enterCVV(String cvv) {
        driver.findElement(cvvCodeField).sendKeys(cvv);
        log.info("Entered CVV");
    }

    public void clickContinueToCheckout() {
        driver.findElement(continueToCheckout).click();
    }

    public void acceptTOS() {
//        driver.findElement(tos).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(tos)).click();

    }

    public void clickPlaceOrder() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(placeOrderButton)).click();
    }

    public void enterPasswordAndConfirm(String password)
    {
        enterPassword(password);
        enterConfirmPassword(password);
    }

    public void enterBillingInfo()
    {
        enterFirstName(StaticData.firstName);
        enterlastName(StaticData.lastName);
        enterHomePhone(StaticData.phone);
        enterAddress(StaticData.address1);
        enterCity(StaticData.city);
        enterZipCode(StaticData.zip);
    }

    public void enterCCInfo()
    {
        enterCCName(StaticData.testCreditCardName);
        enterCCNumber(StaticData.testCreditCardNumber);
        enterCVV(StaticData.testCreditCardCVV);
    }

    public void acceptTOSAndPlaceOrder()
    {
        acceptTOS();
        clickPlaceOrder();
    }

}