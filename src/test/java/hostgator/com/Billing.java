package hostgator.com;


import java.io.IOException;
import java.util.Random;


import org.apache.logging.log4j.*;
import org.testng.annotations.*;

import hostgator.com.driver.TestDriver;
import hostgator.com.util.com.hostgator.util.StaticData;

import hostgator.com.CommonFlow.SignupCommonFlow;
import hostgator.com.Pages.*;

public class Billing extends TestDriver {

    TestDriver testDriver=new TestDriver();
    Random random = new Random();

    private static Logger log = LogManager.getLogger(PkgSignup.class.getName());

    @BeforeClass
    //@BeforeTest
    public void initialize() throws IOException {
//		driver =  initializeDriver();
//		log.info("Driver is initialized");
    }

    @BeforeMethod
    public void beforeMethod() {
//		driver.manage().window().maximize();

    }

    @Test(groups  = {"SmokeTest", "BillingRegression"}) //HGQ-1127
    public void VerifyBillingHistory() throws IOException, InterruptedException {
        driver =  initializeDriver();
        driver.manage().window().maximize();

        driver.get(prop.getProperty("qaAutoMaintenace"));
        log.info("Navigated to Portal page");

        LoginPage portalLogin=new LoginPage(driver);
        PortalHomePage portalHomePage=new PortalHomePage(driver);

        portalLogin.portalLogin(StaticData.sharedDefaultEmail, StaticData.portalPassword);
        portalHomePage.clickBillingNav();

        /*template_1: 'hostgator/templates/hostgator/login_to_portal_generic_shared_template'
        template_2: 'hostgator/templates/hostgator/portal_billing_history_fetch_latest_invoice_template' */
        driver.close();
    }



    @AfterMethod
    public void afterMethod() throws InterruptedException {
//		driver.close();

    }

    @AfterClass
    public void teardown() {
//		driver.close();
//		log.info("Closing Driver");
        driver=null;
    }
}
