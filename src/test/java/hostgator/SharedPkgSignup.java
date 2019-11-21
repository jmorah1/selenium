package hostgator;

import hostgator.commonflow.SignupCommonFlow;
import hostgator.driver.BaseTestDriver;
import hostgator.pages.signup.SignupPage;
import hostgator.util.StaticData;
import org.testng.annotations.Test;

import java.io.IOException;

public class SharedPkgSignup extends BaseTestDriver {
	@Test(groups  = {"SmokeTest", "SignupRegression"}) //
	public void HGQ_898_shared_new_customer_new_domain_cc() throws IOException, InterruptedException {
		SignupPage signup           =new SignupPage(driver);
		SignupCommonFlow signupFlow =new SignupCommonFlow(driver);

		signup.gotoSIgnupPage(StaticData.SHARED_PKG);
		signup.enterDomain(StaticData.DOMAIN_NAME, "sharedpackage");
		signup.tldDropdown(0);
		signup.billingDropdown(0);
		signup.enterUsername(StaticData.USERNAME);
		signup.enterPin(StaticData.PIN);
		signupFlow.enterEmailAndConfirm("shared");
		signupFlow.enterBillingInfo();
		signupFlow.enterCreditCardInfo();
//		signupFlow.sharedPackageCheckTOSandCheckoutTwice();
//		signup.verifyPaymentComplete();
	}
}