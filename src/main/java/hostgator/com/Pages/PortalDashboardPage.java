package hostgator.com.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PortalDashboardPage{

	private WebDriver driver;
	public PortalDashboardPage(WebDriver  driver)
	{
		this.driver=driver;
	}
	
	By sampleElement = By.id("sampleElement");

	public void sampleStep()
	{
		driver.findElement(sampleElement).click();
	}
	
}
