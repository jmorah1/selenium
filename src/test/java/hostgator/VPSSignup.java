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

public class VPSSignup extends TestDriver {

	private static Logger log = LogManager.getLogger(VPSSignup.class.getName());
    Signuppage signup;
	SignupCommonFlow signupFlow;

	@BeforeTest
	public void initialize() throws IOException {
		driver =  initializeDriver();
		driver.get(prop.getProperty(mvnPassedEnvironment())+StaticData.vpsPkg);
	}

	@Test(groups  = {"SmokeTest", "SignupRegression"}) //HGQ-1133
	public void VPSNewCustomerExistingDomainCC() throws InterruptedException, IOException {
		signup=new Signuppage(driver);
		signupFlow = new SignupCommonFlow(driver);

		signup.clickIAlreadyOwnThisDomian();
		signup.enterExistingDomain(StaticData.domainName, "vps");
		signup.billingDropdown(0);
		signup.enterPin(StaticData.pin);
		signupFlow.enterEmailAndConfirm("cloud");
		signupFlow.enterBillingInfo();
		signupFlow.enterCredirCardInfo();
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