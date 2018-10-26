package Specs;

import Helpers.DataHelper;
import Helpers.DriverHelper;
import Pages.*;
import Pages.Checkout.*;
import org.openqa.selenium.WebDriver;

public class SuperBaseClass {
    //driver
    protected ThreadLocal<WebDriver> _driver = new ThreadLocal<>();
    
    //pages
    protected ThreadLocal <AuthenticationPage> AuthenticationPage = new ThreadLocal<>();
    protected ThreadLocal <Header> Header = new ThreadLocal<>();
    protected ThreadLocal <CreateAccountPage> CreateAccountPage = new ThreadLocal<>();;
    protected ThreadLocal <AccountPage>  AccountPage = new ThreadLocal<>();
    protected ThreadLocal <Menu>  Menu = new ThreadLocal<>();
    protected ThreadLocal <ProductListPage>  ProductListPage = new ThreadLocal<>();
    protected ThreadLocal <ProductPage>  ProductPage = new ThreadLocal<>();
    protected ThreadLocal <CartModal>  CartModal = new ThreadLocal<>();
    protected ThreadLocal <CartSummaryPage>  CartSummaryPage = new ThreadLocal<>();
    protected ThreadLocal <CheckoutAddressPage>  CheckoutAddressPage = new ThreadLocal<>();
    protected ThreadLocal <CheckoutShippingPage>  CheckoutShippingPage = new ThreadLocal<>();
    protected ThreadLocal <CheckoutSummaryPage>  CheckoutSummaryPage = new ThreadLocal<>();
    protected ThreadLocal <CheckoutPaymentPage>  CheckoutPaymentPage = new ThreadLocal<>();
    protected ThreadLocal <CheckoutConfirmationPage>  CheckoutConfirmationPage = new ThreadLocal<>();

    //helpers
    protected DataHelper DataHelper;
    protected DriverHelper DriverHelper;
    
    protected WebDriver driver() {
    	return this._driver.get();
    }
    
    protected void setDriver(WebDriver driver) {
    	this._driver.set(driver);
    }
    
    protected void InitPages(){
        AuthenticationPage.set(new AuthenticationPage(driver(), DataHelper));
        Header.set(new Header(driver()));
        CreateAccountPage.set(new CreateAccountPage(this.driver(), DataHelper));
        AccountPage.set(new AccountPage(this.driver()));
        Menu.set(new Menu(this.driver()));
        ProductListPage.set(new ProductListPage(this.driver()));
        ProductPage.set(new ProductPage(this.driver()));
        CartModal.set(new CartModal(this.driver()));
        CartSummaryPage.set(new CartSummaryPage(this.driver()));
        CheckoutAddressPage.set(new CheckoutAddressPage(this.driver()));
        CheckoutShippingPage.set(new CheckoutShippingPage(this.driver()));
        CheckoutSummaryPage.set(new CheckoutSummaryPage(this.driver()));
        CheckoutPaymentPage.set(new CheckoutPaymentPage(this.driver()));
        CheckoutConfirmationPage.set(new CheckoutConfirmationPage(this.driver()));
    }

    protected void InitHelpers(String baseUrl){
        DataHelper = new DataHelper();
        DriverHelper = (new DriverHelper(driver(), baseUrl));
    }
}
