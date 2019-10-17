package com.hostagtor.loginPage;

import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage{
	
	private static Logger log = LogManager.getLogger(LoginPage.class.getName());

	
	private WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	

	By paypal_email_field    = By.id("email");
	By paypal_next_buttom    = By.id("btnNext"); 
	By paypal_password_field = By.id("password"); 
	By paypal_login_button   = By.id("btnLogin"); 
	By paypal_continue_button= By.xpath("//*[@id=\"button\"]/button");
	
	public void enterEmail(String payPalEmail)
	{
//		log.info("Entered PayPal Email");
	}
	
	public void clickNextButton()
	{
//		log.info("Clicked Next");
	}
	
	public void enterPassword(String paypalPassword)
	{
//		log.info("Entered PayPal Password");
	}
	
	public void clickLogin()
	{
//		log.info("Clicked PayPal Login");
	}
	
	public void clickPayPalContinueButton()
	{
//		log.info("Clicked PayPal Continue");
	}
	
}
