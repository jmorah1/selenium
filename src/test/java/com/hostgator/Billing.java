package com.hostgator;

import org.apache.logging.log4j.*;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;

import com.hostgator.driver.TestDriver;

public class Billing extends TestDriver {

	private static Logger log = LogManager.getLogger(Billing.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		log.info("Driver is initialized");

	}
	
	@Test
	public void hgq1127() 
	{
		log.info("Got to hgq1127 dummy placeholder");
		
	}
	
	@Test
	public void testplaceholder()
	{
		log.info("Got to test placeholder");
		
	}

	@AfterTest
	public void teardown() {

		log.info("Got to Tear Down");
	}
}
