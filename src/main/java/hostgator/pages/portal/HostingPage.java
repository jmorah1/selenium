package hostgator.pages.portal;

import hostgator.driver.TestDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HostingPage extends TestDriver {
    private static Logger log = LogManager.getLogger(HomePage.class.getName());

    public HostingPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(this.driver, this);

    }

    By billingNav    = By.linkText("Add a Package");
    By shared = By.cssSelector("div[data-value='/signup/shared/3/36/SHARED3660']");
    @FindBy(how = How.XPATH, using = "//*[@id=\"DataTables_Table_0\"]/tbody/tr/td[2]")
    private List<WebElement> _packageIDs;

    public void addPackage()
    {
        WebElement element = driver.findElement(billingNav);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
        log.info("Clicked Add a Package");
    }

    public void shared()
    {
        WebElement element = driver.findElement(shared);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
        log.info("Clicked shared");
    }

    public void printPackages() {
        for(WebElement e : _packageIDs) {
            System.out.println(e.getText());
        }
    }

}
