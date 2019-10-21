package hostgator.com.CommonFlow;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.hostgator.driver.TestDriver;
import com.hostgator.util.StaticData;

import hostgator.com.Pages.PayPalLogin;
import hostgator.com.Pages.Signuppage;
import hostgator.com.Pages.signupCompletePage;

public class SignupCommonFlow extends TestDriver{

	Random random = new Random();

	Signuppage signup=new Signuppage(driver);
	signupCompletePage signupComplete=new signupCompletePage(driver);
	PayPalLogin paypalLogin=new PayPalLogin(driver);
	
	public void enterEmailAndConfirm(String packageName) {
		String email = "hgtest"+random.nextInt(10000)+packageName +random.nextInt(100000)+ "@endurance.com";
		signup.enterEmail(email);
		signup.enterConfirmEmail(email);
	
	}
	
	public void enterBillingInfo() {
		signup.enterFirstName(StaticData.firstName);
		signup.enterLastName(StaticData.lastName);
		signup.enterPhone(StaticData.phone);
		signup.enterAddress1(StaticData.address1);
		signup.enterAddress2(StaticData.address2);
		signup.enterCity(StaticData.city);
		signup.enterZipCode(StaticData.zip);
	}
	
	public void enterCredirCardInfo() {
		signup.enterCreditCardName(StaticData.testCreditCardName);
		signup.enterCreditCardNumber(StaticData.testCreditCardNumber);
		signup.enterCreditCardCVV(StaticData.testCreditCardCVV);
	}
	
	public void checkTOSandCheckout() throws InterruptedException {
		Thread.sleep(5000);
		signup.checkTos1();
		signup.clickCheckout();
		
//		Boolean isPresent = driver.findElements(By.xpath("//*[@id=\"results-area\"]/h3")).size() > 0;
////		if ( driver.findElement(By.xpath("//*[@id=\"results-area\"]/h3")) != null ) {
//		if ( isPresent ) {
//			
//			System.out.println("Element is visible");				
//			
//			if ( driver.findElement(By.xpath("//*[@id=\"results-area\"]/h3")).getText().contains("Invalid Domain")  ) {
//				
//				log.error("Invalid domain error, retrying...");
//				
//				if ( driver.findElement(By.id("new_domain_tab")).getAttribute("class").contains("tab-active") ) {
//					
//					driver.findElement(By.id("old_domain_tab")).click();
//					driver.findElement(By.id("new_domain_tab")).click();
//				} 
//				else if ( driver.findElement(By.id("old_domain_tab")).getAttribute("class").contains("tab-active") ) {
//
//					driver.findElement(By.id("new_domain_tab")).click();
//					driver.findElement(By.id("old_domain_tab")).click();
//				}
//				
//				Thread.sleep(3000);
//				signup.clickCheckout();
//			
//			}
//		}
	}
	
	public void verifyPaymentComplete() throws InterruptedException {
		//WebDriverWait webWait=new WebDriverWait(driver, 10); /*above is deprecated find alternate explicit wait. See: https://stackoverflow.com/questions/42421148/wait-untilexpectedconditions-doesnt-work-any-more-in-selenium */

		//Adding this to handle regflow's seemingly random invalid domain error 

		int waitTime = 30;
		@SuppressWarnings("deprecation")
		WebDriverWait w = new WebDriverWait(driver, waitTime);
		w.until(ExpectedConditions.urlContains("/signup/complete/")); //visibilityOfElementLocated(By.id("new_cc_tab")));
		Assert.assertTrue(driver.getCurrentUrl().contains("/signup/complete/"), "Waited for "+ waitTime +". Did not make it to signup/complete page");
		
	
	}
	
	public void paypalLogin() throws InterruptedException {

		waitUntilID(20, "email");
		
		paypalLogin.enterPayPalEmail(StaticData.payPalEmail);
		paypalLogin.clickPayPalNextButton();
		paypalLogin.enterPayPalPassword(StaticData.payPalPassword);
//		paypalLogin.unCheckStayLoggedIn();
		paypalLogin.clickPayPalLoginButton();
		Thread.sleep(10000); //replace with explicit 
		
		Boolean notNow = driver.findElements(By.id("notNowLink")).size() > 0 ;
		if (notNow) {

			driver.findElement(By.id("notNowLink")).click();

		}
		
		paypalLogin.clickPayPalContinueButton();
		
//		Thread.sleep(8000); //replace with explicit
		waitUntilID(10, "confirmButtonTop");
		paypalLogin.clickPaypalAgreeAndContinuebutton();

	}
	
	public void topRightSignIn(String email) {
		signup.clickTopRightSignintext();
		signup.enterTopRightEmail(email);
		signup.enterTopRightPassword(StaticData.portalPassword); 
		signup.clickTopRightSigninButton();
	}

	public void existingEmailSignIn(String existingEmail, String password) throws InterruptedException {
		
		signup.enterExistingAccountEmail(existingEmail);
		
		WebElement webElement = driver.findElement(By.id("new-email"));
		webElement.sendKeys(Keys.TAB);
		
		signup.enterExistingAccountPassword(password);
		signup.clickExistingAccoiuntLoginButton();
		
		@SuppressWarnings("deprecation")
		WebDriverWait w = new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("new_cc_tab")));
	}
}
