package com.hostgator;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.*;
import org.testng.annotations.*;

import com.hostgator.driver.TestDriver;
import com.hostgator.signupPages.*;
import com.hostgator.util.StaticData;

public class PkgSignup extends TestDriver {

	private static Logger log = LogManager.getLogger(PkgSignup.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver =  initializeDriver();
		log.info("Driver is initialized");
	}
	@Test
	public void hgq898() throws IOException, InterruptedException 
	{
		driver.get(prop.getProperty("qaAutoMaintenace")+StaticData.sharedpkg);
		log.info("Navigated to shared pkg signup page");

		Signuppage signup=new Signuppage(driver);
		signupCompletePage signupComplete=new signupCompletePage(driver);

		
		signup.enterExistingDomain(StaticData.domainName);
//		signup.tldDropdown(0);
		signup.clickIAlreadyOwnThisDomian();
		signup.billingDropdown(0);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		signup.enterUsername(StaticData.userName);
		signup.enterPin(StaticData.pin);

		Date date= new Date();
		String email = "hgtest"+ date.getTime() + "@endurance.com";
		signup.enterEmail(email);
		signup.enterConfirmEmail(email);
		
		signup.enterFirstName(StaticData.firstName);
		signup.enterLastName(StaticData.lastName);
		signup.enterPhone(StaticData.phone);
		signup.enterAddress1(StaticData.address1);
		signup.enterAddress2(StaticData.address2);
		signup.enterCity(StaticData.city);
		signup.enterZipCode(StaticData.zip);
		signup.enterCreditCardName(StaticData.testCreditCardName);
		signup.enterCreditCardNumber(StaticData.testCreditCardNumber);
		signup.enterCreditCardCVV(StaticData.testCreditCardCVV);
		Thread.sleep(2000);
		signup.checkTos();
		Thread.sleep(5000);

		signup.clickCheckout();
		Thread.sleep(5000);

		signup.clickCheckout();
		
		Thread.sleep(5000);
		signupComplete.VerifypaymentComplete();	
				
	}
	
	@Test
	public void hgq899() throws IOException 
	{
		driver.get(prop.getProperty("qaAutoMaintenace")+StaticData.sharedpkg);
		log.info("Got to hgq899 dummy placeholder");
				
	}
	
	@Test
	public void hgq900() throws IOException 
	{
		driver.get(prop.getProperty("qaAutoMaintenace")+StaticData.sharedpkg);
		log.info("Got to hgq900 dummy placeholder");
			
	}
	
	@Test
	public void hgq1125() throws IOException 
	{
		driver.get(prop.getProperty("qaAutoMaintenace")+StaticData.sharedpkg);
		log.info("Got to hgq1125 dummy placeholder");
	
	}
	
	@Test
	public void hgq1133() throws IOException 
	{
		driver.get(prop.getProperty("qaAutoMaintenace")+StaticData.sharedpkg);
		log.info("Got to hgq1133 dummy placeholder");
		
	}
	
	@Test
	public void hgq1134() throws IOException 
	{
		driver.get(prop.getProperty("qaAutoMaintenace")+StaticData.sharedpkg);
		log.info("Got to hgq1134 dummy placeholder");
	
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		driver=null;
	}


}
