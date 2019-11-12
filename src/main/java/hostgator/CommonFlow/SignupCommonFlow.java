package hostgator.CommonFlow;

import java.util.Random;

import hostgator.Pages.Signup.Signuppage;

import hostgator.util.StaticData;
import org.openqa.selenium.WebDriver;

public class SignupCommonFlow extends Signuppage{

	Random random    = new Random();
	Signuppage signup= new Signuppage(driver);

    public SignupCommonFlow(WebDriver driver) {
        super(driver);
    }

    public void enterEmailAndConfirm(String packageName) {
        String email = "hgtest"+random.nextInt(100000)+packageName +random.nextInt(100000)+ "@endurance.com";
        signup.enterEmail(email);
        signup.enterConfirmEmail(email);
    }

    public void checkTOSandCheckout() throws InterruptedException {
        signup.waitForSummaryTable();
        signup.checkTos1();
        signup.clickCheckout();
    }

    public void enterCredirCardInfo() {
        signup.enterCreditCardName(StaticData.testCreditCardName);
        signup.enterCreditCardNumber(StaticData.testCreditCardNumber);
        signup.enterCreditCardCVV(StaticData.testCreditCardCVV);
    }

    public void enterBillingInfo() {
        signup.enterFirstName(StaticData.firstName);
        signup.enterLastName(StaticData.lastName);
        signup.enterPhone(StaticData.phone);
        signup.enterAddress1(StaticData.address1);
        signup.enterAddress2(StaticData.address2);
        signup.enterCity(StaticData.city);
        signup.enterZipCode(StaticData.zip);
    }

    public void sharedPackageCheckTOSandCheckoutTwice() {
        signup.waitForSummaryTable();
        signup.checkTos1();
        signup.clickCheckout();
        signup.clickCheckout(); //Clicking checkout again cause first click loads up and does nothing
    }
}
