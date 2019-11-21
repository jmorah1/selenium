package hostgator;

import hostgator.commonflow.SignupCommonFlow;
import hostgator.driver.BaseTestDriver;
import hostgator.pages.signup.SignupPage;
import hostgator.util.StaticData;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;

public class VPSSignup extends BaseTestDriver {
	@Test(groups  = {"SmokeTest"})
	public void HGQ_1133_vps_new_customer_existing_domain_cc() throws InterruptedException, IOException {
		SignupPage signup=new SignupPage(driver);
		SignupCommonFlow signupFlow = new SignupCommonFlow(driver);

		signup.gotoSIgnupPage(StaticData.VPS_PKG);
		signup.clickIAlreadyOwnThisDomain();
		signup.enterExistingDomain(StaticData.DOMAIN_NAME, "vps");
		signup.billingDropdown(0);
		signup.enterPin(StaticData.PIN);
		signupFlow.enterEmailAndConfirm("cloud");
		signupFlow.enterBillingInfo();
		signupFlow.enterCreditCardInfo();
//		signupFlow.checkTOSandCheckout();
//		signup.verifyPaymentComplete();
	}
}