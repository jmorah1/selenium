package hostgator;

import hostgator.commonflow.SignupCommonFlow;
import hostgator.pages.signup.Signuppage;
import hostgator.driver.TestDriver;
import hostgator.util.StaticData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class ResellerSignup extends TestDriver {

	private static Logger log = LogManager.getLogger(ResellerSignup.class.getName());
    Signuppage signup;
    SignupCommonFlow signupFlow;

	@BeforeTest
	public void initialize() throws IOException {
		driver =  initializeDriver();
//		driver.manage().window().maximize();
		driver.get(prop.getProperty(mvnPassedEnvironment())+StaticData.RESELLER_PKG);
	}

	@Test(groups  = {"SmokeTest", "SignupRegression"})  //HGQ-1125
	public void ResellerExistingCustomerTopRightSigninExistingDomainPP() throws InterruptedException {
		signup=new Signuppage(driver);
		signupFlow = new SignupCommonFlow(driver);

		signup.clickIAlreadyOwnThisDomian();
		signup.enterExistingDomain(StaticData.DOMAIN_NAME, "reseller");
		signup.billingDropdown(0);
		signup.topRightSignIn(StaticData.SHARED_DEFAULT_EMAIL);
		signup.enterUsername(StaticData.USERNAME);
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
