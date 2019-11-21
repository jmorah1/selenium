package hostgator;

import hostgator.driver.BaseTestDriver;
import hostgator.pages.domain.CartCheckout;
import hostgator.pages.domain.DomainRegistration;
import hostgator.util.StaticData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.io.IOException;

public class DomainPurchase extends BaseTestDriver {

	private static Logger log = LogManager.getLogger(DomainPurchase.class.getName());
	DomainRegistration domainRegistration;
	CartCheckout cartCheckout;

	//This test is incomplete
	@Test(groups  = {"SmokeTest", "SignupRegression"})
	public void HGQ_1129_new_customer_new_domain_cc() throws InterruptedException, IOException {
		domainRegistration =new DomainRegistration(driver);
		cartCheckout =new CartCheckout(driver);

		domainRegistration.gotoDomainRegistrationPage();
		domainRegistration.enterDomainAndSearch();
		domainRegistration.clickContinueCheckoutButton();
		cartCheckout.enterEmail();
		cartCheckout.enterConfirmPassword(StaticData.DEFAULT_PASSWORD);
		cartCheckout.clickContinue();
		cartCheckout.enterBillingInfo();
		cartCheckout.enterCCInfo();
//		cartCheckout.clickContinueToCheckout();
//		cartCheckout.acceptTOSAndPlaceOrder();
	}
}