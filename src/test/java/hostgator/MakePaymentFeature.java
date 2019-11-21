package hostgator;

import hostgator.driver.BaseTestDriver;
import hostgator.pages.portal.HomePage;
import hostgator.pages.portal.LoginPage;
import hostgator.pages.portal.billing.MakeAPaymentPage;
import hostgator.util.StaticData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.io.IOException;

public class MakePaymentFeature extends BaseTestDriver {
	private static Logger log = LogManager.getLogger(MakePaymentFeature.class.getName());

	@Test(groups  = {"SmokeTest", "SignupRegression"}) //HGQ-1124
	public void HGQ_1124_make_a_payment_feature_by_using_cc() throws IOException, InterruptedException {
		LoginPage portalLogin=new LoginPage(driver);
		HomePage homePage=new HomePage(driver);
		MakeAPaymentPage makeAPaymentPage = new MakeAPaymentPage(driver);

		portalLogin.gotoLoginPage();
		portalLogin.portalLogin(StaticData.SHARED_DEFAULT_EMAIL, StaticData.PORTAL_PASSWORD);
		homePage.navigateToMakePayment();
//		makeAPaymentPage.payWithCreditCard();

	}
	@Test(groups  = {"SmokeTest", "SignupRegression"}) //HGQ-1126
	public void HGQ_1126_Make_A_Payment_Feature_By_Using_PayPal() throws IOException, InterruptedException {
		LoginPage portalLogin=new LoginPage(driver);
		HomePage homePage=new HomePage(driver);
		MakeAPaymentPage makeAPaymentPage = new MakeAPaymentPage(driver);

		portalLogin.gotoLoginPage();
		portalLogin.portalLogin(StaticData.SHARED_DEFAULT_EMAIL, StaticData.PORTAL_PASSWORD);
		homePage.navigateToMakePayment();
//		makeAPaymentPage.payWithPayPal();
	}
}
