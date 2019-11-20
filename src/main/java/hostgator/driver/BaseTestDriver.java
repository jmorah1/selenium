package hostgator.driver;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.Inet4Address;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Date;

public class BaseTestDriver {
    protected WebDriver driver;
    private static Logger log = LogManager.getLogger(TestDriver2.class.getName());

    @BeforeTest
    public void setupDriver(ITestContext ctx) throws MalformedURLException {
        // BROWSER => chrome / firefox
        // HUB_HOST => localhost / 10.0.1.3 / hostname

        String host = "localhost";
        DesiredCapabilities capabilities = new DesiredCapabilities();

        if(System.getProperty("BROWSER") != null &&
                System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
            capabilities.setCapability(CapabilityType.BROWSER_NAME,"firefox");
        }else{
            capabilities.setCapability(CapabilityType.BROWSER_NAME,"chrome");
        }

        if(System.getProperty("HUB_HOST") != null){
            host = System.getProperty("HUB_HOST");
        }

        String testName = ctx.getCurrentXmlTest().getName();
        String completeUrl = "http://" + host + ":4444/wd/hub";
        capabilities.setCapability("name", testName);

        //
        BrowserMobProxy proxy = getProxyServer(); //getting browsermob proxy
        Proxy seleniumProxy = getSeleniumProxy(proxy);
        capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
        //
        this.driver = new RemoteWebDriver(new URL(completeUrl), capabilities);
        log.info("Chrome remote Driver is initialized");
    }

    @AfterTest
    public void quitDriver(){
        this.driver.quit();
        log.info("Closing remote Driver");
    }

    public Proxy getSeleniumProxy(BrowserMobProxy proxyServer) {
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxyServer);
        try {
            String hostIp = Inet4Address.getLocalHost().getHostAddress();
            seleniumProxy.setHttpProxy(hostIp + ":" + proxyServer.getPort());
            seleniumProxy.setSslProxy(hostIp + ":" + proxyServer.getPort());
        } catch (UnknownHostException e) {
            e.printStackTrace();
            Assert.assertTrue(false,"invalid Host Address");
        }
        return seleniumProxy;
    }

    public BrowserMobProxy getProxyServer() {
        BrowserMobProxy proxy = new BrowserMobProxyServer();
//        proxy.setTrustAllServers(true); //currently not connecting to any https
        proxy.start();
        proxy.addRequestFilter((request, contents, messageInfo) -> {
            request.headers().add("X-GATOR-REQUESTOR", "jmorah-test");
            request.headers().add("X-GATOR-AUTH", "87aa0de52ec992880513105308e3c990"); //portal10
//			request.headers().add("X-GATOR-AUTH", "de0bc963131a815c9ab58d95bd46e790");
            return null;
        });
        return proxy;
    }

    public void analyzeLog(String result) {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            System.out.println("\n\nConsole logs for " +result + " testcase - \n" + new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage() + "\nEnd Console logs \n\n");
            //do something else with the data
        }
    }

    public String mvnPassedEnvironment() {
        String defaultEnvironment = "qaAutoMaintenance";
        String environmentVariable = System.getProperty("environment");
        if (environmentVariable==null) {
            environmentVariable = defaultEnvironment;
            log.info("No Environment variable passed, defaulting to " +defaultEnvironment);
        }
        return environmentVariable;
    }

    public void waitUntilID(int waitTime, String id) {
        @SuppressWarnings("deprecation")
        WebDriverWait w = new WebDriverWait(driver, waitTime);
        w.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
    }
}