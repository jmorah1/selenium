package com.hostgator;

import org.apache.logging.log4j.*;
import org.testng.annotations.*;

import com.hostgator.driver.TestDriver;

public class MakePaymentFeature extends TestDriver {

	private static Logger log = LogManager.getLogger(MakePaymentFeature.class.getName());

	@BeforeTest
	public void initialize() {
		log.info("Driver is initialized");
	}
	
	@Test
	public void hgq1124()  
	{
		log.info("Got to hgq1124 dummy placeholder");
		
	}
	
	@Test
	public void hgq1126() 
	{
		log.info("Got to hgq1126 dummy placeholder");
	
	}
	
	@AfterTest
	public void teardown() {
		log.info("Got to Tear Down");
	}

}
