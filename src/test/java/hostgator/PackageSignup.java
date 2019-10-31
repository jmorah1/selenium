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

public class PackageSignup extends TestDriver {
	Random random = new Random();
	private static Logger log = LogManager.getLogger(PackageSignup.class.getName());
	Signuppage signup;

	@BeforeTest
	public void initialize() throws IOException {
		driver =  initializeDriver();
		log.info("Driver is initialized");
//		driver.manage().window().maximize();
		driver.get(prop.getProperty(MvnPassedEnvironment())+StaticData.sharedPkg);
		log.info("Navigated to shared pkg signup page");
	}

	
	@Test(groups  = {"SmokeTest", "SignupRegression"}) //HGQ-898
	public void Shared1() throws IOException, InterruptedException {
		signup=new Signuppage(driver);

		signup.EnterDomain(StaticData.domainName, "sharedpackage");
		signup.TldDropdown(0);
		Thread.sleep(2000);

	}

	@Test(groups  = {"SmokeTest", "SignupRegression"}) //HGQ-898
	public void Shared2() throws IOException, InterruptedException {
		signup=new Signuppage(driver);
		driver.get(prop.getProperty(MvnPassedEnvironment())+StaticData.dediPkg);

		signup.ClickIAlreadyOwnThisDomian();
		String existingDomain = StaticData.domainName+random.nextInt(10000)+"dedi"+random.nextInt(100000)+".com";
		signup.EnterStoredExistingDomain(existingDomain);
		Thread.sleep(3000);

	}

	
	@AfterTest
	public void teardown() {
		driver.close();
		log.info("Closing Driver");
		driver=null;
	}
}
