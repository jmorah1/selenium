package hostgator;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.HarEntry;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.List;

public class recaptcha3 {
@Test
    public void test() throws Exception {

    String url = "https://hyperion-staging-portal.houston1.endurancedevs.com/signup/shared/29/36/SNAPPY";
    String HeaderName1 = "X-GATOR-REQUESTOR";
    String HeaderValue1 = "jmorah-test";
    String HeaderName2 = "X-GATOR-AUTH";
    String HeaderValue2 = "87aa0de52ec992880513105308e3c990";

        // add the ModHeader extension
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File(System.getProperty("user.dir")+"/Modify-Header-Value-v0.1.6.crx"));

        // launch the browser
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/webDrivers/Mac/chromedriver");

        WebDriver driver = new ChromeDriver(options);

        // set the context on the extension so the localStorage can be accessed
        driver.get("chrome-extension://cbdibdfhahmknbkkojljfncpnhmacdek/data/options/options.html");

        driver.findElement(By.xpath("//*[@id=\"input-field\"]/td[1]/input")).sendKeys(url);
        driver.findElement(By.xpath("//*[@id=\"input-field\"]/td[2]/input")).sendKeys(HeaderName1);
        driver.findElement(By.xpath("//*[@id=\"input-field\"]/td[3]/input")).sendKeys(HeaderValue1);
        driver.findElement(By.id("input-field-add")).click();

        driver.findElement(By.xpath("//*[@id=\"input-field\"]/td[2]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"input-field\"]/td[2]/input")).sendKeys(HeaderName2);
        driver.findElement(By.xpath("//*[@id=\"input-field\"]/td[3]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"input-field\"]/td[3]/input")).sendKeys(HeaderValue2);
        driver.findElement(By.id("input-field-add")).click();

        driver.get(url);
        Thread.sleep(999999);
    }

}