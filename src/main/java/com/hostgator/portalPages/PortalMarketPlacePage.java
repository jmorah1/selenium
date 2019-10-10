package com.hostgator.portalPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PortalMarketPlacePage{
	
	private WebDriver driver;
	public PortalMarketPlacePage(WebDriver  driver)
	{
		this.driver=driver;
	}
	

	By sampleElement = By.id("sampleElement");

	public void sampleStep()
	{
		driver.findElement(sampleElement).click();
	}
	
}
