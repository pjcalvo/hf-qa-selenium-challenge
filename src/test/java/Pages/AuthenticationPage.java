package Pages;

import Helpers.DataHelper;
import Model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthenticationPage{

    @FindBy(id = "email_create")
    WebElement emailInput;
    
    @FindBy(id = "email")
    WebElement email;
    
    @FindBy(id = "passwd")
    WebElement password;
    
    @FindBy(id = "SubmitLogin")
    WebElement submitLogin;
    
    @FindBy(id = "SubmitCreate")
    WebElement submitCreate;

    DataHelper dataHelper;
    WebDriver driver;

    public AuthenticationPage(WebDriver _driver, DataHelper dataHelper){
        this.driver =_driver;
        PageFactory.initElements(this.driver,this);
        this.dataHelper = dataHelper;
    }

    public User createAnAccount(User _testUser) {
    	if (_testUser == null) _testUser= dataHelper.getRandomUser();
    	
    	emailInput.sendKeys(_testUser.email);
    	submitCreate.click();
    	
    	return _testUser;
    	
    }
   
    public User createAnAccount() {
    	return createAnAccount(null);
    }
    
    public void authenticateUser(User _testUser) {
    	
    	email.sendKeys(_testUser.email);
    	password.sendKeys(_testUser.password);
    	submitLogin.click();
    		
    }

}
