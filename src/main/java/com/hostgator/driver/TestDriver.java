package com.hostgator.driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;




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
		FileUtils.copyFile(src,new File("/Users/jmorah/git/automation/Screenshots/"+result+"-failureScreenshot.png")); ///Users/jmorah/git/automation/Screenshots
	}
	
	//Full page Screenshot. currently takes screenshot of half of page (horizontally)
	public void getShot(String result) throws IOException {
		Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(fpScreenshot.getImage(),"PNG",new File("/Users/jmorah/git/automation/Screenshots/"+result+"-FullPageScreenshot.png"));
	}
	
}
