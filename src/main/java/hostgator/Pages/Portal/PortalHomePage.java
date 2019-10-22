package hostgator.Pages.Portal;

import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PortalHomePage {
	
	private static Logger log = LogManager.getLogger(PortalHomePage.class.getName());

	
	private WebDriver driver;
	public PortalHomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	

	By billingNav  = By.xpath("//*[@id=\"billing-nav-link\"]/a/span[2]"); //By.id("billing-nav-link");
	By makePayment = By.linkText("Make a Payment");
	By nextButton    = By.id("loginBtn"); 
	By passwordField = By.id("password"); 
	By loginButton   = By.id("loginBtn"); 
	
	public void clickBillingNav()
	{
		driver.findElement(billingNav).click();
		log.info("Clicked Billing Nav");
	}
	
	public void clickMakePayment()
	{
		driver.findElement(makePayment).click();
		log.info("Clicked Make a Payment");
	}
	
	
}
