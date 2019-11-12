package hostgator;

import java.io.IOException;

import hostgator.CommonFlow.SignupCommonFlow;
import hostgator.Pages.Signup.Signuppage;
import org.apache.logging.log4j.*;
import org.testng.annotations.*;

import hostgator.driver.TestDriver;
import hostgator.util.StaticData;

public class SharedPkgSignup extends TestDriver {

	private static Logger log = LogManager.getLogger(SharedPkgSignup.class.getName());
    Signuppage signup;
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
		signup     =new Signuppage(driver);
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
