package hostgator;

import hostgator.driver.TestDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class recaptchaTest extends TestDriver {

	@BeforeMethod
	public void setup () throws IOException {
		driver = initializeDriver();
	}

	@Test(groups = {"SmokeTest", "SignupRegression"})
	public void recaptchaTest1() throws IOException, InterruptedException {
//		driver = initializeDriver();
		driver.get("https://www.google.com/");
		Thread.sleep(3000);
	}

	@Test(groups = {"SmokeTest", "SignupRegression"})
	public void recaptchaTest2() throws IOException, InterruptedException {
//		driver = initializeDriver();
		driver.get("https://www.apple.com/");
		Thread.sleep(3000);
	}

	@Test(groups = {"SmokeTest", "SignupRegression"})
	public void recaptchaTest3() throws IOException, InterruptedException {
//		driver = initializeDriver();
		driver.get("https://www.netflix.com/");
		Thread.sleep(3000);
	}

	@Test(groups = {"SmokeTest", "SignupRegression"})
	public void recaptchaTest4() throws IOException, InterruptedException {
//		driver = initializeDriver();
		driver.get("https://hyperion-staging-portal.houston1.endurancedevs.com/signup/shared/29/36/SNAPPY");
		Thread.sleep(3000);
	}
}