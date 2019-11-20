package hostgator;

import hostgator.commonflow.SignupCommonFlow;
import hostgator.driver.BaseTestDriver;
import hostgator.pages.signup.SignupPage;
import hostgator.util.StaticData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.io.IOException;
public class VPSSignup extends BaseTestDriver {

	private static Logger log = LogManager.getLogger(VPSSignup.class.getName());
    SignupPage signup;
	SignupCommonFlow signupFlow;


	@Test(groups  = {"SmokeTest", "SignupRegression"})
	public void HGQ_1133_vps_new_customer_existing_domain_cc() throws InterruptedException, IOException {
		driver.get("https://portal10.hostgator.com"+StaticData.VPS_PKG);
		signup=new SignupPage(driver);
		signupFlow = new SignupCommonFlow(driver);

//		Actions action = new Actions(driver);
//		action.keyDown(Keys.CONTROL).keyDown(Keys.ALT).sendKeys("j").perform();
//		action.keyUp(Keys.CONTROL).keyUp(Keys.ALT).perform();
//
//		action.keyDown(Keys.COMMAND).keyDown(Keys.ALT).sendKeys("j").perform();
//		action.keyUp(Keys.COMMAND).keyUp(Keys.ALT).perform();
//
//		action.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys("j").perform();
//		action.keyUp(Keys.CONTROL).keyUp(Keys.SHIFT).perform();
//

		signup.clickIAlreadyOwnThisDomain();
		signup.enterExistingDomain(StaticData.DOMAIN_NAME, "vps");
		signup.billingDropdown(0);
		signup.enterPin(StaticData.PIN);
		signupFlow.enterEmailAndConfirm("cloud");
		signupFlow.enterBillingInfo();
		signupFlow.enterCredirCardInfo();
//		signupFlow.checkTOSandCheckout();
//		signup.verifyPay
//		mentComplete();
	}

}
