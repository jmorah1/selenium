package hostgator;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class recaptcha2 {

    WebDriver driver;

    @BeforeTest
    public void setUp() {

        BrowserMobProxy proxy = new BrowserMobProxyServer();
        proxy.start(0);
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);

        // put our custom header to each request
        proxy.addRequestFilter((request, contents, messageInfo) -> {
            request.headers().add("my-test-header", "my-test-value");
            System.out.println(request.headers().entries().toString());
            return null;
        });

        // Setting up Proxy for chrome
        ChromeOptions opts = new ChromeOptions();
        String proxyOption = "--proxy-server=" + seleniumProxy.getHttpProxy();
        opts.addArguments(proxyOption);
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/webDrivers/Mac/chromedriver");
        driver = new ChromeDriver(opts);
    }

    @Test
    public void testProxifying() throws InterruptedException {
        driver.get("http://google.com");
//        Assert.assertEquals(driver.findElement(By.xpath("//body")).getText(), "{\"SUCCESS\"}");
        Thread.sleep(999999);
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Driver was instantiated. Quitting..");
        } else {
            System.out.println("Driver was null so nothing to do");
        }
    }
}