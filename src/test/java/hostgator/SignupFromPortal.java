package hostgator;

import hostgator.commonflow.SignupCommonFlow;
import hostgator.pages.portal.HomePage;
import hostgator.pages.portal.Hosting;
import hostgator.pages.portal.LoginPage;
import hostgator.pages.signup.Signuppage;
import hostgator.driver.TestDriver;
import hostgator.util.StaticData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class SignupFromPortal extends TestDriver {

	private static Logger log = LogManager.getLogger(SignupFromPortal.class.getName());
	LoginPage loginPage;
	HomePage homePage;
	Hosting hosting;
	Signuppage signup;
	SignupCommonFlow signupFlow;

	@BeforeTest
	public void initialize() throws IOException {
		driver =  initializeDriver();
		driver.get(prop.getProperty(mvnPassedEnvironment()));
	}

	@Test(groups  = {"SmokeTest", "SignupRegression"})  //HGQ-1125
	public void SharedExistingCustomerSignupFromPortalCC() throws InterruptedException{
		loginPage  = new LoginPage(driver);
		homePage   = new HomePage(driver);
		hosting    = new Hosting(driver);
		signup     = new Signuppage(driver);
		signupFlow = new SignupCommonFlow(driver);

		loginPage.portalLogin(StaticData.SHARED_DEFAULT_EMAIL, StaticData.PORTAL_PASSWORD);
		homePage.clickHosting();
		hosting.addPackage();
		hosting.shared();
		signup.clickIAlreadyOwnThisDomian();
		signup.enterExistingDomain(StaticData.DOMAIN_NAME, "shared");
		signup.billingDropdown(0);
		signup.enterUsername(StaticData.USERNAME);
		signupFlow.sharedPackageCheckTOSandCheckoutTwice();
		signup.verifyPaymentComplete();
	}

	@AfterTest
	public void teardown() {
		driver.close();
		log.info("Closing Driver");
		driver=null;
	}
}
