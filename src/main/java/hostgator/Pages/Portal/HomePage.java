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

    private void noInterceptClick(WebElement elementToClick){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", elementToClick);
    }

    By billingNav    = By.linkText("Billing");
    By makePayment   = By.linkText("Make a Payment");
    By nextButton    = By.id("loginBtn");
    By passwordField = By.id("password");
    By loginButton   = By.id("loginBtn");
    By hosting       = By.xpath("//*[@id=\"gbclient\"]/div[1]/ul/li[2]/a");
    By billingHistory = By.linkText("Billing History");

    private void clickBillingNav()
    {
        driver.findElement(billingNav).click();
        log.info("Clicked Billing Nav");
    }

    private void clickMakePayment()
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
    private void clickBillingHistory() {
        driver.findElement(billingHistory).click();
        log.info("Clicked Billing History");

    }
    public void navigateToBillingHistory() {
        clickBillingNav();
        clickBillingHistory();
    }

    public void navigateToMakePayment() {
        clickBillingNav();
        clickBillingHistory();
    }
}