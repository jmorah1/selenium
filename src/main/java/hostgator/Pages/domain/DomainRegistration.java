package hostgator.Pages.domain;

import hostgator.driver.TestDriver;
import hostgator.util.StaticData;
import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class DomainRegistration extends TestDriver {

    private static Logger log = LogManager.getLogger(DomainRegistration.class.getName());
    Random random = new Random();

    public DomainRegistration(WebDriver driver)
    {
        this.driver=driver;
    }

    private By Domainfield   = By.name("search_contents");
    private By searchDomainButton = By.xpath("//*[@id=\"spa_content\"]/div/div[1]/div/section/div/div[1]/button");
    private By continueCheckoutButton = By.xpath("//*[@id=\"cart_brick\"]/div/div[2]/form/button");


    public void enterDomain()
    {
        driver.findElement(Domainfield).sendKeys("hgtest"+random.nextInt(10000)+"domain"+random.nextInt(10000)+".com");
        log.info("Entered Domain");
    }

    public void clickDomainSearchButton()
    {
        driver.findElement(searchDomainButton).click();
        log.info("Clicked Search Domain");

    }

    public void clickContinueCheckoutButton(){
//        driver.findElement(continueCheckoutButton).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(continueCheckoutButton)).click();
        log.info("Clicked Continue Checkout");
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