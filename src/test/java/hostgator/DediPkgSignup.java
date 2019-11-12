package hostgator;

import hostgator.CommonFlow.SignupCommonFlow;
import hostgator.Pages.Signup.Signuppage;
import hostgator.driver.TestDriver;
import hostgator.util.StaticData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class DediPkgSignup extends TestDriver {
	private static Logger log = LogManager.getLogger(DediPkgSignup.class.getName());
    Signuppage signup;
    SignupCommonFlow signupFlow;

	@BeforeTest
	public void initialize() throws IOException {
		driver =  initializeDriver();
		driver.get(prop.getProperty(mvnPassedEnvironment())+StaticData.DEDI_PKG);
		log.info("Navigated to dedi pkg signup page");
	}

	@Test(groups  = {"SmokeTest", "SignupRegression"}) //HGQ-899
	public void DediToprightSigninExistingCustomerExistingDomainPP() throws InterruptedException, IOException {
		signup=new Signuppage(driver);
		signupFlow =new SignupCommonFlow(driver);

		signup.clickIAlreadyOwnThisDomian();
		signup.enterExistingDomain(StaticData.DOMAIN_NAME, "dedi");
		signup.billingDropdown(0);
		signup.topRightSignIn(StaticData.SHARED_DEFAULT_ACCOUNT);
		signup.clickPayPalTab();
		signupFlow.checkTOSandCheckout();
		signup.verifyPaymentComplete();
	}

	@AfterTest
	public void teardown() {
		driver.close();
		log.info("Closing Driver");
		driver=null;
	}
}
