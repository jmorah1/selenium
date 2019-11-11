//package hostgator.CommonFlow;
//
//import hostgator.Pages.Domain.CartCheckout;
//
//import hostgator.driver.TestDriver;
//import hostgator.util.StaticData;
//
//public class zzCartCheckoutCommonFlow extends TestDriver{
//
//	CartCheckout cartCheckout=new CartCheckout(driver);
//
//	public void enterPasswordAndConfirm(String password)
//	{
//		cartCheckout.enterPassword(password);
//		cartCheckout.enterConfirmPassword(password);
//	}
//
//	public void enterBillingInfo()
//	{
//		cartCheckout.enterFirstName(StaticData.firstName);
//		cartCheckout.enterlastName(StaticData.lastName);
//		cartCheckout.enterHomePhone(StaticData.phone);
//		cartCheckout.enterAddress(StaticData.address1);
//		cartCheckout.enterCity(StaticData.city);
//		cartCheckout.enterZipCode(StaticData.zip);
//	}
//
//	public void enterCCInfo()
//	{
//		cartCheckout.enterCCName(StaticData.testCreditCardName);
//		cartCheckout.enterCCNumber(StaticData.testCreditCardNumber);
//		cartCheckout.enterCVV(StaticData.testCreditCardCVV);
//	}
//}
