package hostgator.driver;

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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TakesScreenshot;

public class TestDriver {

	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver(String browser) throws IOException
	{
	
		prop=new Properties();                
		FileInputStream fis=new FileInputStream("./src/main/java/hostgator/util/browser.properties");
		
		FileInputStream fis2=new FileInputStream("./Environments.properties");
		
		prop.load(fis);
		prop.load(fis2);
		
		String os = System.getProperty("os.name");

//		String browserName = prop.getProperty("browser");
		String browserName = browser;
//		String browserName = System.getProperty("browser");

		if(os.contains("Windows")) {
			if (browserName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./webDrivers/Windows/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browserName.equals("firefox")) {
				System.setProperty("webdriver.chrome.driver", "./webDrivers/Windows/geckodriver");
				driver = new FirefoxDriver();
			}
		}

		if(os.contains("Mac")) {
			if (browserName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./webDrivers/Mac/chromedriver");
				driver = new ChromeDriver();
			} else if (browserName.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./webDrivers/Mac/geckodriver");
				driver = new FirefoxDriver();
			}
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
		
	}
	//Takes screenshot of section of page 
	public void getScreenshot(String result) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("./Screenshots/"+result+"-Screenshot1.png")); ///Users/jmorah/git/automation/Screenshots
	}
	
//	//Full page Screenshot. currently takes screenshot of half of page (horizontally)
//	public void getShot(String result) throws IOException {
//		Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
//		ImageIO.write(fpScreenshot.getImage(),"PNG",new File("./Screenshots/"+result+"-FullPageScreenshot.png"));
//	}
//
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

//	public void selectButtonBuy(String element) {
//		JavascriptExecutor executor = (JavascriptExecutor)driver;
//		executor.executeScript("arguments[0].click();", element);
//	}

	//	public void anotherscreenshotLib () {
//		//Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE).save("/Users/jmorah/Documents/Screenshot.png"); //.WHOLE_PAGE).save("C:\\testing\\screenshots\\");
//		Shutterbug.shootPage(driver).withName("automationtestingscreenshot").save("/Users/jmorah/Documents/");
//	}
	
}
