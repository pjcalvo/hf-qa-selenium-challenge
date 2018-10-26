package Pages.Checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class CheckoutShippingPage {
    @FindBy (id = "uniform-cgv")
    WebElement termsAndConditions;
    
    @FindBy (name = "processCarrier")
    WebElement proceedToCheckout;

    WebDriver driver;

    public CheckoutShippingPage(WebDriver _driver){
        this.driver = _driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,30),this);
    }

    public void agreeOnTermsAndConditions(){
    	termsAndConditions.click();
    }
    
    public void proceedToCheckout(){
    	proceedToCheckout.click();
    }
}
