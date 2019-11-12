package hostgator;

import hostgator.CommonFlow.SignupCommonFlow;
import hostgator.Pages.Signup.Signuppage;
import hostgator.driver.TestDriver;
import hostgator.util.StaticData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class OWPSignup extends TestDriver {

	private static Logger log = LogManager.getLogger(OWPSignup.class.getName());
    Signuppage signup;
    SignupCommonFlow signupFlow;

	@BeforeTest
	public void initialize() throws IOException {
		driver =  initializeDriver();
//		driver.manage().window().maximize();
		driver.get(prop.getProperty(mvnPassedEnvironment())+StaticData.wordPressPkg);
	}

	@Test(groups  = {"SmokeTest", "SignupRegression"}) //HGQ-900
	public void WordpressExistingCustomerExistingDomainCC() throws InterruptedException, IOException {
		signup=new Signuppage(driver);
		signupFlow =new SignupCommonFlow(driver);
		signup.clickIAlreadyOwnThisDomian();
		signup.enterExistingDomain(StaticData.domainName, "owp");
		signup.billingDropdown(0);
		signup.enterPin(StaticData.pin);
		signup.existingEmailSignIn(StaticData.sharedDefaultEmail, StaticData.defaultPassword);
		signupFlow.checkTOSandCheckout();
		signup.verifyPaymentComplete();
	}

	@AfterTest
	public void teardown() {
		driver.close();
		log.info("Closing Driver");
		driver=null;
	}
}
