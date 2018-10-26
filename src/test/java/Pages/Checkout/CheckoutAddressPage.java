package Pages.Checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class CheckoutAddressPage {
    @FindBy (name = "processAddress")
    WebElement proceedToCheckout;

    WebDriver driver;

    public CheckoutAddressPage(WebDriver _driver){
        this.driver = _driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,30),this);
    }

    public void continueWithAddress(){
    	proceedToCheckout.click();
    }
}
