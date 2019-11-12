package hostgator.pages.signup;

import java.util.Date;
import java.util.List;
import java.util.Random;

import hostgator.pages.paypal.PayPalLogin;
import hostgator.driver.TestDriver;
import hostgator.util.StaticData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Signuppage extends TestDriver {

	Date date= new Date();
	Random random = new Random();

	private static Logger log = LogManager.getLogger(Signuppage.class.getName());

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
	private By firstNameField    = By.id("new-first-name");
	private By lastNameField     = By.id("new-last-name");
	private By phoneNumberField  = By.id("hphone");
	private By address1Field     = By.id("new-address1");
	private By address2Field     = By.id("new-address2");
	private By cityField         = By.id("new-city");
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
	private By logoutlink = By.xpath("//*[@id=\"signup-container\"]/section/div[1]/div/div/a");
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
	public void clickTopRightSignintext()
	{
		driver.findElement(regflowTopRightSignintext).click();
		log.info("Clicked Top Right Sign in Button");
	}

	public void enterTopRightEmail(String email)
	{
		driver.findElement(regflowTopRightEmailField).sendKeys(email);
		log.info("Entered Existing Email");
	}

	public void enterTopRightPassword(String password)
	{
		driver.findElement(regflowTopRightPasswordField).sendKeys(password);
		log.info("Clicked Password");
	}

	public void clickTopRightSigninButton()
	{
		driver.findElement(regFlowTopRightSigninButton).click();
		log.info("Clicked Signin Button");
	}
	//</editor-fold>

	//<editor-fold desc="Login With Existing Account: Middle Sign in">
	public void enterExistingAccountEmail(String email)
	{
		driver.findElement(emailTextField).sendKeys(email);
		log.info("Entered Existing Email");
	}

	public void enterExistingAccountPassword(String existingAccountPassword)
	{
		driver.findElement(existingAccountPasswordField).sendKeys(existingAccountPassword);
		log.info("Entered Existing Account Password");
	}

	public void clickExistingAccoiuntLoginButton()
	{
		driver.findElement(existingAccoiuntLoginButton).click();
		log.info("Clicked on Logion Button");
	}
	//</editor-fold>

	//<editor-fold desc="Choose a Domain">
	public void clickIAlreadyOwnThisDomian()
	{
		driver.findElement(iOwnThisDomain).click();
		log.info("Switched to I Already Own This Domain Tab");
	}

	public void enterStoredExistingDomain(String domain)
	{
		driver.findElement(domainTextField).sendKeys(domain);
		log.info("Entered and Stored Existing Domain");
	}

	public void enterExistingDomain(String domain, String packageName)
	{
		String existingDomain = domain+random.nextInt(10000)+packageName+random.nextInt(100000)+".com";
		driver.findElement(domainTextField).sendKeys(existingDomain);
		driver.findElement(domainTextField).sendKeys(Keys.TAB);
		verifyDomainIsValid();
		log.info("Entered and Verified Existing Domain");
	}

	public void enterDomain(String domain, String packageName)
	{
		driver.findElement(domainTextField).sendKeys(domain+random.nextInt(10000)+packageName+random.nextInt(10000)); //random.nextInt(10000) //date.getTime());
		log.info("Entered New Domain");
	}
	//</editor-fold>

	public void verifyDomainIsValid ()
	{
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.withMessage("No Valid Domain search results\n");
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"results-area\"]/div[1]/div/div/div/div[1]/label/span[2]"), "PRIMARY DOMAIN"));
	}

	//<editor-fold desc="Choose a Hosting Plan">
	public void tldDropdown(int index)
	{
		Select s=new Select(driver.findElement(tldSelect));
		s.selectByIndex(index);
		log.info("Selected TLD");
	}

	public void billingDropdown(int index)
	{
		Select s=new Select(driver.findElement(billingDropdown));
		s.selectByIndex(index);
		log.info("Selected billing Term");
	}


	public void enterUsername(String username)
	{
		driver.findElement(usernameTextField).sendKeys(username+random.nextInt(50));
		log.info("Entered Username");
	}

	public void enterPin(String pin)
	{
		driver.findElement(pinTextField).sendKeys(pin);
		log.info("Entered Pin");
	}
	//</editor-fold>

	//<editor-fold desc="Enter Your Billing Info">
	public void enterEmail(String email)
	{
		driver.findElement(emailTextField).sendKeys(email);
		log.info("Entered New Email");
	}

	public void enterConfirmEmail(String email)
	{
		driver.findElement(confirmRmailField).sendKeys(email);
		log.info("Confirmed New Email");
	}

	public void enterFirstName(String firstName)
	{
		driver.findElement(firstNameField).sendKeys(firstName);
		log.info("Entered First Name");
	}

	public void enterLastName(String lastName)
	{
		driver.findElement(lastNameField).sendKeys(lastName);
		log.info("Entered Last Name");
	}

	public void enterPhone(String phone)
	{
		driver.findElement(phoneNumberField).sendKeys(phone);
		log.info("Entered Phone #");
	}

	public void enterAddress1(String address1)
	{
		driver.findElement(address1Field).sendKeys(address1);
		log.info("Entered Adress1");
	}

	public void enterAddress2(String address2)
	{
		driver.findElement(address2Field).sendKeys(address2);
		log.info("Entered Address2");
	}

	public void enterCity(String city)
	{
		driver.findElement(cityField).sendKeys(city);
		log.info("Entered Billing City");
	}

	public void enterZipCode(String zipcode)
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
	public void clickPayPalTab()
	{
		driver.findElement(usePayPalTab).click();
		log.info("Switched to PayPal Tab");
	}

	public void clickPaypalPaymentType() {
		driver.findElement(paypalRadio).click();
		log.info("Selected Paypal Payment type");
	}
	//</editor-fold>

	//<editor-fold desc="Payment Type: Credit Card">
	public void enterCreditCardName(String ccName)
	{
		driver.findElement(ccCardNameField).sendKeys(ccName);
		log.info("Entered CC Name");
	}

	public void enterCreditCardNumber(String cc)
	{
		driver.findElement(ccNumberField).sendKeys(cc);
		log.info("Entered CC #");
	}

	public void enterCreditCardCVV(String  cvv)
	{
		driver.findElement(ccCvvField).sendKeys(cvv);
		log.info("Entered CC CVV");
	}
	//</editor-fold>

	//<editor-fold desc="Review Order Details and Checkout">
	public void checkTos1()
	{
		driver.findElement(tosCheckbox1).click();
		log.info("Clicked TOS");
	}

	public void tosCheckbox3() //works for shared pkg
	{
		driver.findElement(tosCheckbox3).click();
		log.info("Clicked TOS");
	}

	public void clickCheckout()
	{
		driver.findElement(checkoutButton).click();
		log.info("Clicked Checkout Button");
	}
	//</editor-fold>

	public void verifyPaymentComplete() throws InterruptedException {
		int waitTime = 30;
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(
				ExpectedConditions.or(
						ExpectedConditions.urlContains("/signup/complete/"),
						ExpectedConditions.urlContains("billing/invoice/pay/select"),
						ExpectedConditions.urlContains("paypal")
				)
		);

		if (driver.getCurrentUrl().contains("billing/invoice/pay/select")) {
			log.warn("Payment error");

			List<WebElement> paypalError = driver.findElements(By.xpath("//*[@id=\"gbclient\"]/div[5]/div/div[2]/div[1]/div/div/p"));

			if ( paypalError.size() > 0 )  {
				log.info("Error message: "+paypalError.get(0).getText());
				Assert.fail("Issue with paypal");
			}
		} else if (driver.getCurrentUrl().contains("/signup/complete/")) {
			log.info("Signup Complete");
		} else if (driver.findElement(By.id("email")).isDisplayed()) { //replace this with paypallink when its working

			paypalLogin();

		} else if (true){
			Thread.sleep(99999999);
		}
	}

//		Assert.assertTrue(driver.getCurrentUrl().contains("/signup/complete/"), "Waited for "+ waitTime +". Did not make it to signup/complete page");
//
//		try{
//			Assert.assertEquals(...,...);
//		}catch(AssertionError e){
//			Log error;
//			Takescreenshot;
//		}
//
//		log.info("Signup Complete");
//	}

	public void paypalLogin() throws InterruptedException {
		waitUntilID(20, "email");
		PayPalLogin paypalLogin=new PayPalLogin(driver);

		paypalLogin.enterPayPalEmail(StaticData.PAYPAL_EMAIL);
		paypalLogin.clickPayPalNextButton();
		paypalLogin.enterPayPalPassword(StaticData.PAYPAL_PASSWORD);
//		paypalLogin.unCheckStayLoggedIn();
		paypalLogin.clickPayPalLoginButton();
//		Boolean notNow = driver.findElements(By.id("notNowLink")).size() > 0 ;
//		if (notNow) {
//
//			driver.findElement(By.id("notNowLink")).click();
//
//		}
//		paypalLogin.clickPayPalContinueButton();
		paypalLogin.clickPayPalContinueButton2();
//		paypalLogin.clickPaypalAgreeAndContinuebutton();
		paypalLogin.clickPaypalAgreeAndContinuebutton2();
	}

	public void topRightSignIn(String email) {
		clickTopRightSignintext();
		enterTopRightEmail(email);
		enterTopRightPassword(StaticData.PORTAL_PASSWORD);
		clickTopRightSigninButton();
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.withMessage("Login Failed");
		wait.until(ExpectedConditions.textToBePresentInElementLocated(logoutlink, "Logout"));

	}

	public void existingEmailSignIn(String existingEmail, String password) throws InterruptedException {
		enterExistingAccountEmail(existingEmail);

		WebElement webElement = driver.findElement(By.id("new-email"));
		webElement.sendKeys(Keys.TAB);

		@SuppressWarnings("deprecation")
		WebDriverWait w = new WebDriverWait(driver, 20);
		w.until(ExpectedConditions.visibilityOfElementLocated(existingAccountPasswordField));

		enterExistingAccountPassword(password);
		clickExistingAccoiuntLoginButton();

		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("new_cc_tab")));
	}

	public void waitForSummaryTable() {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				WebElement summaryTable = driver.findElement(By.id("summary-table"));
				String classAttribute = summaryTable.getAttribute("class");

//					System.out.println("\n"+classAttribute+"\n");
				if(classAttribute.contains("processing")) {
					log.info("Summary page is still loading: "+classAttribute);
					return false;
				}
				else
					return true;
			}
		});
	}
}
