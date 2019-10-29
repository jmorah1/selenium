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
import java.util.Random;

public class OWPSignup extends TestDriver {

	private static Logger log = LogManager.getLogger(OWPSignup.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver =  initializeDriver("chrome");
		log.info("Driver is initialized");
//		driver.manage().window().maximize();
//		driver.get(prop.getProperty("qaAutoMaintenace")+StaticData.wordPressPkg);
		driver.get("https://portal10.hostgator.com/signup/wordpress/83021/36/SNAPPYW579");
		log.info("Navigated to OWP pkg signup page");
	}

	@Test(groups  = {"SmokeTest", "SignupRegression"}) //HGQ-900
	public void WordpressExistingCustomerExistingDomainCC() throws InterruptedException, IOException {
		Signuppage signup=new Signuppage(driver);
		signup.ClickIAlreadyOwnThisDomian();
		signup.EnterExistingDomain(StaticData.domainName, "owp");
		signup.BillingDropdown(0);
		Thread.sleep(3000);
		signup.EnterPin(StaticData.pin);
		signup.existingEmailSignIn(StaticData.sharedDefaultEmail, StaticData.defaultPassword);
		signup.checkTOSandCheckout();
//		signup.verifyPaymentComplete();
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		log.info("Closing Driver");
		driver=null;
	}
}
