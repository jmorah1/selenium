package hostgator;

import java.io.IOException;
import java.util.Random;

import hostgator.Pages.Portal.Billing.MakeAPaymentPage;
import hostgator.Pages.Portal.LoginPage;
import org.apache.logging.log4j.*;
import org.testng.annotations.*;

import hostgator.driver.TestDriver;
import hostgator.util.StaticData;

import hostgator.Pages.Portal.HomePage;

public class MakePaymentFeature extends TestDriver{


	private static Logger log = LogManager.getLogger(MakePaymentFeature.class.getName());
	
//	@BeforeClass
//	@BeforeTest
//	public void initialize() throws IOException {
//
//	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver =  initializeDriver();
		log.info("Driver is initialized");
		driver.manage().window().maximize();
	}
	
	@Test(groups  = {"SmokeTest", "SignupRegression"}) //HGQ-1124
	public void HGQ_1124_Make_A_Payment_Feature_By_Using_CC() throws IOException, InterruptedException {
		driver.get(prop.getProperty(mvnPassedEnvironment()));
		log.info("Navigated signin page");

		LoginPage portalLogin=new LoginPage(driver);
		HomePage homePage=new HomePage(driver);
		MakeAPaymentPage makeAPaymentPage = new MakeAPaymentPage(driver);

		portalLogin.portalLogin(StaticData.sharedDefaultEmail, StaticData.portalPassword);
		homePage.navigateToMakePayment();
		makeAPaymentPage.payWithCreditCard();

	}
	@Test(groups  = {"SmokeTest", "SignupRegression"}) //HGQ-1126
	public void HGQ_1126_Make_A_Payment_Feature_By_Using_PayPal() throws IOException, InterruptedException {
		driver.get(prop.getProperty(mvnPassedEnvironment()));
		log.info("Navigated signin page");

		LoginPage portalLogin=new LoginPage(driver);
		HomePage homePage=new HomePage(driver);
		MakeAPaymentPage makeAPaymentPage = new MakeAPaymentPage(driver);
		portalLogin.portalLogin(StaticData.sharedDefaultEmail, StaticData.portalPassword);
		homePage.navigateToMakePayment();
		makeAPaymentPage.payWithPayPal();

	}
	
	@AfterMethod
	public void AfterMethod() {
		driver.close();
		log.info("Closing Driver");
	}
	
	@AfterClass
	public void teardown() {
		driver=null;
	}
	


}
