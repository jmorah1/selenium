package com.hostgator.signupPages;

import java.util.Date;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class Signuppage{

	Date date= new Date();
	
	private static Logger log = LogManager.getLogger(Signuppage.class.getName());

	
	private WebDriver driver;
	public Signuppage(WebDriver driver)
	{
		this.driver=driver;
	}
	

	By i_own_this_domain   = By.id("old_domain_tab");
	By domain_text_field   = By.id("domain_field");
	By tld_select          = By.id("tld_select");
	By billingdropdown     = By.id("billing_cycle");
	By username_text_field = By.xpath("//*[@id=\"username\"]");
	By pin_text_field      = By.id("new_pin");
	By email_text_field    = By.id("new-email");			
	By confirm_email_field = By.id("new-email-confirm");
	By first_name          = By.id("new-first-name");		
	By last_name           = By.id("new-last-name");
	By phone_number        = By.id("hphone");
	By address1_field      = By.id("new-address1");
	By address2_filed      = By.id("new-address2");
	By city_field          = By.id("new-city");
	By zip_code_field      = By.id("zip_code");
	By paypal_radio        = By.id("paypal");
	By cc_card_name_field  = By.id("new-name-on-card");
	By cc_number_field     = By.id("new_cc");
	By cc_cvv_field        = By.id("security_code_new");
	By tos_checkbox        = By.xpath("//*[@id=\"validation-form\"]/div[7]/div/div/div/p[3]/div/ins"); //By.id("tos-agree");  //By.xpath("//*[@id=\"validation-form\"]/div[7]/div/div/div/p[3]/div/ins");
	By checkout_button     = By.id("final-checkout");
	
	

	public void clickIAlreadyOwnThisDomian()
	{
		driver.findElement(i_own_this_domain).click();;
	}
	
	public void enterExistingDomain(String domain)
	{
		driver.findElement(domain_text_field).sendKeys(domain+date.getTime()+".com");
	}
	
	public void enterDomain(String domain)
	{
		driver.findElement(domain_text_field).sendKeys(domain+date.getTime());
	}
	
	public void tldDropdown(int index)
	{
		Select s=new Select(driver.findElement(tld_select));
		s.selectByIndex(index);
	}
	
	public void billingDropdown(int index)
	{
		Select s=new Select(driver.findElement(billingdropdown));
		s.selectByIndex(index);
	}
	
	Random random = new Random();
    
	public void enterUsername(String username)
	{
		driver.findElement(username_text_field).sendKeys(username+random.nextInt(50)); 
	}
	
	public void enterPin(String pin)
	{
		driver.findElement(pin_text_field).sendKeys(pin);;
	}
	
	public void enterEmail(String email)
	{
		driver.findElement(email_text_field).sendKeys(email);; 
	}
	
	public void enterConfirmEmail(String email)
	{
		driver.findElement(confirm_email_field).sendKeys(email); 
	}
	
	public void enterFirstName(String firstName)
	{
		driver.findElement(first_name).sendKeys(firstName);; 
	}
	
	public void enterLastName(String lastName)
	{
		driver.findElement(last_name).sendKeys(lastName);; 
	}
	
	public void enterPhone(String phone)
	{
		driver.findElement(phone_number).sendKeys(phone);; 
	}
	
	public void enterAddress1(String address1)
	{
		driver.findElement(address1_field).sendKeys(address1);; 
	}
	
	public void enterAddress2(String address2)
	{
		driver.findElement(address2_filed).sendKeys(address2);; 
	}
	
	public void enterCity(String city)
	{
		driver.findElement(city_field).sendKeys(city);
		log.info("Entered Billing City");
	}
	
	public void enterZipCode(String zipcode)
	{
		driver.findElement(zip_code_field).sendKeys(zipcode);
		log.info("Entered ZipCode");

	}
	
	public void clickPaypalPaymentType() {
		driver.findElement(paypal_radio).click();
	}
	
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
	
	public void checkTos()
	{
		driver.findElement(tos_checkbox).click();
		log.info("Clicked TOS");
	}
	
	public void clickCheckout()
	{
		driver.findElement(checkout_button).click();
		log.info("Clicked Checkout Button");
	}
	
}
