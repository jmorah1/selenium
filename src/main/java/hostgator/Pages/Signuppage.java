package hostgator.Pages;

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

	//Domain Section
	By i_own_this_domain = By.id("old_domain_tab");
	By domain_text_field = By.id("domain_field");
	
	//Hosting Plan
	By tld_select          = By.id("tld_select");
	By billingdropdown     = By.id("billing_cycle");
	By username_text_field = By.xpath("//*[@id=\"username\"]");
	By pin_text_field      = By.id("new_pin");
	
	// Billing Info Section
	By email_text_field    = By.id("new-email");			
	By confirm_email_field = By.id("new-email-confirm");
	By first_name          = By.id("new-first-name");		
	By last_name           = By.id("new-last-name");
	By phone_number        = By.id("hphone");
	By address1_field      = By.id("new-address1");
	By address2_filed      = By.id("new-address2");
	By city_field          = By.id("new-city");
	By zip_code_field      = By.id("zip_code");
	
	// Credit Card Payment Type
	By cc_card_name_field = By.id("new-name-on-card");
	By cc_number_field    = By.id("new_cc");
	By cc_cvv_field       = By.id("security_code_new");
	
	//Checkout Section
	By tos_checkbox1   = By.xpath("//*[@id=\"validation-form\"]/div[7]/div/div/div/p[3]/div/ins"); 
	By tos_checkbox2   = By.id("tos-agree");  //By.xpath("//*[@id=\"validation-form\"]/div[7]/div/div/div/p[3]/div/ins");
	By tos_checkbox3   = By.className("iCheck-helper"); //By.id("tos-agree");  //By.xpath("//*[@id=\"validation-form\"]/div[7]/div/div/div/p[3]/div/ins");
	By checkout_button = By.id("final-checkout");
	
	//Top Right Sign in
	By regflowTopRightEmailField     = By.id("sign-in-un");
	By regflowTopRightPasswordField  = By.id("sign-in-pw"); 
	By regflowTopRightSignintext     = By.linkText("Sign In!");
	By regFlowTopRightSigninButton   = By.xpath("//*[@id=\"signup-container\"]/section/div[1]/div/div/div/div[2]/a");
	
	//Existing account sign in 
	By existingAccountPasswordField = By.id("existing-password"); 
	By existingAccoiuntLoginButton  = By.id("section-login");
	
	//PayPAl
	By usePayPalTab = By.id("paypal_tab");
	By paypal_radio        = By.id("paypal");

	public void enterExistingAccountEmail(String email)
	{
		driver.findElement(email_text_field).sendKeys(email);
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
	
	// Regflow 1
	//Domain Section
	public void clickIAlreadyOwnThisDomian()
	{
		driver.findElement(i_own_this_domain).click();
		log.info("Switched to I Already Own This Domain Tab");
	}
	
	public void enterStoredExistingDomain(String domain)
	{
		driver.findElement(domain_text_field).sendKeys(domain);
		log.info("Entered and Stored Existing Domain");
	}		
	
	public void enterExistingDomain(String domain, String packageName)
	{
		driver.findElement(domain_text_field).sendKeys(domain+random.nextInt(10000)+packageName+random.nextInt(100000)+".com");
		log.info("Entered Existing Domain");
	}

	public void enterDomain(String domain, String packageName)
	{
		driver.findElement(domain_text_field).sendKeys(domain+random.nextInt(10000)+packageName+random.nextInt(10000)); //random.nextInt(10000) //date.getTime());
		log.info("Entered New Domain");
	}
	
	//Hosting Plan
	public void tldDropdown(int index)
	{
		Select s=new Select(driver.findElement(tld_select));
		s.selectByIndex(index);
		log.info("Selected TLD");
	}
	
	public void billingDropdown(int index)
	{
		Select s=new Select(driver.findElement(billingdropdown));
		s.selectByIndex(index);
		log.info("Selected billing Term");
	}
	
    
	public void enterUsername(String username)
	{
		driver.findElement(username_text_field).sendKeys(username+random.nextInt(50));
		log.info("Entered Username");
	}
	
	public void enterPin(String pin)
	{
		driver.findElement(pin_text_field).sendKeys(pin);
		log.info("Entered Pin");
	}
	
	
	// RegFlow 3
	//// Billing Info Section
	public void enterEmail(String email)
	{
		driver.findElement(email_text_field).sendKeys(email);
		log.info("Entered New Email");
	}
	
	public void enterConfirmEmail(String email)
	{
		driver.findElement(confirm_email_field).sendKeys(email);
		log.info("Confirmed New Email");
	}
	
	public void enterFirstName(String firstName)
	{
		driver.findElement(first_name).sendKeys(firstName);
		log.info("Entered First Name");
	}
	
	public void enterLastName(String lastName)
	{
		driver.findElement(last_name).sendKeys(lastName);
		log.info("Entered Last Name");
	}
	
	public void enterPhone(String phone)
	{
		driver.findElement(phone_number).sendKeys(phone);
		log.info("Entered Phone #");
	}
	
	public void enterAddress1(String address1)
	{
		driver.findElement(address1_field).sendKeys(address1);
		log.info("Entered Adress1");
	}
	
	public void enterAddress2(String address2)
	{
		driver.findElement(address2_filed).sendKeys(address2);
		log.info("Entered Address2");
	}
	
	public void enterCity(String city)
	{
		driver.findElement(city_field).sendKeys(city);
		log.info("Entered Billing City");
	}
	
	public void enterZipCode(String zipcode)
	{
		driver.findElement(zip_code_field).sendKeys(zipcode);
		log.info("Entered Billing ZipCode");

	}
	
//	public void enterExistingEmail(String domain, String packageName)
//	{
//		driver.findElement(domain_text_field).sendKeys(domain+random.nextInt(10000)+packageName+random.nextInt(100000)+".com");
//	}
	
	
	//PayPAl
	public void clickPayPalTab()
	{
		driver.findElement(usePayPalTab).click();
		log.info("Switched to PayPal Tab");
	}
	
	public void clickPaypalPaymentType() {
		driver.findElement(paypal_radio).click();
		log.info("Selected Paypal Payment type");
	}
	
	
	//Top Right Sign in
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
	

	// RegFlow 3
	// Credit Card Payment Type
	public void enterCreditCardName(String ccName)
	{
		driver.findElement(cc_card_name_field).sendKeys(ccName);
		log.info("Entered CC Name");
	}
	
	public void enterCreditCardNumber(String cc)
	{
		driver.findElement(cc_number_field).sendKeys(cc);
		log.info("Entered CC #");
	}
	
	public void enterCreditCardCVV(String  cvv)
	{
		driver.findElement(cc_cvv_field).sendKeys(cvv);
		log.info("Entered CC CVV");
	}
	
	
	// RegFlow 6
	// Checkout Section
	public void checkTos1()
	{
		driver.findElement(tos_checkbox1).click();
		log.info("Clicked TOS");
	}
	
	public void tos_checkbox3() //works for shared pkg
	{
		driver.findElement(tos_checkbox3).click();
		log.info("Clicked TOS");
	}
	
	public void clickCheckout()
	{
		driver.findElement(checkout_button).click();
		log.info("Clicked Checkout Button");
	}
	
}
