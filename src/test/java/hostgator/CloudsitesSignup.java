package hostgator;

import hostgator.commonflow.SignupCommonFlow;
import hostgator.driver.BaseTestDriver;
import hostgator.pages.signup.SignupPage;
import hostgator.util.StaticData;
import org.testng.annotations.Test;

import java.io.IOException;

public class CloudsitesSignup extends BaseTestDriver {
    SignupPage signup;
    SignupCommonFlow signupFlow;


    @Test(groups  = {"SmokeTest", "Signup", "PaypalSignup"})
    public void HGQ_1134_cloudsites_new_customer_existing_domain_pp() throws InterruptedException, IOException {
        signup=new SignupPage(driver);
        signupFlow =new SignupCommonFlow(driver);

        signup.gotoSIgnupPage(StaticData.CLOUDSITES_PKG);
        signup.clickIAlreadyOwnThisDomain();
        signup.enterExistingDomain(StaticData.DOMAIN_NAME, "cloud");
        signup.billingDropdown(0);
        signup.enterPin(StaticData.PIN);
        signupFlow.enterEmailAndConfirm("shared");
        signupFlow.enterBillingInfo();
        signup.clickPaypalPaymentType();
//        signupFlow.checkTOSandCheckout();
//        signup.paypalLogin();
//        signup.verifyPaymentComplete();
    }
}