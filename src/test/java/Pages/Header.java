package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Header {
    @FindBy (how = How.CLASS_NAME, using = "login")
    WebElement signUpLink;

    @FindBy (xpath = "//span[@data-selenium-id='lblIsSignedIn']")
    WebElement signedInLabel;

    WebDriver driver;
    WebDriverWait wait;

    public Header(WebDriver _driver){
        this.driver = _driver;
        this.wait = new WebDriverWait(_driver,30);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,30),this);
    }

    public void clickSignUp(){
        signUpLink.click();
    }

    public boolean isUserSignedIn(){
       return signedInLabel.isDisplayed();
    }
}
