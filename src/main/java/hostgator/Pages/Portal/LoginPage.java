package hostgator.Pages.Portal;

import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	private static Logger log = LogManager.getLogger(LoginPage.class.getName());

	
	private WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	

	By emailField    = By.id("email");
	By nextButton    = By.id("loginBtn"); 
	By passwordField = By.id("password"); 
	By loginButton   = By.id("loginBtn"); 
	
	public void EnterExistingAccountEmail(String email)
	{
		driver.findElement(emailField).sendKeys(email);
		log.info("Entered Existing Email");
	}
	
	public void ClickNextButton()
	{
		driver.findElement(nextButton).click();
		log.info("Clicked Next");
	}
	
	public void EnterExistingAccountPassword(String password)
	{
		driver.findElement(passwordField).sendKeys(password);
		log.info("Entered Password");
	}
	
	public void ClickLoginButton()
	{
		driver.findElement(loginButton).click();
		log.info("Clicked Login");
	}
	
	public void PortalLogin(String email, String password)
	{
		EnterExistingAccountEmail(email);
		ClickNextButton();
		EnterExistingAccountPassword(password);
		ClickLoginButton();
		
		@SuppressWarnings("deprecation")
		WebDriverWait w = new WebDriverWait(driver, 15);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("home-container")));
	}
	
}
