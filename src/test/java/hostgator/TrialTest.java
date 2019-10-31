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

public class TrialTest extends TestDriver {

	private static Logger log = LogManager.getLogger(TrialTest.class.getName());
	Signuppage signup;

	@BeforeTest
	public void initialize() throws IOException {
//		driver =  initializeDriver();
		log.info("Driver is initialized");
	}

	
	@Test(groups  = {"SmokeTest", "SignupRegression"})
	public void TrialTest1() throws InterruptedException, IOException {
		driver =  initializeDriver();

		driver.get(prop.getProperty(MvnPassedEnvironment())+StaticData.dediPkg);
		log.info("Navigated to shared pkg signup page");
		signup =new Signuppage(driver);
		signup.EnterDomain(StaticData.domainName, "sharedpackage");
		signup.TldDropdown(0);
		Thread.sleep(2000);
		signup.BillingDropdown(0);
		Thread.sleep(2000);
		signup.EnterUsername(StaticData.userName);
		signup.EnterPin(StaticData.pin);
//		Assert.assertTrue(false, "TestMadeToFail");
	}

	@Test(groups  = {"SmokeTest", "SignupRegression"})
	public void TrialTest2() throws InterruptedException, IOException {
//		System.out.println(System.getProperty("user.dir"));
		driver =  initializeDriver();

		driver.get(prop.getProperty(MvnPassedEnvironment())+StaticData.sharedPkg);
		log.info("Navigated to shared pkg signup page");
		System.out.println("Drink Water \n   Mind your business \n      :)");
	}

	@Test(groups  = {"SmokeTest", "SignupRegression"})
	public void TrialTest3() throws IOException, InterruptedException {
		driver = initializeDriver();

		driver.get(prop.getProperty(MvnPassedEnvironment())+StaticData.cloudSitesPkg);
		log.info("Navigated to shared pkg signup page");

		signup=new Signuppage(driver);

		signup.EnterDomain(StaticData.domainName, "sharedpackage");
		signup.TldDropdown(0);
		Thread.sleep(2000);

	}
	
	@AfterTest
	public void teardown() {
//		driver.close();
		log.info("Closing Driver");
//		driver=null;
	}
}

