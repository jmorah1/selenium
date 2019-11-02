package hostgator;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.List;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.HarEntry;
import org.testng.Assert;
import org.testng.annotations.Test;

public class recaptcha {
    @Test
    public void test() throws Exception {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/webDrivers/Mac/chromedriver");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        BrowserMobProxy proxy = getProxyServer(); //getting browsermob proxy
        Proxy seleniumProxy = getSeleniumProxy(proxy);
        capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
        WebDriver driver = new ChromeDriver(capabilities);


        proxy.newHar(); // creating new HAR
        driver.get("https://hyperion-staging-portal.houston1.endurancedevs.com/signup/shared/29/36/SNAPPY");
        List<HarEntry> entries = proxy.getHar().getLog().getEntries();
        for (HarEntry entry : entries) {
//            System.out.println(entry.getRequest().getUrl());
        }
//        proxy.stop();
//        driver.close();
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
        proxy.setTrustAllServers(true);
        proxy.start();

        proxy.addRequestFilter((request, contents, messageInfo) -> {
//            request.headers().add("X-GATOR-REQUESTOR", "jmorah-test");
//            request.headers().add("X-GATOR-AUTH", "87aa0de52ec992880513105308e3c990");

            System.out.println(request.headers().entries().toString());
            return null;
        });

        return proxy;
    }


}