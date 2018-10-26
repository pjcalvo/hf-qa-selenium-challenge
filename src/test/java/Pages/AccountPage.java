package Pages;

import Model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class AccountPage{

    @FindBy(css = "h1")
    WebElement heading;
    
    @FindBy(css = ".account")
    WebElement account;
    
    @FindBy(css = ".info-account")
    WebElement infoaccount;
    
    @FindBy(css = ".logout")
    WebElement logout;

    WebDriver driver;

    public AccountPage(WebDriver _driver){
        this.driver =_driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,50),this);
    }

    public Boolean isUserOnAccountPageAndLoggedIn(User _testUser) {
    	
    	return (heading.getText().contains("MY ACCOUNT") && 
    			account.getText().contains(_testUser.name + " " +_testUser.surname) && 
    			infoaccount.getText().contains("Welcome to your account.") && 
    			logout.isDisplayed() &&
    			driver.getCurrentUrl().contains("controller=my-account"));
    			   	
    }
    

}
