package hostgator;

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

	@BeforeTest
	public void initialize() throws IOException {
		driver =  initializeDriver();
//		driver.manage().window().maximize();
		driver.get(prop.getProperty(mvnPassedEnvironment())+StaticData.vpsPkg);
	}

	@Test(groups  = {"SmokeTest", "SignupRegression"}) //HGQ-1133
	public void VPSNewCustomerExistingDomainCC() throws InterruptedException, IOException {
		signup=new Signuppage(driver);
		signup.clickIAlreadyOwnThisDomian();
		signup.enterExistingDomain(StaticData.domainName, "vps");
		signup.billingDropdown(0);
		signup.enterPin(StaticData.pin);
		signup.enterEmailAndConfirm("cloud");
		signup.enterBillingInfo();
		signup.enterCredirCardInfo();
		signup.checkTOSandCheckout();
		signup.verifyPaymentComplete();
	}

	@AfterTest
	public void teardown() {
		driver.close();
		log.info("Closing Driver");
		driver=null;
	}
}
