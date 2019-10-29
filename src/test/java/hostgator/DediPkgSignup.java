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
import java.util.Random;

public class DediPkgSignup extends TestDriver {
	Random random = new Random();
	private static Logger log = LogManager.getLogger(DediPkgSignup.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver =  initializeDriver("chrome");
		log.info("Driver is initialized");
//		driver.manage().window().maximize();
//		driver.get(prop.getProperty("qaAutoMaintenace")+StaticData.dediPkg);
		driver.get("https://portal10.hostgator.com/signup/dedicated/85/36/SNAPPY");
		log.info("Navigated to dedi pkg signup page");
	}
	
	@Test(groups  = {"SmokeTest", "SignupRegression"}) //HGQ-899
	public void DediToprightSigninExistingCustomerExistingDomainPP() throws InterruptedException, IOException {
		Signuppage signup=new Signuppage(driver);
		signup.ClickIAlreadyOwnThisDomian();
		String existingDomain = StaticData.domainName+random.nextInt(10000)+"dedi"+random.nextInt(100000)+".com";
		signup.EnterStoredExistingDomain(existingDomain);
		signup.BillingDropdown(0);
		signup.topRightSignIn(StaticData.sharedDefaultAccount);
		signup.ClickPayPalTab();
		Thread.sleep(4000); //explicit wait
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
