package com.hostgator;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.hostgator.driver.TestDriver;

public class Listener implements ITestListener{

	TestDriver testDriver=new TestDriver();
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Starting Test - "+result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test - "+result.getName()+"Passed");
	}

	public void onTestFailure(ITestResult result) {
		
		try {
			testDriver.getShot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Test - "+result.getName()+"Failed");
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
