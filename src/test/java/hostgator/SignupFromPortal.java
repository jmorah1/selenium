package hostgator;

import hostgator.commonflow.SignupCommonFlow;
import hostgator.driver.BaseTestDriver;
import hostgator.pages.portal.HomePage;
import hostgator.pages.portal.HostingPage;
import hostgator.pages.portal.LoginPage;
import hostgator.pages.signup.SignupPage;
import hostgator.util.StaticData;
import org.testng.annotations.Test;

import java.io.IOException;

public class SignupFromPortal extends BaseTestDriver {
	@Test(groups  = {"SmokeTest", "SignupRegression"})
	public void HGQ_1125_shared_existing_customer_signup_from_portal_cc() throws InterruptedException, IOException {
		HostingPage hosting             = new HostingPage(driver);
		HomePage homePage           = new HomePage(driver);
		LoginPage loginPage         = new LoginPage(driver);
		SignupPage signup           = new SignupPage(driver);
		SignupCommonFlow signupFlow = new SignupCommonFlow(driver);

		loginPage.gotoLoginPage();
		loginPage.portalLogin(StaticData.SHARED_DEFAULT_EMAIL, StaticData.PORTAL_PASSWORD);
		homePage.clickHosting();
		hosting.addPackage();
		hosting.shared();
		signup.clickIAlreadyOwnThisDomain();
		signup.enterExistingDomain(StaticData.DOMAIN_NAME, "shared");
		signup.billingDropdown(0);
		signup.enterUsername(StaticData.USERNAME);
//		signupFlow.sharedPackageCheckTOSandCheckoutTwice();
//		signup.verifyPaymentComplete();
	}
}