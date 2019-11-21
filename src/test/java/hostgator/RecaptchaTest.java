package hostgator;

import hostgator.commonflow.SignupCommonFlow;
import hostgator.driver.BaseTestDriver;
import hostgator.pages.signup.SignupPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.io.IOException;

public class RecaptchaTest extends BaseTestDriver {

	private static Logger log = LogManager.getLogger(RecaptchaTest.class.getName());
    SignupPage signup;
	SignupCommonFlow signupFlow;


	@Test(groups  = {"SmokeTest", "SignupRegression"})
	public void HGQ_1133_vps_new_customer_existing_domain_cc() throws InterruptedException, IOException {
		driver.get("https://hyperion-staging-portal.houston1.endurancedevs.com/login");
//		Boolean isPresent = driver.findElements(By.xpath("/html/body/div[2]")).size() > 0;
//
//		if (isPresent){
//			System.out.println("Recaptcha logo is present");
//		} else System.out.println("no present");
		Thread.sleep(999999999);

	}

}
