package hostgator;

import hostgator.commonflow.SignupCommonFlow;
import hostgator.pages.portal.HomePage;
import hostgator.pages.portal.HostingPage;
import hostgator.pages.portal.LoginPage;
import hostgator.pages.signup.SignupPage;
import hostgator.driver.TestDriver;
import hostgator.util.StaticData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class CheckHostingPage extends TestDriver {

    private static Logger log = LogManager.getLogger(CheckHostingPage.class.getName());
    LoginPage loginPage;
    HomePage homePage;
    HostingPage hosting;
    SignupPage signup;
    SignupCommonFlow signupFlow;

    @BeforeTest
    public void initialize() throws IOException {
        driver =  initializeDriver();
        driver.get(prop.getProperty(mvnPassedEnvironment()));
    }

    @Test(groups  = {"SmokeTest", "PortalRegression"})
    public void HGQ_1132_check_hosting_page() throws InterruptedException{
        loginPage  = new LoginPage(driver);
        homePage   = new HomePage(driver);
        hosting    = new HostingPage(driver);
        signup     = new SignupPage(driver);
        signupFlow = new SignupCommonFlow(driver);

        loginPage.portalLogin(StaticData.SHARED_DEFAULT_EMAIL, StaticData.PORTAL_PASSWORD);
        homePage.clickHosting();
        hosting.printPackages();
    }

    @AfterTest
    public void teardown() {
        driver.close();
        log.info("Closing Driver");
        driver=null;
    }
}