package hostgator.Pages.Signup;

import java.util.Date;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Signuppage{

	Date date= new Date();
	Random random = new Random();

	private static Logger log = LogManager.getLogger(Signuppage.class.getName());

	
	private WebDriver driver;
	public Signuppage(WebDriver driver)
	{
		this.driver=driver;
	}
	//Page Elements
	//<editor-fold desc="Domain Section">
	By iOwnThisDomain = By.id("old_domain_tab");
	By domainTextField = By.id("domain_field");
	//</editor-fold>

	//<editor-fold desc="Hosting Plan">
	By tldSelect          = By.id("tld_select");
	By billingDropdown     = By.id("billing_cycle");
	By usernameTextField = By.xpath("//*[@id=\"username\"]");
	By pinTextField      = By.id("new_pin");
	//</editor-fold>

	//<editor-fold desc="Billing Info Section">
	By emailTextField    = By.id("new-email");
	By confirmRmailField = By.id("new-email-confirm");
	By firstNameField          = By.id("new-first-name");
	By lastNameField           = By.id("new-last-name");
	By phoneNumberField        = By.id("hphone");
	By address1Field      = By.id("new-address1");
	By address2Field      = By.id("new-address2");
	By cityField          = By.id("new-city");
	By zipCodeField      = By.id("zip_code");
	//</editor-fold>

	//<editor-fold desc="Credit Card Payment Type">
	By ccCardNameField = By.id("new-name-on-card");
	By ccNumberField    = By.id("new_cc");
	By ccCvvField       = By.id("security_code_new");
	//</editor-fold>

	//<editor-fold desc="Checkout Section">
	By tosCheckbox1   = By.xpath("//*[@id=\"validation-form\"]/div[7]/div/div/div/p[3]/div/ins");
	By tosCheckbox2   = By.id("tos-agree");  //By.xpath("//*[@id=\"validation-form\"]/div[7]/div/div/div/p[3]/div/ins");
	By tosCheckbox3   = By.className("iCheck-helper"); //By.id("tos-agree");  //By.xpath("//*[@id=\"validation-form\"]/div[7]/div/div/div/p[3]/div/ins");
	By checkoutButton = By.id("final-checkout");
	//</editor-fold>

	//<editor-fold desc="Top Right Sign-in">
	By regflowTopRightEmailField     = By.id("sign-in-un");
	By regflowTopRightPasswordField  = By.id("sign-in-pw"); 
	By regflowTopRightSignintext     = By.linkText("Sign In!");
	By regFlowTopRightSigninButton   = By.xpath("//*[@id=\"signup-container\"]/section/div[1]/div/div/div/div[2]/a");
	//</editor-fold>

	//<editor-fold desc="Existing Account Sign-in">
	By existingAccountPasswordField = By.id("existing-password"); 
	By existingAccoiuntLoginButton  = By.id("section-login");
	//</editor-fold>

	//<editor-fold desc="PayPal">
	By usePayPalTab = By.id("paypal_tab");
	By paypalRadio        = By.id("paypal");
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
}
