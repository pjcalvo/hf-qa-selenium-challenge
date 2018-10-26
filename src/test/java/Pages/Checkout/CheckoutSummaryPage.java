package Pages.Checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class CheckoutSummaryPage {
    @FindBy (xpath = "//*[@id='cart_navigation']/button")
    WebElement orderConfirmation;

    WebDriver driver;

    public CheckoutSummaryPage(WebDriver _driver){
        this.driver = _driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,30),this);
    }

    public void placeOrder(){
    	orderConfirmation.click();
    }
}
