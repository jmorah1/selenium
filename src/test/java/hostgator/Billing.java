package hostgator;

import hostgator.driver.BaseTestDriver;
import hostgator.pages.portal.HomePage;
import hostgator.pages.portal.LoginPage;
import hostgator.pages.portal.billing.BillingHistoryPage;
import hostgator.util.StaticData;
import org.testng.annotations.Test;

import java.io.IOException;

public class Billing extends BaseTestDriver {
    @Test(groups  = {"SmokeTest", "Billing"}) //HGQ-1127
    public void HGQ_1127_verify_billing_history() throws IOException {
        LoginPage portalLogin=new LoginPage(driver);
        HomePage homePage=new HomePage(driver);

        portalLogin.gotoLoginPage();
        BillingHistoryPage billingHistoryPage = new BillingHistoryPage(driver);
        portalLogin.portalLogin(StaticData.SHARED_DEFAULT_EMAIL, StaticData.PORTAL_PASSWORD);
        homePage.navigateToBillingHistory();
        billingHistoryPage.printInvoiceNumbers();
    }
}
