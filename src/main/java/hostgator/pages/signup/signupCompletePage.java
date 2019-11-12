package hostgator.pages.signup;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class signupCompletePage{

	private static Logger log = LogManager.getLogger(signupCompletePage.class.getName());
	private WebDriver driver;
	public signupCompletePage(WebDriver  driver)
	{
		this.driver=driver;
	}
	
	private By _paymentCompleteSection = By.xpath("//*[@id=\"welcome-section\"]");

	public void VerifypaymentComplete()
	{
		driver.findElement(_paymentCompleteSection).isDisplayed();
		log.info("Verified Payment Complete URL");
	}
	
}
