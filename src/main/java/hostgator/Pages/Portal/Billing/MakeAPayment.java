package hostgator.Pages.Portal.Billing;

import org.openqa.selenium.By;

public class MakeAPayment {

    //<editor-fold desc="Invoice Selection Page">

    By prePayCheckBox = By.className("check-package");
    By buttonBuy = By.className("button-buy");

    //</editor-fold>

    //<editor-fold desc="Payment Type Selection Page">

    By newCard = By.linkText("Use New Credit Card");
    By cardNumberField = By.name("cardnumber");
    By securityCodeField = By.name("security_code");
    By tosCheckBox = By.className("iCheck-helper");
    By checkoutButton = By.id("not-paypall");


    //</editor-fold>


}
