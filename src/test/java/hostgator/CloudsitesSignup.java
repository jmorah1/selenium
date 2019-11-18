package hostgator;

import hostgator.commonflow.SignupCommonFlow;
import hostgator.pages.signup.SignupPage;
import hostgator.driver.TestDriver;
import hostgator.util.StaticData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class CloudsitesSignup extends TestDriver {
    private static Logger log = LogManager.getLogger(CloudsitesSignup.class.getName());
    SignupPage signup;
    SignupCommonFlow signupFlow;

    @BeforeTest
    public void initialize() throws IOException {
        driver =  initializeDriver();
        driver.get(prop.getProperty(mvnPassedEnvironment())+StaticData.CLOUDSITES_PKG);
        log.info("Navigated to cloud sites pkg signup page");
    }

    @Test(groups  = {"SmokeTest", "SignupRegression"})
    public void HGQ_1134_cloudsites_new_customer_existing_domain_pp() throws InterruptedException, IOException {
        signup=new SignupPage(driver);
        signupFlow =new SignupCommonFlow(driver);

        signup.clickIAlreadyOwnThisDomain();
        signup.enterExistingDomain(StaticData.DOMAIN_NAME, "dedi");
        signup.billingDropdown(0);
        signup.enterPin(StaticData.PIN);
        signupFlow.enterEmailAndConfirm("shared");
        signupFlow.enterBillingInfo();
        signup.clickPaypalPaymentType();
        signupFlow.checkTOSandCheckout();
        signup.paypalLogin();
        signup.verifyPaymentComplete();
    }

    @AfterTest
    public void teardown() {
        driver.close();
        log.info("Closing Driver");
        driver=null;
    }
}