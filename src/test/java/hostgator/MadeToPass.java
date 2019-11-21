package hostgator;

import hostgator.driver.TestDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MadeToPass {
	private static Logger log = LogManager.getLogger(TestDriver.class.getName());

	@Test(groups  = {"SmokeTest", "SignupRegression"}) //HGQ-899
	public void PassingTest() {
		log.info("Test made to Assert.assertTrue");
		Assert.assertTrue(true);
	}
}
