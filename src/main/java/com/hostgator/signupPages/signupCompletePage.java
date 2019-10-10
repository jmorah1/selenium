package com.hostgator.signupPages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class signupCompletePage{

	private WebDriver driver;
	public signupCompletePage(WebDriver  driver)
	{
		this.driver=driver;
	}
	
	By paymentCompleteSection = By.xpath("//*[@id=\"welcome-section\"]");

	public void VerifypaymentComplete()
	{
		driver.findElement(paymentCompleteSection).isDisplayed();
	}
	
}
