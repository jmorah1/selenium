package hostgator;

import java.io.IOException;

import hostgator.commonflow.SignupCommonFlow;
import hostgator.pages.signup.SignupPage;
import org.apache.logging.log4j.*;
import org.testng.annotations.*;

import hostgator.driver.TestDriver;
import hostgator.util.StaticData;

public class SharedPkgSignup extends TestDriver {

	private static Logger log = LogManager.getLogger(SharedPkgSignup.class.getName());
    SignupPage signup;
	SignupCommonFlow signupFlow;

	@BeforeTest
	public void initialize() throws IOException {
		driver =  initializeDriver();
//		driver.manage().window().maximize();
		driver.get(prop.getProperty(mvnPassedEnvironment())+StaticData.SHARED_PKG);
		log.info("Navigated to shared pkg signup page");
	}


	@Test(groups  = {"SmokeTest", "SignupRegression"}) //
	public void HGQ_898_shared_new_customer_new_domain_cc() throws IOException, InterruptedException {
		signupFlow =new SignupCommonFlow(driver);
		signup     =new SignupPage(driver);
		signup.enterDomain(StaticData.DOMAIN_NAME, "sharedpackage");
		signup.tldDropdown(0);
		signup.billingDropdown(0);
		signup.enterUsername(StaticData.USERNAME);
		signup.enterPin(StaticData.PIN);
		signupFlow.enterEmailAndConfirm("shared");
		signupFlow.enterBillingInfo();
		signupFlow.enterCredirCardInfo();
		signupFlow.sharedPackageCheckTOSandCheckoutTwice();
		signup.verifyPaymentComplete();
	}


	@AfterTest
	public void teardown() {
		driver.close();
		log.info("Closing Driver");
		driver=null;
	}
}
