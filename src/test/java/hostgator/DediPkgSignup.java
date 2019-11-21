package hostgator;

import hostgator.commonflow.SignupCommonFlow;
import hostgator.driver.BaseTestDriver;
import hostgator.pages.signup.SignupPage;
import hostgator.util.StaticData;
import org.testng.annotations.Test;

import java.io.IOException;

public class DediPkgSignup extends BaseTestDriver {

	@Test(groups  = {"SmokeTest", "SignupRegression"})
	public void HGQ_899_dedi_topright_signin_existing_customer_existing_domain_pp() throws InterruptedException, IOException {
		SignupPage signup           =new SignupPage(driver);
		SignupCommonFlow signupFlow =new SignupCommonFlow(driver);

		signup.gotoSIgnupPage(StaticData.DEDI_PKG);
		signup.clickIAlreadyOwnThisDomain();
		signup.enterExistingDomain(StaticData.DOMAIN_NAME, "dedi");
		signup.billingDropdown(0);
		signup.TopRightSignIn(StaticData.SHARED_DEFAULT_ACCOUNT);
		signup.clickPayPalTab();
//		signupFlow.checkTOSandCheckout();
//		signup.verifyPaymentComplete();
	}
}
