package com.hostgator;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Random;


import org.apache.logging.log4j.*;
import org.testng.Assert;
import org.testng.annotations.*;

import com.hostgator.driver.TestDriver;
import com.hostgator.signupCommonFlow.SignupCommonFlow;
import com.hostgator.signupPages.*;
import com.hostgator.util.StaticData;

public class PkgSignup extends TestDriver {

	Random random = new Random();
	private static Logger log = LogManager.getLogger(PkgSignup.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		//driver =  initializeDriver();
		log.info("Driver is initialized");
	}

//	@Test
//	public void test() {
//		Timestamp timestamp = new Timestamp(System.currentTimeMillis()); //2019-10-16 16:50:40.916
//		System.out.println(timestamp);
//		Assert.assertTrue(false);
//	}
	@Test
	public void SharedNewCustomerNewDomainCC() throws IOException, InterruptedException 
	{
		
		driver =  initializeDriver();

		driver.get(prop.getProperty("qaAutoMaintenace")+StaticData.sharedPkg);
		log.info("Navigated to shared pkg signup page");

		driver.manage().window().maximize();

		SignupCommonFlow signupFlow=new SignupCommonFlow();
		Signuppage signup=new Signuppage(driver);

		signup.enterDomain(StaticData.domainName, "sharedpackage");
		signup.billingDropdown(0);
		Thread.sleep(2000);
		signup.enterUsername(StaticData.userName);
		signup.enterPin(StaticData.pin);

		signupFlow.enterEmailAndConfirm("shared");
		signupFlow.enterBillingInfo();
		signupFlow.enterCredirCardInfo();
		signup.tos_checkbox3();
		signup.clickCheckout();
//		signupFlow.checkTOSandCheckout();
		
		signup.clickCheckout(); //Clicking checkout again cause first click loads up and does nothing
		signupFlow.verifyPaymentComplete();		
				
		driver.close();
	}
	
	@Test
	public void DediToprightSigninExistingCustomerExistingDomainPP() throws InterruptedException, IOException {
		driver =  initializeDriver();

		driver.get(prop.getProperty("qaAutoMaintenace")+StaticData.dediPkg);
		log.info("Navigated to dedi pkg signup page");
		
		SignupCommonFlow signupFlow=new SignupCommonFlow();
		Signuppage signup=new Signuppage(driver);

		driver.manage().window().maximize();
		
		signup.clickIAlreadyOwnThisDomian();
		
		
		String existingDomain = StaticData.domainName+random.nextInt(10000)+"dedi"+random.nextInt(100000)+".com";
		signup.enterStoredExistingDomain(existingDomain);
				
		signup.billingDropdown(0);
		signupFlow.topRightSignIn();	
		signup.clickPayPalTab();
		Thread.sleep(4000); //explicit wait
		signupFlow.checkTOSandCheckout();
		signupFlow.verifyPaymentComplete();

		driver.close();
	}	
	
	@Test
	public void WordpressExistingCustomerExistingDomainCC() throws InterruptedException, IOException {
		driver =  initializeDriver();

		driver.get(prop.getProperty("qaAutoMaintenace")+StaticData.wordPressPkg);
		log.info("Navigated to dedi pkg signup page");
		
		SignupCommonFlow signupFlow=new SignupCommonFlow();
		Signuppage signup=new Signuppage(driver);

		driver.manage().window().maximize();
		
		signup.enterDomain(StaticData.domainName, "owp");
		signup.billingDropdown(1);
		Thread.sleep(3000);
		signup.enterPin(StaticData.pin);
		signupFlow.enterEmailAndConfirm("owp");
		signupFlow.enterBillingInfo();
		signupFlow.enterCredirCardInfo();
		signupFlow.checkTOSandCheckout();
		signupFlow.verifyPaymentComplete();

		driver.close();
	}
	
//	@AfterTest
//	public void teardown() {
////		driver.close();
//		driver=null;
//	}


}
