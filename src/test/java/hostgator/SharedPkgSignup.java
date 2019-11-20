package hostgator;

import hostgator.commonflow.SignupCommonFlow;
import hostgator.driver.BaseTest;
import hostgator.pages.signup.SignupPage;
import hostgator.util.StaticData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.io.IOException;

public class SharedPkgSignup extends BaseTest {

	private static Logger log = LogManager.getLogger(SharedPkgSignup.class.getName());
    SignupPage signup;
	SignupCommonFlow signupFlow;

	@Test(groups  = {"SmokeTest", "SignupRegression"}) //
	public void HGQ_898_shared_new_customer_new_domain_cc() throws IOException, InterruptedException {
		driver.get("https://portal10.hostgator.com"+StaticData.SHARED_PKG);

		signupFlow =new SignupCommonFlow(driver);
		signup     =new SignupPage(driver);
		signup.enterDomain(StaticData.DOMAIN_NAME, "sharedpackage");
		signup.tldDropdown(0);
		signup.billingDropdown(0);
		signup.enterUsername(StaticData.USERNAME);
		signup.enterPin(StaticData.PIN);
		signupFlow.enterEmailAndConfirm("shared");
		signupFlow.enterBillingInfo();
		signupFlow.enterCredirCardInfo();
//		signupFlow.sharedPackageCheckTOSandCheckoutTwice();
//		signup.verifyPaymentComplete();
	}
}