//package hostgator;
//
//import java.io.IOException;
//import java.util.Random;
//
//import hostgator.Pages.Portal.LoginPage;
//import org.apache.logging.log4j.*;
//import org.testng.annotations.*;
//
//import hostgator.driver.TestDriver;
//import hostgator.util.StaticData;
//
//import hostgator.Pages.Portal.PortalHomePage;
//
//public class MakePaymentFeature extends TestDriver{
//
//	private static Logger log = LogManager.getLogger(MakePaymentFeature.class.getName());
//
//	@BeforeTest
//	public void initialize() throws IOException {
//		driver =  initializeDriver();
//		log.info("Driver is initialized");
//	}
//
//	@BeforeMethod
//	public void beforeMethod() {
//		driver.manage().window().maximize();
//        driver.get(prop.getProperty("qaAutoMaintenace"));
//        log.info("Navigated signin page");
//	}
//
//	@Test(groups  = {"SmokeTest", "SignupRegression"}) //HGQ-898
//	public void MakePaymentFeatureByUsingCC() throws IOException, InterruptedException {
//		LoginPage portalLogin=new LoginPage(driver);
//		PortalHomePage homePage=new PortalHomePage(driver);
//
//		portalLogin.PortalLogin(StaticData.sharedDefaultEmail, StaticData.portalPassword);
//		homePage.clickBillingNav();
//		homePage.clickMakePayment();
//
//		Thread.sleep(900000);
//	}
//
//	@AfterMethod
//	public void afterMethod() {
//	}
//
//	@AfterClass
//	public void teardown() {
//		driver.close();
//		log.info("Closing Driver");
//		driver=null;
//	}
//
//
//
//}
