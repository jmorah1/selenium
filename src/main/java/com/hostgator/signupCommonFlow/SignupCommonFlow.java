package com.hostgator.signupCommonFlow;

import java.util.Date;

import com.hostgator.driver.TestDriver;
import com.hostgator.signupPages.PayPalLogin;
import com.hostgator.signupPages.Signuppage;
import com.hostgator.signupPages.signupCompletePage;
import com.hostgator.util.StaticData;

public class SignupCommonFlow extends TestDriver{
	
	Signuppage signup=new Signuppage(driver);
	signupCompletePage signupComplete=new signupCompletePage(driver);
	PayPalLogin paypalLogin=new PayPalLogin(driver);
	
	public void enterEmailAndConfirm() {
		Date date= new Date();
		String email = "hgtest"+ date.getTime() + "@endurance.com";
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
		signup.checkTos();
		signup.clickCheckout();
	}
	
	public void verifyPaymentComplete() throws InterruptedException {
		//WebDriverWait webWait=new WebDriverWait(driver, 10);
		/*above is deprecated find alternate explicit wait. 
		See: https://stackoverflow.com/questions/42421148/wait-untilexpectedconditions-doesnt-work-any-more-in-selenium */
		
		Thread.sleep(9000); //should be updated with explicit wait
		signupComplete.VerifypaymentComplete();	
	}
	
	public void paypalLogin() {
		paypalLogin.enterPayPalEmail(StaticData.payPalEmail);
		paypalLogin.clickPayPalNextButton();
		paypalLogin.enterPayPalPassword(StaticData.payPalPassword);
		paypalLogin.clickPayPalLoginButton();
	}
}
