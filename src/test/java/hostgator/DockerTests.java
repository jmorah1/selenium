package hostgator;

import hostgator.driver.BaseTestDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class DockerTests extends BaseTestDriver {
	private static Logger log = LogManager.getLogger(DockerTests.class.getName());

	@Test
	public void Test1() throws InterruptedException {
		driver.get("http://www.google.com");
		System.out.println("Title of page is "+driver.getTitle());
		System.out.println("URL of page is "+driver.getCurrentUrl());
		log.info("Got to Test1///////find me/////////aaaaabbbbbb");
	}

	@Test
	public void Test2() throws InterruptedException{
		driver.get("http://www.netflix.com/");
		log.info("Title of page is "+driver.getCurrentUrl());
		log.info("URL of page is "+driver.getTitle());
		System.out.println("Page Title 2 is " + driver.getTitle());
		log.info("Got to Test2///////find me/////////aaaaaabbbbbb");
	}

	@Test
	public void Test3() throws InterruptedException{
		driver.get("http://www.apple.com/");
		log.info("Title of page is "+driver.getCurrentUrl());
		log.info("URL of page is "+driver.getTitle());
		System.out.println("Page Title 3 is " + driver.getTitle());
		log.info("Got to Test3///////find me/////////aaaaaabbbbb");
	}
}
