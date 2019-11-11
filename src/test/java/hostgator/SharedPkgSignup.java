package hostgator;

import java.io.IOException;

import hostgator.Pages.Signup.Signuppage;
import org.apache.logging.log4j.*;
import org.testng.annotations.*;

import hostgator.driver.TestDriver;
import hostgator.util.StaticData;

public class SharedPkgSignup extends TestDriver {

	private static Logger log = LogManager.getLogger(SharedPkgSignup.class.getName());
    Signuppage signup;

	@BeforeTest
	public void initialize() throws IOException {
		driver =  initializeDriver();
//		driver.manage().window().maximize();
		driver.get(prop.getProperty(mvnPassedEnvironment())+StaticData.sharedPkg);
		log.info("Navigated to shared pkg signup page");
	}


	@Test(groups  = {"SmokeTest", "SignupRegression"}) //HGQ-898
	public void SharedNewCustomerNewDomainCC() throws IOException, InterruptedException {
		signup=new Signuppage(driver);
		signup.enterDomain(StaticData.domainName, "sharedpackage");
		signup.tldDropdown(0);
//		Thread.sleep(2000);
		signup.billingDropdown(0);
//		Thread.sleep(2000);
		signup.enterUsername(StaticData.userName);
		signup.enterPin(StaticData.pin);
		signup.enterEmailAndConfirm("shared");
		signup.enterBillingInfo();
		signup.enterCredirCardInfo();
		signup.sharedPackageCheckTOSandCheckoutTwice();
		signup.verifyPaymentComplete();
	}


	@AfterTest
	public void teardown() {
		driver.close();
		log.info("Closing Driver");
		driver=null;
	}
}
