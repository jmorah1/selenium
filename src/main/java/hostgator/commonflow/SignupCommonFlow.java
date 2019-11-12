package hostgator.commonflow;

import java.util.Random;

import hostgator.pages.signup.SignupPage;

import hostgator.util.StaticData;
import org.openqa.selenium.WebDriver;

public class SignupCommonFlow extends SignupPage {

	Random random    = new Random();
	SignupPage signup= new SignupPage(driver);

    public SignupCommonFlow(WebDriver driver) {
        super(driver);
    }

    public void enterEmailAndConfirm(String packageName) {
        String email = "hgtest"+random.nextInt(100000)+packageName +random.nextInt(100000)+ "@endurance.com";
        signup.EnterEmail(email);
        signup.EnterConfirmEmail(email);
    }

    public void checkTOSandCheckout() throws InterruptedException {
        signup.WaitForSummaryTable();
        signup.CheckTos1();
        signup.ClickCheckout();
    }

    public void enterCredirCardInfo() {
        signup.EnterCreditCardName(StaticData.TEST_CREDIT_CARD_NAME);
        signup.EnterCreditCardNumber(StaticData.TEST_CREDIT_CARD_NUMBER);
        signup.EnterCreditCardCVV(StaticData.TEST_CREDIT_CARD_CVV);
    }

    public void enterBillingInfo() {
        signup.EnterFirstName(StaticData.FIRST_NAME);
        signup.EnterLastName(StaticData.LAST_NAME);
        signup.EnterPhone(StaticData.PHONE);
        signup.EnterAddress1(StaticData.ADDRESS1);
        signup.EnterAddress2(StaticData.ADDRESS2);
        signup.EnterCity(StaticData.CITY);
        signup.EnterZipCode(StaticData.ZIP);
    }

    public void sharedPackageCheckTOSandCheckoutTwice() {
        signup.WaitForSummaryTable();
        signup.CheckTos1();
        signup.ClickCheckout();
        signup.ClickCheckout(); //Clicking checkout again cause first click loads up and does nothing
    }
}
