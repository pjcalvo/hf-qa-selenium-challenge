package Pages.Checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class CheckoutConfirmationPage {
    @FindBy (css = "h1")
    WebElement heading;
    
    @FindBy (xpath = "//li[@class='step_done step_done_last four']")
    WebElement stepFour;
    
    @FindBy (xpath = "//li[@id='step_end' and @class='step_current last']")
    WebElement lastStep;
    
    @FindBy (xpath = "//*[@class='cheque-indent']/strong")
    WebElement confirmationMessage;
    

    WebDriver driver;

    public CheckoutConfirmationPage(WebDriver _driver){
        this.driver = _driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,30),this);
    }

    public Boolean wasOrderPlaced(){
    	return (heading.getText().contains("ORDER CONFIRMATION") &&
    			confirmationMessage.getText().contains("Your order on My Store is complete."));
    }
    
    public Boolean isOnConfirmationPage(){
    	return (stepFour.isDisplayed() &&
    			lastStep.isDisplayed() &&
    			driver.getCurrentUrl().contains("controller=order-confirmation"));
    }
    
    
}
