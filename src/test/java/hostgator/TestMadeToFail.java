package hostgator;

import hostgator.Pages.Signup.Signuppage;
import hostgator.driver.TestDriver;
import hostgator.util.StaticData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestMadeToFail extends TestDriver {

	private static Logger log = LogManager.getLogger(TestMadeToFail.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver =  initializeDriver("chrome");
		log.info("Driver is initialized");
//		driver.manage().window().maximize();
		driver.get(prop.getProperty("qaAutoMaintenace")+StaticData.sharedPkg);
		log.info("Navigated to shared pkg signup page");
	}

	
	@Test(groups  = {"SmokeTest", "SignupRegression"}) //HGQ-898
	public void TestMadeToPass() throws InterruptedException {
		Signuppage signup=new Signuppage(driver);
		signup.EnterDomain(StaticData.domainName, "sharedpackage");
		signup.TldDropdown(0);
		Thread.sleep(2000);
		signup.BillingDropdown(0);
		Thread.sleep(2000);
		signup.EnterUsername(StaticData.userName);
		signup.EnterPin(StaticData.pin);
//		Assert.assertTrue(false, "TestMadeToFail");
	}

	
	@AfterTest
	public void teardown() {
		driver.close();
		log.info("Closing Driver");
		driver=null;
	}
}
