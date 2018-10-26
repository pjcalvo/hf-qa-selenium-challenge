package Pages.Checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartModal {
    @FindBy (xpath = "//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']")
    WebElement proceedToCheckout;

    WebDriver driver;

    public CartModal(WebDriver _driver){
        this.driver = _driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,30),this);
    }

    public void proceedToCheckout(){
    	
    	new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(proceedToCheckout)).click();
    }
}
