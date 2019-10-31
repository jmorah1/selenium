//package hostgator;
//
//import java.io.IOException;
//
//
//import org.apache.logging.log4j.*;
//import org.testng.annotations.*;
//
//import hostgator.driver.TestDriver;
//import hostgator.util.StaticData;
//
//import hostgator.CommonFlow.SignupCommonFlow;
//import hostgator.Pages.Signup.Signuppage;
//
//
//public class PkgSignupExtended extends TestDriver {
//
//	private static Logger log = LogManager.getLogger(PkgSignupExtended.class.getName());
//
//	@BeforeClass
//	public void initialize() throws IOException {
//		driver =  initializeDriver();
//		log.info("Driver is initialized");
//	}
//
//	@BeforeMethod
//	public void beforeMethod() {
//		driver.manage().window().maximize();
//	}
//
//	@Test(groups  = {"SmokeTest", "SignupRegression"})  //HGQ-1125
//	public void ResellerExistingCustomerTopRightSigninExistingDomainPP() throws InterruptedException, IOException {
//		driver.get(prop.getProperty(MvnPassedEnvironment())+StaticData.resellerPkg);
//
//		log.info("Navigated to dedi pkg signup page");
//
//		SignupCommonFlow signupFlow=new SignupCommonFlow(driver);
//		Signuppage signup=new Signuppage(driver);
//		signup.ClickIAlreadyOwnThisDomian();
//		signup.EnterExistingDomain(StaticData.domainName, "reseller");
//		signup.BillingDropdown(0);
//		signupFlow.topRightSignIn(StaticData.resellerDefaultAccount);
//		signup.EnterUsername(StaticData.userName);
//		signup.ClickPayPalTab();
//		Thread.sleep(4000); //explicit wait
//		signupFlow.checkTOSandCheckout();
//		signupFlow.paypalLogin();
//		signupFlow.verifyPaymentComplete();
//	}
//
//	@Test(groups  = {"SmokeTest", "SignupRegression"}) //HGQ-1133
//	public void VPSNewCustomerExistingDomainCC() throws InterruptedException, IOException {
//		//driver.get(prop.getProperty("qaAutoMaintenace")+StaticData.vpsPkg);
//		driver.get("https://qa-automation-maintenance-portal.houston1.endurancedevs.com/signup/vps/82/36/SNAPPYV2/");
//		log.info("Navigated to dedi pkg signup page");
//
//		SignupCommonFlow signupFlow=new SignupCommonFlow(driver);
//		Signuppage signup=new Signuppage(driver);
//		signup.ClickIAlreadyOwnThisDomian();
//		signup.EnterExistingDomain(StaticData.domainName, "vps");
//		signup.BillingDropdown(0);
//		signup.EnterPin(StaticData.pin);
//		signupFlow.EnterEmailAndConfirm("cloud");
//		signupFlow.enterBillingInfo();
//		signupFlow.enterCredirCardInfo();
//		signupFlow.checkTOSandCheckout();
//		signupFlow.verifyPaymentComplete();
//	}
//
//	@Test(groups  = {"SmokeTest", "SignupRegression"}) //HGQ-1134
//	public void CSNewCustomerExistingDomainPP() throws InterruptedException, IOException {
//		driver.get(prop.getProperty(MvnPassedEnvironment())+StaticData.cloudSitesPkg);
//		log.info("Navigated to dedi pkg signup page");
//
//		SignupCommonFlow signupFlow=new SignupCommonFlow(driver);
//		Signuppage signup=new Signuppage(driver);
//		signup.ClickIAlreadyOwnThisDomian();
//		signup.EnterExistingDomain(StaticData.domainName, "cloud");
//		signup.BillingDropdown(0);
//		signup.EnterPin(StaticData.pin);
//		signupFlow.EnterEmailAndConfirm("cloud");
//		signupFlow.enterBillingInfo();
//		signup.ClickPaypalPaymentType();
//		signupFlow.checkTOSandCheckout();
//		signupFlow.paypalLogin();
//		signupFlow.verifyPaymentComplete();
//	}
//
//	@AfterMethod
//	public void afterMethod() {
//	}
//
//	@AfterTest
//	public void teardown() {
//		driver.close();
//		log.info("Closing Driver");
//		driver=null;
//	}
//
//
//}
