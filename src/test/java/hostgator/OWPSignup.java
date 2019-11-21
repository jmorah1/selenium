package hostgator;

import hostgator.commonflow.SignupCommonFlow;
import hostgator.driver.BaseTestDriver;
import hostgator.pages.signup.SignupPage;
import hostgator.util.StaticData;
import org.testng.annotations.Test;

import java.io.IOException;

public class OWPSignup extends BaseTestDriver {
	@Test(groups  = {"SmokeTest", "SignupRegression"})
	public void HGQ_900_wordpress_existing_customer_existing_domain_cc() throws InterruptedException, IOException {
		SignupPage signup           =new SignupPage(driver);
		SignupCommonFlow signupFlow =new SignupCommonFlow(driver);

		signup.gotoSIgnupPage(StaticData.WORDPRESS_PKG);
		signup.clickIAlreadyOwnThisDomain();
		signup.enterExistingDomain(StaticData.DOMAIN_NAME, "owp");
		signup.billingDropdown(0);
		signup.enterPin(StaticData.PIN);
		signup.ExistingEmailSignIn(StaticData.SHARED_DEFAULT_EMAIL, StaticData.DEFAULT_PASSWORD);
//		signupFlow.checkTOSandCheckout();
//		signup.verifyPaymentComplete();
	}
}
