package com.hostgator;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.hostgator.driver.TestDriver;
import com.hostgator.signupCommonFlow.SignupCommonFlow;
import com.hostgator.signupPages.*;
import com.hostgator.util.StaticData;

public class PkgSignup extends TestDriver {

	private static Logger log = LogManager.getLogger(PkgSignup.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver =  initializeDriver();
		log.info("Driver is initialized");
	}
//	@Test
//	public void SharedNewCustomerNewDomainCC() throws IOException, InterruptedException 
//	{
//		driver.get(prop.getProperty("qaAutoMaintenace")+StaticData.sharedPkg);
//		log.info("Navigated to shared pkg signup page");
//
//		SignupCommonFlow signupFlow=new SignupCommonFlow();
//		Signuppage signup=new Signuppage(driver);
//
//		signup.enterDomain(StaticData.domainName);
//		signup.billingDropdown(0);
//		signup.enterUsername(StaticData.userName);
//		signup.enterPin(StaticData.pin);
//
//		signupFlow.enterEmailAndConfirm();
//		signupFlow.enterBillingInfo();
//		signupFlow.enterCredirCardInfo();
//		signupFlow.checkTOSandCheckout();
//		signupFlow.verifyPaymentComplete();
//				
//	}
	
//	@Test
//	public void DediToprightSigninExistingCustomerExistingDomainPP() throws InterruptedException {
//		
//		driver.get(prop.getProperty("qaAutoMaintenace")+StaticData.dediPkg);
//		log.info("Navigated to dedi pkg signup page");
//		
//		SignupCommonFlow signupFlow=new SignupCommonFlow();
//		Signuppage signup=new Signuppage(driver);
//
//		signup.enterDomain(StaticData.domainName);
//		signup.billingDropdown(1);
//		Thread.sleep(3000);
//		signup.enterPin(StaticData.pin);
//		signupFlow.enterEmailAndConfirm();
//		signupFlow.enterBillingInfo();
//		signup.clickPaypalPaymentType();
//		signupFlow.checkTOSandCheckout();
//		signupFlow.paypalLogin();
//		signupFlow.verifyPaymentComplete();
//
//	}	
	
	@Test
	public void WordpressExistingCustomerExistingDomainCC() throws InterruptedException {
		
		driver.get(prop.getProperty("qaAutoMaintenace")+StaticData.wordPressPkg);
		log.info("Navigated to dedi pkg signup page");
		
		SignupCommonFlow signupFlow=new SignupCommonFlow();
		Signuppage signup=new Signuppage(driver);

		signup.enterDomain(StaticData.domainName);
		signup.billingDropdown(1);
		Thread.sleep(3000);
		signup.enterPin(StaticData.pin);
		signupFlow.enterEmailAndConfirm();
		signupFlow.enterBillingInfo();
		signupFlow.enterCredirCardInfo();
		signupFlow.checkTOSandCheckout();
		signupFlow.verifyPaymentComplete();

	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		driver=null;
	}


}
