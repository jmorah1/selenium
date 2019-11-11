package hostgator;

import hostgator.Pages.Signup.Signuppage;
import hostgator.driver.TestDriver;
import hostgator.util.StaticData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Random;

public class DediPkgSignup extends TestDriver {
	Random random = new Random();
	private static Logger log = LogManager.getLogger(DediPkgSignup.class.getName());
    Signuppage signup;

	@BeforeTest
	public void initialize() throws IOException {
		driver =  initializeDriver();
		driver.get(prop.getProperty(mvnPassedEnvironment())+StaticData.dediPkg);
		log.info("Navigated to dedi pkg signup page");
	}

	@Test(groups  = {"SmokeTest", "SignupRegression"}) //HGQ-899
	public void DediToprightSigninExistingCustomerExistingDomainPP() throws InterruptedException, IOException {
		signup=new Signuppage(driver);

		signup.clickIAlreadyOwnThisDomian();
		signup.enterExistingDomain(StaticData.domainName, "dedi");
		signup.verifyDomainIsValid();
		signup.billingDropdown(0);
		signup.topRightSignIn(StaticData.sharedDefaultAccount);
		signup.clickPayPalTab();
		signup.checkTOSandCheckout();
		signup.verifyPaymentComplete();
	}
	// https://hyperion-staging-portal.houston1.endurancedevs.com/billing/invoice/pay/select

	@AfterTest
	public void teardown() {
		driver.close();
		log.info("Closing Driver");
		driver=null;
	}
}
