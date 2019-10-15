package com.hostgator.signupPages;



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
	By paypal_continue_button= By.id("//*[@id=\"button\"]/button");
	
	public void enterPayPalEmail(String payPalEmail)
	{
		driver.findElement(paypal_email_field).sendKeys(payPalEmail);
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
	
}