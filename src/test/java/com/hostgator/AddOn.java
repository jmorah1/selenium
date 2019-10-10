package com.hostgator;


import org.apache.logging.log4j.*;
import org.testng.Assert;
import org.testng.annotations.*;
import java.io.IOException;

import com.hostgator.driver.TestDriver;

public class AddOn extends TestDriver {

	private static Logger log = LogManager.getLogger(AddOn.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		log.error("class:AddOn Sample error message");
		log.info("class:AddOn Driver is initialized");

	}
	
	@Test
	public void hgq1128() throws IOException 
	{
		driver =  initializeDriver();
		driver.get(prop.getProperty("qaAutoMaintenace"));
		log.info("Got to hgq1128 placeholder");
		Assert.assertTrue(false);

	}
	
	@Test
	public void dummyAddon1() 
	{
		log.info("Got to dummyAddon1 placeholder");
		
	}
	
	@Test
	public void dummyAddon2() 
	{
		log.info("Got to dummyAddon2 placeholder");
		
	}
	
	@Test
	public void dummyAddon3()  
	{
		log.info("Got to dummyAddon3 placeholder");
		
	}
	
	@Test
	public void dummyAddon4() 
	{
		log.info("Got to dummyAddon4 placeholder");
		
	}
	
	@Test
	public void dummyAddon5() 
	{
		log.info("Got to dummyAddon5 placeholder");
		
	}
	
	@AfterTest
	public void teardown() {
		log.info("Got to class:AddOn Tear down");
	}

}
