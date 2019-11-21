package hostgator;

import hostgator.driver.BaseTestDriver;
import hostgator.pages.portal.HomePage;
import hostgator.pages.portal.HostingPage;
import hostgator.pages.portal.LoginPage;
import hostgator.util.StaticData;
import org.testng.annotations.Test;

import java.io.IOException;

public class CheckHostingPage extends BaseTestDriver {

    LoginPage loginPage;
    HomePage homePage;
    HostingPage hosting;

    @Test(groups  = {"SmokeTest", "Portal"})
    public void HGQ_1132_check_hosting_page() throws IOException {
        loginPage  = new LoginPage(driver);
        homePage   = new HomePage(driver);
        hosting    = new HostingPage(driver);

        loginPage.gotoLoginPage();
        loginPage.portalLogin(StaticData.SHARED_DEFAULT_EMAIL, StaticData.PORTAL_PASSWORD);
        homePage.clickHosting();
        hosting.printPackages();
    }
}