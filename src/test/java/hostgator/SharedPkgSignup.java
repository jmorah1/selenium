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


	@Test(groups  = {"SmokeTest", "SignupRegression"}) //HGQ-898
	public void SharedNewCustomerNewDomainCC() throws IOException, InterruptedException {
		signupFlow =new SignupCommonFlow(driver);
		signup     =new SignupPage(driver);
		signup.EnterDomain(StaticData.DOMAIN_NAME, "sharedpackage");
		signup.TldDropdown(0);
		signup.BillingDropdown(0);
		signup.EnterUsername(StaticData.USERNAME);
		signup.EnterPin(StaticData.PIN);
		signupFlow.enterEmailAndConfirm("shared");
		signupFlow.enterBillingInfo();
		signupFlow.enterCredirCardInfo();
		signupFlow.sharedPackageCheckTOSandCheckoutTwice();
		signup.VerifyPaymentComplete();
	}


	@AfterTest
	public void teardown() {
		driver.close();
		log.info("Closing Driver");
		driver=null;
	}
}
