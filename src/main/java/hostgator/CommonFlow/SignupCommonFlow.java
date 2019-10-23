package hostgator.CommonFlow;

import java.util.Random;

import hostgator.Pages.PayPal.PayPalLogin;
import hostgator.Pages.Signup.Signuppage;
import hostgator.Pages.Signup.signupCompletePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import hostgator.driver.TestDriver;
import hostgator.util.com.hostgator.util.StaticData;

public class SignupCommonFlow extends TestDriver{

	Random random = new Random();

	Signuppage signup=new Signuppage(driver);
	signupCompletePage signupComplete=new signupCompletePage(driver);
	PayPalLogin paypalLogin=new PayPalLogin(driver);
	
	public void EnterEmailAndConfirm(String packageName) {
		String email = "hgtest"+random.nextInt(10000)+packageName +random.nextInt(100000)+ "@endurance.com";
		signup.EnterEmail(email);
		signup.EnterConfirmEmail(email);
	
	}
	
	public void enterBillingInfo() {
		signup.EnterFirstName(StaticData.firstName);
		signup.EnterLastName(StaticData.lastName);
		signup.EnterPhone(StaticData.phone);
		signup.EnterAddress1(StaticData.address1);
		signup.EnterAddress2(StaticData.address2);
		signup.EnterCity(StaticData.city);
		signup.EnterZipCode(StaticData.zip);
	}
	
	public void enterCredirCardInfo() {
		signup.EnterCreditCardName(StaticData.testCreditCardName);
		signup.EnterCreditCardNumber(StaticData.testCreditCardNumber);
		signup.EnterCreditCardCVV(StaticData.testCreditCardCVV);
	}
	
	public void checkTOSandCheckout() throws InterruptedException {
		Thread.sleep(5000);
		signup.CheckTos1();
		signup.ClickCheckout();
		
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
//				signup.ClickCheckout();
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
		signup.ClickTopRightSignintext();
		signup.EnterTopRightEmail(email);
		signup.EnterTopRightPassword(StaticData.portalPassword);
		signup.ClickTopRightSigninButton();
	}

	public void existingEmailSignIn(String existingEmail, String password) throws InterruptedException {
		
		signup.EnterExistingAccountEmail(existingEmail);
		
		WebElement webElement = driver.findElement(By.id("new-email"));
		webElement.sendKeys(Keys.TAB);
		
		signup.EnterExistingAccountPassword(password);
		signup.ClickExistingAccoiuntLoginButton();
		
		@SuppressWarnings("deprecation")
		WebDriverWait w = new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("new_cc_tab")));
	}
}
