package hostgator;

import hostgator.commonflow.SignupCommonFlow;
import hostgator.driver.BaseTestDriver;
import hostgator.pages.signup.SignupPage;
import hostgator.util.StaticData;
import org.testng.annotations.Test;

import java.io.IOException;

public class ResellerSignup extends BaseTestDriver {
	@Test(groups  = {"SmokeTest", "SignupRegression"})
	public void HGQ_1125_reseller_existing_customer_top_right_signin_existing_domain_pp() throws InterruptedException, IOException {
		SignupPage signup           =new SignupPage(driver);
		SignupCommonFlow signupFlow = new SignupCommonFlow(driver);

		signup.gotoSIgnupPage(StaticData.RESELLER_PKG);
		signup.clickIAlreadyOwnThisDomain();
		signup.enterExistingDomain(StaticData.DOMAIN_NAME, "reseller");
		signup.billingDropdown(0);
		signup.TopRightSignIn(StaticData.SHARED_DEFAULT_EMAIL);
		signup.enterUsername(StaticData.USERNAME);
		signup.clickPayPalTab();
//		signupFlow.checkTOSandCheckout();
//		signup.verifyPaymentComplete();
	}
}