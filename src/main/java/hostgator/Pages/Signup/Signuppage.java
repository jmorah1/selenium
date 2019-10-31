package hostgator.Pages.Signup;

import java.util.Date;
import java.util.Random;

import hostgator.Pages.PayPal.PayPalLogin;
import hostgator.driver.TestDriver;
import hostgator.util.StaticData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Signuppage extends TestDriver {

	Date date= new Date();
	Random random = new Random();

	private static Logger log = LogManager.getLogger(Signuppage.class.getName());
	
//	private WebDriver driver;
	public Signuppage(WebDriver driver)
	{
		this.driver=driver;
	}
	//Page Elements
	//<editor-fold desc="Domain Section">
	private By iOwnThisDomain = By.id("old_domain_tab");
	private By domainTextField = By.id("domain_field");
	//</editor-fold>

	//<editor-fold desc="Hosting Plan">
	private By tldSelect          = By.id("tld_select");
	private By billingDropdown     = By.id("billing_cycle");
	private By usernameTextField = By.xpath("//*[@id=\"username\"]");
	private By pinTextField      = By.id("new_pin");
	//</editor-fold>

	//<editor-fold desc="Billing Info Section">
	private By emailTextField    = By.id("new-email");
	private By confirmRmailField = By.id("new-email-confirm");
	private By firstNameField          = By.id("new-first-name");
	private By lastNameField           = By.id("new-last-name");
	private By phoneNumberField        = By.id("hphone");
	private By address1Field      = By.id("new-address1");
	private By address2Field      = By.id("new-address2");
	private By cityField          = By.id("new-city");
	private By zipCodeField      = By.id("zip_code");
	//</editor-fold>

	//<editor-fold desc="Credit Card Payment Type">
	private By ccCardNameField = By.id("new-name-on-card");
	private By ccNumberField    = By.id("new_cc");
	private By ccCvvField       = By.id("security_code_new");
	//</editor-fold>

	//<editor-fold desc="Checkout Section">
	private By tosCheckbox1   = By.xpath("//*[@id=\"validation-form\"]/div[7]/div/div/div/p[3]/div/ins");
	private By tosCheckbox2   = By.id("tos-agree");  //By.xpath("//*[@id=\"validation-form\"]/div[7]/div/div/div/p[3]/div/ins");
	private By tosCheckbox3   = By.className("iCheck-helper"); //By.id("tos-agree");  //By.xpath("//*[@id=\"validation-form\"]/div[7]/div/div/div/p[3]/div/ins");
	private By checkoutButton = By.id("final-checkout");
	//</editor-fold>

	//<editor-fold desc="Top Right Sign-in">
	private By regflowTopRightEmailField     = By.id("sign-in-un");
	private By regflowTopRightPasswordField  = By.id("sign-in-pw");
	private By regflowTopRightSignintext     = By.linkText("Sign In!");
	private By regFlowTopRightSigninButton   = By.xpath("//*[@id=\"signup-container\"]/section/div[1]/div/div/div/div[2]/a");
	//</editor-fold>

	//<editor-fold desc="Existing Account Sign-in">
	private By existingAccountPasswordField = By.id("existing-password");
	private By existingAccoiuntLoginButton  = By.id("section-login");
	//</editor-fold>

	//<editor-fold desc="PayPal">
	private By usePayPalTab = By.id("paypal_tab");
	private By paypalRadio        = By.id("paypal");
	//</editor-fold>
	//End of Page Elements

	//Page Functions

	//<editor-fold desc="Top Right Sign-in">
	public void ClickTopRightSignintext()
	{
		driver.findElement(regflowTopRightSignintext).click();
		log.info("Clicked Top Right Sign in Button");
	}

	public void EnterTopRightEmail(String email)
	{
		driver.findElement(regflowTopRightEmailField).sendKeys(email);
		log.info("Entered Existing Email");
	}

	public void EnterTopRightPassword(String password)
	{
		driver.findElement(regflowTopRightPasswordField).sendKeys(password);
		log.info("Clicked Password");
	}

	public void ClickTopRightSigninButton()
	{
		driver.findElement(regFlowTopRightSigninButton).click();
		log.info("Clicked Signin Button");
	}
	//</editor-fold>

	//<editor-fold desc="Login With Existing Account: Middle Sign in">
	public void EnterExistingAccountEmail(String email)
	{
		driver.findElement(emailTextField).sendKeys(email);
		log.info("Entered Existing Email");
	}
	
	public void EnterExistingAccountPassword(String existingAccountPassword)
	{
		driver.findElement(existingAccountPasswordField).sendKeys(existingAccountPassword);
		log.info("Entered Existing Account Password");
	}
	
	public void ClickExistingAccoiuntLoginButton()
	{
		driver.findElement(existingAccoiuntLoginButton).click();
		log.info("Clicked on Logion Button");
	}
	//</editor-fold>

	//<editor-fold desc="Choose a Domain">
	public void ClickIAlreadyOwnThisDomian()
	{
		driver.findElement(iOwnThisDomain).click();
		log.info("Switched to I Already Own This Domain Tab");
	}
	
	public void EnterStoredExistingDomain(String domain)
	{
		driver.findElement(domainTextField).sendKeys(domain);
		log.info("Entered and Stored Existing Domain");
	}		
	
	public void EnterExistingDomain(String domain, String packageName)
	{
		driver.findElement(domainTextField).sendKeys(domain+random.nextInt(10000)+packageName+random.nextInt(100000)+".com");
		log.info("Entered Existing Domain");
	}

	public void EnterDomain(String domain, String packageName)
	{
		driver.findElement(domainTextField).sendKeys(domain+random.nextInt(10000)+packageName+random.nextInt(10000)); //random.nextInt(10000) //date.getTime());
		log.info("Entered New Domain");
	}
	//</editor-fold>

	//<editor-fold desc="Choose a Hosting Plan">
	public void TldDropdown(int index)
	{
		Select s=new Select(driver.findElement(tldSelect));
		s.selectByIndex(index);
		log.info("Selected TLD");
	}
	
	public void BillingDropdown(int index)
	{
		Select s=new Select(driver.findElement(billingDropdown));
		s.selectByIndex(index);
		log.info("Selected billing Term");
	}
	
    
	public void EnterUsername(String username)
	{
		driver.findElement(usernameTextField).sendKeys(username+random.nextInt(50));
		log.info("Entered Username");
	}
	
	public void EnterPin(String pin)
	{
		driver.findElement(pinTextField).sendKeys(pin);
		log.info("Entered Pin");
	}
	//</editor-fold>

	//<editor-fold desc="Enter Your Billing Info">
	public void EnterEmail(String email)
	{
		driver.findElement(emailTextField).sendKeys(email);
		log.info("Entered New Email");
	}
	
	public void EnterConfirmEmail(String email)
	{
		driver.findElement(confirmRmailField).sendKeys(email);
		log.info("Confirmed New Email");
	}
	
	public void EnterFirstName(String firstName)
	{
		driver.findElement(firstNameField).sendKeys(firstName);
		log.info("Entered First Name");
	}
	
	public void EnterLastName(String lastName)
	{
		driver.findElement(lastNameField).sendKeys(lastName);
		log.info("Entered Last Name");
	}
	
	public void EnterPhone(String phone)
	{
		driver.findElement(phoneNumberField).sendKeys(phone);
		log.info("Entered Phone #");
	}
	
	public void EnterAddress1(String address1)
	{
		driver.findElement(address1Field).sendKeys(address1);
		log.info("Entered Adress1");
	}
	
	public void EnterAddress2(String address2)
	{
		driver.findElement(address2Field).sendKeys(address2);
		log.info("Entered Address2");
	}
	
	public void EnterCity(String city)
	{
		driver.findElement(cityField).sendKeys(city);
		log.info("Entered Billing City");
	}
	
	public void EnterZipCode(String zipcode)
	{
		driver.findElement(zipCodeField).sendKeys(zipcode);
		log.info("Entered Billing ZipCode");

	}
	//</editor-fold>


//	public void enterExistingEmail(String domain, String packageName)
//	{
//		driver.findElement(domain_text_field).sendKeys(domain+random.nextInt(10000)+packageName+random.nextInt(100000)+".com");
//	}
	
	//<editor-fold desc="Payment Type: PayPal">
	public void ClickPayPalTab()
	{
		driver.findElement(usePayPalTab).click();
		log.info("Switched to PayPal Tab");
	}
	
	public void ClickPaypalPaymentType() {
		driver.findElement(paypalRadio).click();
		log.info("Selected Paypal Payment type");
	}
	//</editor-fold>

	//<editor-fold desc="Payment Type: Credit Card">
	public void EnterCreditCardName(String ccName)
	{
		driver.findElement(ccCardNameField).sendKeys(ccName);
		log.info("Entered CC Name");
	}
	
	public void EnterCreditCardNumber(String cc)
	{
		driver.findElement(ccNumberField).sendKeys(cc);
		log.info("Entered CC #");
	}
	
	public void EnterCreditCardCVV(String  cvv)
	{
		driver.findElement(ccCvvField).sendKeys(cvv);
		log.info("Entered CC CVV");
	}
	//</editor-fold>

	//<editor-fold desc="Review Order Details and Checkout">
	public void CheckTos1()
	{
		driver.findElement(tosCheckbox1).click();
		log.info("Clicked TOS");
	}
	
	public void TosCheckbox3() //works for shared pkg
	{
		driver.findElement(tosCheckbox3).click();
		log.info("Clicked TOS");
	}
	
	public void ClickCheckout()
	{
		driver.findElement(checkoutButton).click();
		log.info("Clicked Checkout Button");
	}
	//</editor-fold>

	//// from signupcommonflow below///

	PayPalLogin paypalLogin=new PayPalLogin(driver);

	public void EnterEmailAndConfirm(String packageName) {
		String email = "hgtest"+random.nextInt(10000)+packageName +random.nextInt(100000)+ "@endurance.com";
		EnterEmail(email);
		EnterConfirmEmail(email);

	}

	public void enterBillingInfo() {
		EnterFirstName(StaticData.firstName);
		EnterLastName(StaticData.lastName);
		EnterPhone(StaticData.phone);
		EnterAddress1(StaticData.address1);
		EnterAddress2(StaticData.address2);
		EnterCity(StaticData.city);
		EnterZipCode(StaticData.zip);
	}

	public void enterCredirCardInfo() {
		EnterCreditCardName(StaticData.testCreditCardName);
		EnterCreditCardNumber(StaticData.testCreditCardNumber);
		EnterCreditCardCVV(StaticData.testCreditCardCVV);
	}

	public void checkTOSandCheckout() throws InterruptedException {
		Thread.sleep(5000);
		CheckTos1();
		ClickCheckout();

//		Boolean isPresent = driver.findElements(By.xpath("//*[@id=\"results-area\"]/h3")).size() > 0;
////		if ( driver.findElement(By.xpath("//*[@id=\"results-area\"]/h3")) != null ) {
//		if ( isPresent ) {
//
//			System.out.println("Element is visible");
//
//			if ( driver.findElement(By.xpath("//*[@id=\"results-area\"]/h3")).getText().contains("Invalid Domain")  ) {
//
//				log.error("Invalid domain error, retrying...");
//
//				if ( driver.findElement(By.id("new_domain_tab")).getAttribute("class").contains("tab-active") ) {
//
//					driver.findElement(By.id("old_domain_tab")).click();
//					driver.findElement(By.id("new_domain_tab")).click();
//				}
//				else if ( driver.findElement(By.id("old_domain_tab")).getAttribute("class").contains("tab-active") ) {
//
//					driver.findElement(By.id("new_domain_tab")).click();
//					driver.findElement(By.id("old_domain_tab")).click();
//				}
//
//				Thread.sleep(3000);
//				signup.ClickCheckout();
//
//			}
//		}
	}

	public void verifyPaymentComplete() throws InterruptedException {
		//WebDriverWait webWait=new WebDriverWait(driver, 10); /*above is deprecated find alternate explicit wait. See: https://stackoverflow.com/questions/42421148/wait-untilexpectedconditions-doesnt-work-any-more-in-selenium */

		//Adding this to handle regflow's seemingly random invalid domain error

		int waitTime = 30;
		@SuppressWarnings("deprecation")
		WebDriverWait w = new WebDriverWait(driver, waitTime);
		w.until(ExpectedConditions.urlContains("/signup/complete/")); //visibilityOfElementLocated(By.id("new_cc_tab")));
		Assert.assertTrue(driver.getCurrentUrl().contains("/signup/complete/"), "Waited for "+ waitTime +". Did not make it to signup/complete page");


	}

	public void paypalLogin() throws InterruptedException {

		waitUntilID(20, "email");

		paypalLogin.enterPayPalEmail(StaticData.payPalEmail);
		paypalLogin.clickPayPalNextButton();
		paypalLogin.enterPayPalPassword(StaticData.payPalPassword);
//		paypalLogin.unCheckStayLoggedIn();
		paypalLogin.clickPayPalLoginButton();
		Thread.sleep(10000); //replace with explicit

		Boolean notNow = driver.findElements(By.id("notNowLink")).size() > 0 ;
		if (notNow) {

			driver.findElement(By.id("notNowLink")).click();

		}

		paypalLogin.clickPayPalContinueButton();

//		Thread.sleep(8000); //replace with explicit
		waitUntilID(10, "confirmButtonTop");
		paypalLogin.clickPaypalAgreeAndContinuebutton();

	}

	public void topRightSignIn(String email) {
		ClickTopRightSignintext();
		EnterTopRightEmail(email);
		EnterTopRightPassword(StaticData.portalPassword);
		ClickTopRightSigninButton();
	}

	public void existingEmailSignIn(String existingEmail, String password) throws InterruptedException {

		EnterExistingAccountEmail(existingEmail);

		WebElement webElement = driver.findElement(By.id("new-email"));
		webElement.sendKeys(Keys.TAB);

		@SuppressWarnings("deprecation")
		WebDriverWait w = new WebDriverWait(driver, 20);
		w.until(ExpectedConditions.visibilityOfElementLocated(existingAccountPasswordField));

		EnterExistingAccountPassword(password);
		ClickExistingAccoiuntLoginButton();

//		@SuppressWarnings("deprecation")
//		WebDriverWait w = new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("new_cc_tab")));
	}
}
