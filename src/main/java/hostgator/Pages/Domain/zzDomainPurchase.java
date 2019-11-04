package hostgator.Pages.Domain;

import hostgator.util.StaticData;
import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class DomainPurchase {

    private static Logger log = LogManager.getLogger(DomainPurchase.class.getName());
    Random random = new Random();


    private WebDriver driver;
    public DomainPurchase(WebDriver driver)
    {
        this.driver=driver;
    }


    private By Domainfield   = By.name("search_contents");
    private By searchDomainButton = By.xpath("//*[@id=\"spa_content\"]/div/div[1]/div/section/div/div[1]/button");
    private By continueCheckoutButton = By.xpath("//*[@id=\"cart_brick\"]/div/div[2]/form/button");


    public void enterDomain(String domain)
    {
        driver.findElement(Domainfield).sendKeys(domain+random.nextInt(10000)+"domain"+random.nextInt(10000)+".com");
        log.info("Entered Domain");
    }

    public void clickDomainSearchButton()
    {
        driver.findElement(searchDomainButton).click();
        log.info("Clicked Search Domain");

    }

    public void clickContinueCheckoutButton(){
//        driver.findElement(continueCheckoutButton).click();
//        log.info("Clicked Continue Checkout");
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(continueCheckoutButton)).click();
    }

    public void enterDomainAndSearch(){
        String searchDomain = StaticData.domainName+random.nextInt(10000)+"domain"+random.nextInt(10000)+".com";

        driver.findElement(Domainfield).sendKeys(searchDomain);
        log.info("Entered Domain");

        clickDomainSearchButton();

        @SuppressWarnings("deprecation")
        WebDriverWait w = new WebDriverWait(driver, 10);
        w.until(ExpectedConditions.urlContains(searchDomain));
    }

}
