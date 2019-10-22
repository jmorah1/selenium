package hostgator;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import hostgator.driver.TestDriver;

public class Listener implements ITestListener{

	private static Logger log = LogManager.getLogger(Listener.class.getName());

	TestDriver testDriver=new TestDriver();

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Starting Test - "+result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Passed - "+result.getName()+" Test");
	}

	public void onTestFailure(ITestResult result) {
		try {
			testDriver.getScreenshot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			testDriver.getShot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//testDriver.anotherscreenshotLib();
		testDriver.analyzeLog(result.getName());
		System.out.println("Failed - "+result.getName()+" Test");
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Skipped Test - "+result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}
}