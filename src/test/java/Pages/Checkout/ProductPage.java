package Pages.Checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ProductPage {
    @FindBy (name = "Submit")
    WebElement addToCart;

    WebDriver driver;

    public ProductPage(WebDriver _driver){
        this.driver = _driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,30),this);
    }

    public void addToCart(){
    	addToCart.click(); 	
    	
    }
}
