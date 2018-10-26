package Pages.Checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import Model.PaymentType;

public class CheckoutPaymentPage {
    @FindBy (css = ".bankwire")
    WebElement bankWire;
    
    @FindBy (css = ".cheque")
    WebElement cheque;
    
    @FindBy (name = "processCarrier")
    WebElement proceedToCheckout;

    WebDriver driver;

    public CheckoutPaymentPage(WebDriver _driver){
        this.driver = _driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,30),this);
    }

    public void chooseToPayUsingBankWire(PaymentType payment){
    	switch (payment) {
    	case BankWire:
    		bankWire.click();
    		break;	
    	
    	case Check:
    		cheque.click();
    		break;
    	
    	default:
    		break;
    	}
    	
    }
    
}
