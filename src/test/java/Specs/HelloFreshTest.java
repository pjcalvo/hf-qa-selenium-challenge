package Specs;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import Helpers.DataHelper;

import Model.User;
import Model.PaymentType;


import static org.testng.Assert.*;

public class HelloFreshTest extends SpecsBaseClass {
    
	WebDriverWait wait;   

    @Test(enabled = true)
    public void signInTest() {
    	  	
    	User testUser = DataHelper.getRandomUser();
    	
        Header.get().clickSignUp();
        AuthenticationPage.get().createAnAccount(testUser);
        CreateAccountPage.get().enterUserInformation(testUser);
    
        assertTrue(AccountPage.get().isUserOnAccountPageAndLoggedIn(testUser));
    }

    @Test (dataProvider = "AuthenticationUsers", dataProviderClass = DataHelper.class, enabled=true)
    public void logInTest(String sEmail, String sPassword, String sFirstName, String sLastName) {
    	
    	User testUser = new User(sEmail, sPassword, sFirstName, sLastName);
        Header.get().clickSignUp();
        AuthenticationPage.get().authenticateUser(testUser);
        
        assertTrue(AccountPage.get().isUserOnAccountPageAndLoggedIn(testUser));
        
    }

    @Test(enabled = true)
    public void checkoutTest() {
    	
    	//set test data
    	User testUser = DataHelper.getExistingUser();
    	
    	//login the user
        Header.get().clickSignUp();
        AuthenticationPage.get().authenticateUser(testUser);
        
        //choose product
        Menu.get().selectWomen();
        ProductListPage.get().selectFadedShortSleeve();
        ProductPage.get().addToCart();
        
        //checkoutProcess
        CartModal.get().proceedToCheckout();
        CartSummaryPage.get().confirmOrder();
        CheckoutAddressPage.get().continueWithAddress();
        CheckoutShippingPage.get().agreeOnTermsAndConditions();
        CheckoutShippingPage.get().proceedToCheckout();
        CheckoutPaymentPage.get().chooseToPayUsingBankWire(PaymentType.BankWire);
        CheckoutSummaryPage.get().placeOrder();
        
        //assertions
        assertTrue(CheckoutConfirmationPage.get().wasOrderPlaced());
        assertTrue(CheckoutConfirmationPage.get().isOnConfirmationPage());
    }
}
