package hostgator;

import java.io.IOException;
import java.util.Random;

import hostgator.Pages.Portal.LoginPage;
import org.apache.logging.log4j.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hostgator.driver.TestDriver;
import hostgator.util.StaticData;

import hostgator.Pages.Portal.PortalHomePage;

public class MakePaymentFeature extends TestDriver{

	TestDriver testDriver=new TestDriver();
	Random random = new Random();
	
	private static Logger log = LogManager.getLogger(MakePaymentFeature.class.getName());
	
	@BeforeClass
	//@BeforeTest
	public void initialize() throws IOException {
		driver =  initializeDriver("chrome");
		log.info("Driver is initialized");
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.manage().window().maximize();
	}
	
	@Test(groups  = {"SmokeTest", "SignupRegression"}) //HGQ-898
	public void MakePaymentFeatureByUsingCC() throws IOException, InterruptedException {
		driver.get(prop.getProperty("qaAutoMaintenace"));
		log.info("Navigated signin page");
	
		LoginPage portalLogin=new LoginPage(driver);
		PortalHomePage homePage=new PortalHomePage(driver);

		portalLogin.PortalLogin(StaticData.sharedDefaultEmail, StaticData.portalPassword);
		homePage.clickBillingNav();
		homePage.clickMakePayment();
		
		Thread.sleep(900000);
	}
	
	@AfterMethod
	public void afterMethod() {
	}
	
	@AfterClass
	public void teardown() {
		driver.close();
		log.info("Closing Driver");
		driver=null;
	}
	


}
