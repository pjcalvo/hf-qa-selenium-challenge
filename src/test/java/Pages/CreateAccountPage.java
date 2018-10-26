package Pages;

import Helpers.DataHelper;
import Model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage{

    @FindBy(id = "id_gender1")
    WebElement mrInput;
    
    @FindBy(id = "customer_firstname")
    WebElement firstName;
    
    @FindBy(id = "customer_lastname")
    WebElement lastName;
    
    @FindBy(id = "passwd")
    WebElement password;
    
    @FindBy(id = "days")
    WebElement day;
    
    @FindBy(id = "months")
    WebElement month;
    
    @FindBy(id = "years")
    WebElement year;
   
    @FindBy(id = "company")
    WebElement company;
    
    @FindBy(id = "address1")
    WebElement address1;
    
    @FindBy(id = "address2")
    WebElement address2;
    
    @FindBy(id = "city")
    WebElement city;
    
    @FindBy(id = "id_state")
    WebElement state;
    
    @FindBy(id = "postcode")
    WebElement postcode;
    
    @FindBy(id = "other")
    WebElement other;
    
    @FindBy(id = "phone")
    WebElement phone;
    
    @FindBy(id = "phone_mobile")
    WebElement phonemobile;
    
    @FindBy(id = "alias")
    WebElement alias;
    
    @FindBy(id = "submitAccount")
    WebElement submitAccount;
    

    WebDriver driver;
    DataHelper dataHelper;

    public CreateAccountPage(WebDriver _driver, DataHelper dataHelper){
        this.driver =_driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,50),this);
        this.dataHelper = dataHelper;
    }

    public void enterUserInformation(User _testUser) {
    	
    	Select selectDay = new Select(day);
    	Select selectMonth = new Select(month);
    	Select selectYear = new Select(year);
    	Select selectState = new Select(state);
    	
    	mrInput.click();
    	firstName.sendKeys(_testUser.name);
    	lastName.sendKeys(_testUser.surname);
    	password.sendKeys(_testUser.password);
    	
    	selectDay.selectByValue(String.valueOf(_testUser.birhtDate.getDay()));
    	selectMonth.selectByValue(String.valueOf(_testUser.birhtDate.getMonth()));
    	selectYear.selectByValue(String.valueOf(_testUser.birhtDate.getYear()));
    	
    	company.sendKeys(_testUser.address.company);
    	address1.sendKeys(_testUser.address.address1);
    	address2.sendKeys(_testUser.address.address2);
    	city.sendKeys(_testUser.address.city);
    	
    	selectState.selectByVisibleText(_testUser.address.state);
    	
    	postcode.sendKeys(_testUser.address.postCode);
    	other.sendKeys(_testUser.address.other);
    	phone.sendKeys(_testUser.address.phone);
    	phonemobile.sendKeys(_testUser.address.phoneMobile);
    	alias.sendKeys(_testUser.address.alias);
 	
    	submitAccount.click();  	
    	
    }
    

}
