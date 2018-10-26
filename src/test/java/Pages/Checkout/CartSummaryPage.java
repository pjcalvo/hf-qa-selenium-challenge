package Pages.Checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class CartSummaryPage {
    @FindBy (xpath = "//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']")
    WebElement proceedToCheckout;

    WebDriver driver;

    public CartSummaryPage(WebDriver _driver){
        this.driver = _driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,30),this);
    }

    public void confirmOrder(){
    	proceedToCheckout.click();
    }
}
