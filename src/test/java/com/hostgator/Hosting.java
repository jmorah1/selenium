package com.hostgator;

import org.apache.logging.log4j.*;

import org.testng.annotations.*;

import com.hostgator.driver.TestDriver;

public class Hosting extends TestDriver {

	private static Logger log = LogManager.getLogger(Hosting.class.getName());

	@BeforeTest
	public void initialize() {
		log.info("Driver is initialized");

	}
	
	@Test
	public void hgq1132() {
		log.info("Got to hgq1132 dummy placeholder");
		
	}
	
	@AfterTest
	public void teardown() {
		log.info("Got to Tear Down");
	}

}
