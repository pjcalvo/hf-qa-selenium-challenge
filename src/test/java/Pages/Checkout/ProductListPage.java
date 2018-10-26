package Pages.Checkout;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ProductListPage {
    @FindBy (xpath = "//a[@title='Faded Short Sleeve T-shirts']/ancestor::li")
    WebElement selectedProduct;

    WebDriver driver;

    public ProductListPage(WebDriver _driver){
        this.driver = _driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,30),this);
    }

    public void selectFadedShortSleeve(){
   	
    	JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",selectedProduct);
    	
        
        Actions actions = new Actions(driver);
        actions.moveToElement(selectedProduct).perform();
    	selectedProduct.click();
    	
    	//selectedProduct.click();
    }
}
