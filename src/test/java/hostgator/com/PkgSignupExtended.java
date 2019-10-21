package hostgator.com;

import java.io.IOException;
import java.util.Random;


import org.apache.logging.log4j.*;
import org.testng.annotations.*;

import com.hostgator.driver.TestDriver;
import hostgator.com.util.com.hostgator.util.StaticData;

import hostgator.com.CommonFlow.SignupCommonFlow;
import hostgator.com.Pages.Signuppage;


public class PkgSignupExtended extends TestDriver {

	TestDriver testDriver=new TestDriver();
	Random random = new Random();
	
	private static Logger log = LogManager.getLogger(PkgSignup.class.getName());
	
	@BeforeClass
	public void initialize() throws IOException {
		driver =  initializeDriver();
		log.info("Driver is initialized");
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.manage().window().maximize();
	}
	
	@Test(groups  = {"SmokeTest", "SignupRegression"})  //HGQ-1125
	public void ResellerExistingCustomerTopRightSigninExistingDomainPP() throws InterruptedException, IOException {
		driver.get(prop.getProperty("qaAutoMaintenace")+StaticData.resellerPkg);
		log.info("Navigated to dedi pkg signup page");
		
		SignupCommonFlow signupFlow=new SignupCommonFlow();
		Signuppage signup=new Signuppage(driver);
		signup.clickIAlreadyOwnThisDomian();
		signup.enterExistingDomain(StaticData.domainName, "reseller");
		signup.billingDropdown(0);
		signupFlow.topRightSignIn(StaticData.resellerDefaultAccount);
		signup.enterUsername(StaticData.userName);
		signup.clickPayPalTab();
		Thread.sleep(4000); //explicit wait
		signupFlow.checkTOSandCheckout();
		signupFlow.paypalLogin();
		signupFlow.verifyPaymentComplete();
	}	

	@Test(groups  = {"SmokeTest", "SignupRegression"})
	public void VPSNewCustomerExistingDomainCC() throws InterruptedException, IOException {
		//driver.get(prop.getProperty("qaAutoMaintenace")+StaticData.vpsPkg);
		driver.get("https://qa-automation-maintenance-portal.houston1.endurancedevs.com/signup/vps/82/36/SNAPPYV2/");
		log.info("Navigated to dedi pkg signup page");
		
		SignupCommonFlow signupFlow=new SignupCommonFlow();
		Signuppage signup=new Signuppage(driver);
		signup.clickIAlreadyOwnThisDomian();
		signup.enterExistingDomain(StaticData.domainName, "vps");
		signup.billingDropdown(0);
		signup.enterPin(StaticData.pin);
		signupFlow.enterEmailAndConfirm("cloud");
		signupFlow.enterBillingInfo();
		signupFlow.enterCredirCardInfo();
		signupFlow.checkTOSandCheckout();
		signupFlow.verifyPaymentComplete();
	}
	
	@Test(groups  = {"SmokeTest", "SignupRegression"}) //HGQ-1134
	public void CSNewCustomerExistingDomainPP() throws InterruptedException, IOException {
		driver.get(prop.getProperty("qaAutoMaintenace")+StaticData.cloudSitesPkg);
		log.info("Navigated to dedi pkg signup page");
		
		SignupCommonFlow signupFlow=new SignupCommonFlow();
		Signuppage signup=new Signuppage(driver);
		signup.clickIAlreadyOwnThisDomian();
		signup.enterExistingDomain(StaticData.domainName, "cloud");
		signup.billingDropdown(0);
		signup.enterPin(StaticData.pin);
		signupFlow.enterEmailAndConfirm("cloud");
		signupFlow.enterBillingInfo();
		signup.clickPaypalPaymentType();
		signupFlow.checkTOSandCheckout();
		signupFlow.paypalLogin();
		signupFlow.verifyPaymentComplete();
	}
	

	
	@AfterMethod
	public void afterMethod() {
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		log.info("Closing Driver");
		driver=null;
	}


}
