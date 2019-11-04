package hostgator;
import java.net.Inet4Address;
import java.net.UnknownHostException;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class recaptcha {
    @Test
    public void test() {
//        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/webDrivers/Mac/chromedriver");
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        BrowserMobProxy proxy = getProxyServer(); //getting browsermob proxy
//        Proxy seleniumProxy = getSeleniumProxy(proxy);
//        capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
//        WebDriver driver = new ChromeDriver(capabilities);
//        driver.get("https://hyperion-staging-portal.houston1.endurancedevs.com/signup/shared/29/36/SNAPPY");
    }
//    public Proxy getSeleniumProxy(BrowserMobProxy proxyServer) {
//        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxyServer);
//        try {
//            String hostIp = Inet4Address.getLocalHost().getHostAddress();
//            seleniumProxy.setHttpProxy(hostIp + ":" + proxyServer.getPort());
//            seleniumProxy.setSslProxy(hostIp + ":" + proxyServer.getPort());
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//            Assert.assertTrue(false,"invalid Host Address");
//        }
//        return seleniumProxy;
//    }
//    public BrowserMobProxy getProxyServer() {
//        BrowserMobProxy proxy = new BrowserMobProxyServer();
//        proxy.setTrustAllServers(true);
//        proxy.start();
//        proxy.addRequestFilter((request, contents, messageInfo) -> {
//            request.headers().add("X-GATOR-REQUESTOR", "jmorah-test");
//            request.headers().add("X-GATOR-AUTH", "87aa0de52ec992880513105308e3c990");
//            return null;
//        });
//        return proxy;
//    }
}