package hostgator.Pages.PayPal;

import hostgator.util.StaticData;
import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PayPalLogin{

	private static Logger log = LogManager.getLogger(PayPalLogin.class.getName());
	private WebDriver driver;
	public PayPalLogin(WebDriver driver)
	{
		this.driver=driver;
	}

	By paypal_email_field    = By.id("email");
	By paypal_next_buttom    = By.id("btnNext");
	By paypal_password_field = By.id("password");
	By paypal_login_button   = By.id("btnLogin");
	By paypal_continue_button= By.xpath("//*[@id=\"button\"]/button");
	By paypal_continue_button2= By.id("fiSubmitButton");
	By paypal_stayeLoggedIn  = By.id("keepMeLogin");
	By paypal_agreeContinuebutton = By.id("confirmButtonTop"); ////*[@id="confirmButtonTop"]
	By paypal_agreeContinuebutton2 = By.id("consentButton"); ////*[@id="confirmButtonTop"]

	public void enterPayPalEmail(String PAYPAL_EMAIL)
	{
		driver.findElement(paypal_email_field).sendKeys(PAYPAL_EMAIL);
		log.info("Entered PayPal Email");
	}

	public void clickPayPalNextButton()
	{
		driver.findElement(paypal_next_buttom).click();
		log.info("Clicked Next");
	}

	public void enterPayPalPassword(String paypalPassword)
	{
		driver.findElement(paypal_password_field).sendKeys(paypalPassword);
		log.info("Entered PayPal Password");
	}

//	public void unCheckStayLoggedIn() {
//		WebElement stayeLoggedInElement = driver.findElement(paypal_stayeLoggedIn);
//
//		if (stayeLoggedInElement.isSelected() ){
//			stayeLoggedInElement.click();
//		}
//		//driver.findElement(paypal_stayeLoggedIn).click();
//	}

	public void clickPayPalLoginButton()
	{
		driver.findElement(paypal_login_button).click();
		log.info("Clicked PayPal Login");
	}

	public void clickPayPalContinueButton()
	{
		driver.findElement(paypal_continue_button).click();
		log.info("Clicked PayPal Continue");
	}

	public void clickPayPalContinueButton2() //paypal made some changes
	{
		driver.findElement(paypal_continue_button2).click();
		log.info("Clicked PayPal Continue2");
	}

	public void clickPaypalAgreeAndContinuebutton()
	{
		driver.findElement(paypal_agreeContinuebutton).click();
		log.info("Clicked PayPal Agree and Continue");
	}

	public void clickPaypalAgreeAndContinuebutton2() //paypal made some changes
	{
		driver.findElement(paypal_agreeContinuebutton2).click();
		log.info("Clicked PayPal Agree and Continue2");
	}

	public void completePayPalSiteCheckout() {
		enterPayPalEmail(StaticData.PAYPAL_EMAIL);
		clickPayPalNextButton();
		enterPayPalPassword(StaticData.PAYPAL_PASSWORD);
		clickPayPalLoginButton();
		clickPaypalAgreeAndContinuebutton();
	}
}
