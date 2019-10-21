package com.hostgator.driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;


//import net.lightbody.bmp.BrowserMobProxy;
//import net.lightbody.bmp.BrowserMobProxyServer;
//import net.lightbody.bmp.client.ClientUtil;

public class TestDriver {

	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException
	{
	
		prop=new Properties();                
		FileInputStream fis=new FileInputStream("/Users/jmorah/git/automation/src/main/java/com/hostgator/util/browser.properties");
		
		FileInputStream fis2=new FileInputStream("/Users/jmorah/git/automation/Environments.properties");	
		
		prop.load(fis);
		prop.load(fis2);
		

		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			BrowserMobProxy proxy = new BrowserMobProxyServer();
		    proxy.start(); // can specify a port here if you like

		    // get the selenium proxy object
		    Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
		    proxy.addHeader("X-GATOR-REQUESTOR", "jjones-test");
		    proxy.addHeader("X-GATOR-AUTH", "f57dc3764b5d9fe2f179cfc4f7aeee55");

		    DesiredCapabilities capabilities = new DesiredCapabilities();
		    capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);


	        // Setting up Proxy for chrome
	        ChromeOptions opts = new ChromeOptions();
	        String proxyOption = "--proxy-server=" + seleniumProxy.getHttpProxy();
	        opts.addArguments(proxyOption);
	        
			System.setProperty("webdriver.chrome.driver", "/Users/jmorah/git/automation/webDrivers/chromedriver");
			driver=new ChromeDriver();
		}
		else if (browserName.equals("firefox")){
			System.setProperty("webdriver.chrome.driver", "/Users/jmorah/git/automation/webDrivers/geckodriver");
			driver=new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
		
	}
	//Takes screenshot of section of page 
	public void getScreenshot(String result) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("/Users/jmorah/git/automation/Screenshots/"+result+"-Screenshot1.png")); ///Users/jmorah/git/automation/Screenshots
	}
	
	//Full page Screenshot. currently takes screenshot of half of page (horizontally)
	public void getShot(String result) throws IOException {
		Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(fpScreenshot.getImage(),"PNG",new File("/Users/jmorah/git/automation/Screenshots/"+result+"-FullPageScreenshot.png"));
	}
	
	public void analyzeLog(String result) {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            System.out.println("\n\nConsole logs for " +result + " testcase - \n" + new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage() + "\nEnd Console logs \n\n");
            //do something else with the data
        }
    }
	
	public void waitUntilID(int waitTime, String id) {
		
		@SuppressWarnings("deprecation")
		WebDriverWait w = new WebDriverWait(driver, waitTime);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
	}

//	public void anotherscreenshotLib () {
//		//Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE).save("/Users/jmorah/Documents/Screenshot.png"); //.WHOLE_PAGE).save("C:\\testing\\screenshots\\");
//		Shutterbug.shootPage(driver).withName("automationtestingscreenshot").save("/Users/jmorah/Documents/");
//	}
	
}
