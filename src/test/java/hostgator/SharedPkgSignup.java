package hostgator;

import java.io.IOException;
import java.util.Random;

import hostgator.Pages.Signup.Signuppage;
import org.apache.logging.log4j.*;
import org.testng.annotations.*;

import hostgator.driver.TestDriver;
import hostgator.util.StaticData;

public class SharedPkgSignup extends TestDriver {

	private static Logger log = LogManager.getLogger(SharedPkgSignup.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver =  initializeDriver("chrome");
		log.info("Driver is initialized");
//		driver.manage().window().maximize();
		driver.get(prop.getProperty("qaAutoMaintenace")+StaticData.sharedPkg);
		log.info("Navigated to shared pkg signup page");
	}

	
	@Test(groups  = {"SmokeTest", "SignupRegression"}) //HGQ-898
	public void SharedNewCustomerNewDomainCC() throws IOException, InterruptedException {
		Signuppage signup=new Signuppage(driver);
		signup.EnterDomain(StaticData.domainName, "sharedpackage");
		signup.TldDropdown(0);
		Thread.sleep(2000);
		signup.BillingDropdown(0);
		Thread.sleep(2000);
		signup.EnterUsername(StaticData.userName);
		signup.EnterPin(StaticData.pin);
		signup.EnterEmailAndConfirm("shared");
		signup.enterBillingInfo();
		signup.enterCredirCardInfo();
		signup.TosCheckbox3();
		signup.ClickCheckout();
//		signup.ClickCheckout(); //Clicking checkout again cause first click loads up and does nothing
//		signup.verifyPaymentComplete();
	}

	
	@AfterTest
	public void teardown() {
		driver.close();
		log.info("Closing Driver");
		driver=null;
	}
}
