package hostgator.pages.portal;

import hostgator.driver.TestDriver;
import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends TestDriver {

    private static Logger log = LogManager.getLogger(LoginPage.class.getName());

    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
    }


    By emailField    = By.id("email");
    By nextButton    = By.id("loginBtn");
    By passwordField = By.id("password");
    By loginButton   = By.id("loginBtn");

    public void enterExistingAccountEmail(String email)
    {
        driver.findElement(emailField).sendKeys(email);
        log.info("Entered Existing Email");
    }

    public void clickNextButton()
    {
        driver.findElement(nextButton).click();
        log.info("Clicked Next");
    }

    public void enterExistingAccountPassword(String password)
    {
        driver.findElement(passwordField).sendKeys(password);
        log.info("Entered Password");
    }

    public void clickLoginButton()
    {
        driver.findElement(loginButton).click();
        log.info("Clicked Login");
    }

    public void portalLogin(String email, String password)
    {
        enterExistingAccountEmail(email);
        clickNextButton();
        enterExistingAccountPassword(password);
        clickLoginButton();

        @SuppressWarnings("deprecation")
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("home-container")));
    }

}