package hostgator.Pages.Portal;

import hostgator.driver.TestDriver;
import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends TestDriver {

    private static Logger log = LogManager.getLogger(HomePage.class.getName());

    public HomePage(WebDriver driver)
    {
        this.driver=driver;
    }

    By billingNav    = By.xpath("//*[@id=\"billing-nav-link\"]/a/span[2]"); //By.id("billing-nav-link");
    By makePayment   = By.linkText("Make a Payment");
    By nextButton    = By.id("loginBtn");
    By passwordField = By.id("password");
    By loginButton   = By.id("loginBtn");
    By hosting       = By.xpath("//*[@id=\"gbclient\"]/div[1]/ul/li[2]/a");

    public void clickBillingNav()
    {
        driver.findElement(billingNav).click();
        log.info("Clicked Billing Nav");
    }

    public void clickMakePayment()
    {
        driver.findElement(makePayment).click();
        log.info("Clicked Make a Payment");
    }

    public void clickHosting()
    {
        WebElement element = driver.findElement(hosting);

        JavascriptExecutor executor = (JavascriptExecutor)driver;

        executor.executeScript("arguments[0].click();", element);
        log.info("Clicked Hosting Nav");
    }

}