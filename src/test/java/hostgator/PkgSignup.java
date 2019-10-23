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
		signup.EnterDomain(StaticData.domainName, "sharedpackage");
		signup.TldDropdown(0);
		Thread.sleep(2000);
		signup.BillingDropdown(0);
		Thread.sleep(2000);
		signup.EnterUsername(StaticData.userName);
		signup.EnterPin(StaticData.pin);
		signupFlow.EnterEmailAndConfirm("shared");
		signupFlow.enterBillingInfo();
		signupFlow.enterCredirCardInfo();
		signup.TosCheckbox3();
		signup.ClickCheckout();
		signup.ClickCheckout(); //Clicking checkout again cause first click loads up and does nothing
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
		signup.ClickIAlreadyOwnThisDomian();
		String existingDomain = StaticData.domainName+random.nextInt(10000)+"dedi"+random.nextInt(100000)+".com";
		signup.EnterStoredExistingDomain(existingDomain);
		signup.BillingDropdown(0);
		signupFlow.topRightSignIn(StaticData.sharedDefaultAccount);	
		signup.ClickPayPalTab();
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
		signup.ClickIAlreadyOwnThisDomian();
		signup.EnterExistingDomain(StaticData.domainName, "owp");
		signup.BillingDropdown(0);
		Thread.sleep(3000);
		signup.EnterPin(StaticData.pin);
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
