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

public class ResellerSignup extends TestDriver {

	private static Logger log = LogManager.getLogger(ResellerSignup.class.getName());
    Signuppage signup;

	@BeforeTest
	public void initialize() throws IOException {
		driver =  initializeDriver();
//		driver.manage().window().maximize();
		driver.get(prop.getProperty(MvnPassedEnvironment())+StaticData.resellerPkg);
	}

	@Test(groups  = {"SmokeTest", "SignupRegression"})  //HGQ-1125
	public void ResellerExistingCustomerTopRightSigninExistingDomainPP() throws InterruptedException {
		signup=new Signuppage(driver);
		signup.ClickIAlreadyOwnThisDomian();
		signup.EnterExistingDomain(StaticData.domainName, "reseller");
		signup.BillingDropdown(0);
		signup.topRightSignIn(StaticData.resellerDefaultAccount);
		signup.EnterUsername(StaticData.userName);
		signup.ClickPayPalTab();
		Thread.sleep(4000); //explicit wait
		signup.checkTOSandCheckout();
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
