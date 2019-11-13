package hostgator;

import hostgator.commonflow.SignupCommonFlow;
import hostgator.pages.signup.SignupPage;
import hostgator.driver.TestDriver;
import hostgator.util.StaticData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class VPSSignup extends TestDriver {

	private static Logger log = LogManager.getLogger(VPSSignup.class.getName());
    SignupPage signup;
	SignupCommonFlow signupFlow;

	@BeforeTest
	public void initialize() throws IOException {
		driver =  initializeDriver();
		driver.get(prop.getProperty(mvnPassedEnvironment())+StaticData.VPS_PKG);
	}

	@Test(groups  = {"SmokeTest", "SignupRegression"})
	public void HGQ_1133_vps_new_customer_existing_domain_cc() throws InterruptedException, IOException {
		signup=new SignupPage(driver);
		signupFlow = new SignupCommonFlow(driver);

		signup.ClickIAlreadyOwnThisDomain();
		signup.EnterExistingDomain(StaticData.DOMAIN_NAME, "vps");
		signup.BillingDropdown(0);
		signup.EnterPin(StaticData.PIN);
		signupFlow.enterEmailAndConfirm("cloud");
		signupFlow.enterBillingInfo();
		signupFlow.enterCredirCardInfo();
		signupFlow.checkTOSandCheckout();
		signup.VerifyPaymentComplete();
	}

	@AfterTest
	public void teardown() {
		driver.close();
		log.info("Closing Driver");
		driver=null;
	}
}
