package hostgator.Pages.Portal.Billing;

import hostgator.util.StaticData;
import org.openqa.selenium.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BillingHistoryPage {
    private WebDriver driver;
    private static Logger log = LogManager.getLogger(MakeAPaymentPage.class.getName());

    public BillingHistoryPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(this.driver, this);
    }
    String regex = "[0-9]+";

    @FindBy(how = How.XPATH, using = "//*[@class='sorting_1']//a[contains(@href, '/billing/invoice/')]")
    private List<WebElement> _invoiceNumbers;

    public void PrintInvoiceNumbers() {
        for(WebElement e : _invoiceNumbers) {
            System.out.println(e.getText());
        }
    }
}
