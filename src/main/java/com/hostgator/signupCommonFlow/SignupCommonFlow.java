package com.hostgator.signupCommonFlow;

import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.hostgator.driver.TestDriver;
import com.hostgator.signupPages.PayPalLogin;
import com.hostgator.signupPages.Signuppage;
import com.hostgator.signupPages.signupCompletePage;
import com.hostgator.util.StaticData;

public class SignupCommonFlow extends TestDriver{
	Random random = new Random();

	Signuppage signup=new Signuppage(driver);
	signupCompletePage signupComplete=new signupCompletePage(driver);
	PayPalLogin paypalLogin=new PayPalLogin(driver);
	
	public void enterEmailAndConfirm(String packageName) {
		String email = "hgtest"+random.nextInt(1000)+packageName +random.nextInt(10000)+ "@endurance.com";
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
	}
	
	public void verifyPaymentComplete() throws InterruptedException {
		//WebDriverWait webWait=new WebDriverWait(driver, 10);
		/*above is deprecated find alternate explicit wait. 
		See: https://stackoverflow.com/questions/42421148/wait-untilexpectedconditions-doesnt-work-any-more-in-selenium */
		
		Thread.sleep(22000); //should be updated with explicit wait		
		Assert.assertTrue(driver.getCurrentUrl().contains("/signup/complete/"), "Did not make it to signup/complete page");
		//Assert.assertTrue(driver.getCurrentUrl().contains("/signup/complete/"));
	}
	
	public void paypalLogin() throws InterruptedException {
		paypalLogin.enterPayPalEmail(StaticData.payPalEmail);
		paypalLogin.clickPayPalNextButton();
		paypalLogin.enterPayPalPassword(StaticData.payPalPassword);
//		paypalLogin.unCheckStayLoggedIn();
		paypalLogin.clickPayPalLoginButton();
		Thread.sleep(10000); //replace with explicit 
//
//		if (driver.findElements(By.xpath("//*[@id=\"button\"]/button")).size() > 0) {
//			try {
//				Thread.sleep(999999999);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		Boolean notNow = driver.findElements(By.id("notNowLink")).size() > 0 ;
		if (notNow) {

			driver.findElement(By.id("notNowLink")).click();

		} else {
			paypalLogin.clickPayPalContinueButton();
		}
		
		Thread.sleep(8000); //replace with explicit
		paypalLogin.clickPaypalAgreeAndContinuebutton();

	}
	
	public void topRightSignIn() {
		signup.clickTopRightSignintext();
		signup.enterTopRightEmail(StaticData.portalEmail);
		signup.enterTopRightPassword(StaticData.portalPassword); 
		signup.clickTopRightSigninButton();
	}
	
}
