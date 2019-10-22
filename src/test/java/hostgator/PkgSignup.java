package hostgator;

import java.io.IOException;
import java.util.Random;


import hostgator.Pages.Signup.Signuppage;
import org.apache.logging.log4j.*;
import org.testng.annotations.*;

import hostgator.driver.TestDriver;
import hostgator.util.com.hostgator.util.StaticData;

import hostgator.CommonFlow.SignupCommonFlow;

public class PkgSignup extends TestDriver {

//	TestDriver testDriver=new TestDriver();
	Random random = new Random();
	
	private static Logger log = LogManager.getLogger(PkgSignup.class.getName());
	
	@BeforeClass
	//@BeforeTest
	public void initialize() throws IOException {
//		driver =  initializeDriver();
//		log.info("Driver is initialized");
	}

	@BeforeMethod
	public void beforeMethod() {
//		driver.manage().window().maximize();
	   
	}
	
	@Test(groups  = {"SmokeTest", "SignupRegression"}) //HGQ-898
	public void SharedNewCustomerNewDomainCC() throws IOException, InterruptedException {
		
		driver =  initializeDriver();
		driver.manage().window().maximize();
		
		driver.get(prop.getProperty("qaAutoMaintenace")+StaticData.sharedPkg);
		log.info("Navigated to shared pkg signup page");

		SignupCommonFlow signupFlow=new SignupCommonFlow();
		Signuppage signup=new Signuppage(driver);
		signup.enterDomain(StaticData.domainName, "sharedpackage");
		signup.tldDropdown(0);
		Thread.sleep(2000);
		signup.billingDropdown(0);
		Thread.sleep(2000);
		signup.enterUsername(StaticData.userName);
		signup.enterPin(StaticData.pin);
		signupFlow.enterEmailAndConfirm("shared");
		signupFlow.enterBillingInfo();
		signupFlow.enterCredirCardInfo();
		signup.tos_checkbox3();
		signup.clickCheckout();
		signup.clickCheckout(); //Clicking checkout again cause first click loads up and does nothing		
		signupFlow.verifyPaymentComplete();	
		
		driver.close();
	}
	
	@Test(groups  = {"SmokeTest", "SignupRegression"}) //HGQ-899
	public void DediToprightSigninExistingCustomerExistingDomainPP() throws InterruptedException, IOException {
		
		driver =  initializeDriver();
		driver.manage().window().maximize();
		
		driver.get(prop.getProperty("qaAutoMaintenace")+StaticData.dediPkg);
		log.info("Navigated to dedi pkg signup page");
		
		SignupCommonFlow signupFlow=new SignupCommonFlow();
		Signuppage signup=new Signuppage(driver);
		signup.clickIAlreadyOwnThisDomian();
		String existingDomain = StaticData.domainName+random.nextInt(10000)+"dedi"+random.nextInt(100000)+".com";
		signup.enterStoredExistingDomain(existingDomain);
		signup.billingDropdown(0);
		signupFlow.topRightSignIn(StaticData.sharedDefaultAccount);	
		signup.clickPayPalTab();
		Thread.sleep(4000); //explicit wait
		signupFlow.checkTOSandCheckout();
		signupFlow.verifyPaymentComplete();
		
		driver.close();
	}	
	
	@Test(groups  = {"SmokeTest", "SignupRegression"}) //HGQ-900
	public void WordpressExistingCustomerExistingDomainCC() throws InterruptedException, IOException {		
		
		driver =  initializeDriver();
		driver.manage().window().maximize();
		
		driver.get(prop.getProperty("qaAutoMaintenace")+StaticData.wordPressPkg);
		log.info("Navigated to dedi pkg signup page");
		
		SignupCommonFlow signupFlow=new SignupCommonFlow();
		Signuppage signup=new Signuppage(driver);
		signup.clickIAlreadyOwnThisDomian();
		signup.enterExistingDomain(StaticData.domainName, "owp");
		signup.billingDropdown(0);
		Thread.sleep(3000);
		signup.enterPin(StaticData.pin);
		signupFlow.existingEmailSignIn(StaticData.sharedDefaultEmail, StaticData.defaultPassword);
		signupFlow.checkTOSandCheckout();
		signupFlow.verifyPaymentComplete();
		
		driver.close();
	}
	
	@AfterMethod
	public void afterMethod() throws InterruptedException {
//		driver.close();
        
	}
	
	@AfterClass
	public void teardown() {
//		driver.close();
//		log.info("Closing Driver");
		driver=null;
	}
}
