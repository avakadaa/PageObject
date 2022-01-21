package saucedemotests;

import jdk.jfr.Description;
import org.junit.Assert;
import org.junit.Test;
import data.UserData;
import pages.*;

public class BuyProductTests extends webDriverInit {

    @Test
    @Description("E2E test, that checks possibility to login with correct data and make successful purchase.")
    public void buyProduct() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CartPage cart = new CartPage(driver);
        Checkout checkout = new Checkout(driver);
        Overview overview = new Overview(driver);
        Finish finish = new Finish(driver);
        loginPage.login(UserData.userNameLogin, UserData.userPassword);
        homePage.clickAddCartSauceLabsBackpackButton();
        homePage.clickCartButton();
        cart.clickCheckoutButton();
        checkout.fillFields(UserData.firstName, UserData.lastName, UserData.postalCode);
        checkout.clickContinueButton();
        overview.clickFinishButton();
        Assert.assertEquals("THANK YOU FOR YOUR ORDER", finish.getGratitudeNotification());
    }

    @Test
    @Description("Test checks possibility to make purchase from product's page.")
    public void buyProductFromItsPage() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        BackPackPage sauceLabsBackpack = new BackPackPage(driver);
        CartPage cart = new CartPage(driver);
        Checkout checkout = new Checkout(driver);
        Overview overview = new Overview(driver);
        Finish finish = new Finish(driver);
        loginPage.login(UserData.userNameLogin, UserData.userPassword);
        homePage.clickSauceLabsBackpack();
        sauceLabsBackpack.clickAddToCartButton();
        sauceLabsBackpack.clickCartButton();
        cart.clickCheckoutButton();
        checkout.fillFields(UserData.firstName, UserData.lastName, UserData.postalCode);
        checkout.clickContinueButton();
        overview.clickFinishButton();
        Assert.assertEquals("THANK YOU FOR YOUR ORDER", finish.getGratitudeNotification());
    }

    @Test
    @Description("Test confirms impossible to make purchase with empty First Name field in the Checkout page.")
    public void buyProductWithEmptyFirstName() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CartPage cart = new CartPage(driver);
        Checkout checkout = new Checkout(driver);
        loginPage.login(UserData.userNameLogin, UserData.userPassword);
        homePage.clickAddCartSauceLabsBackpackButton();
        homePage.clickCartButton();
        cart.clickCheckoutButton();
        checkout.fillFields(UserData.emptyString, UserData.lastName, UserData.postalCode);
        checkout.clickContinueButton();
        Assert.assertEquals(checkout.getErrorFirstNameNotification(), checkout.errorNotification());
    }

    @Test
    @Description("Test confirms impossible to make purchase with empty \"Last Name\" field in the Checkout page.")
    public void buyProductWithIncorrectLastName() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CartPage cart = new CartPage(driver);
        Checkout checkout = new Checkout(driver);
        loginPage.login(UserData.userNameLogin, UserData.userPassword);
        homePage.clickAddCartSauceLabsBackpackButton();
        homePage.clickCartButton();
        cart.clickCheckoutButton();
        checkout.fillFields(UserData.firstName, UserData.emptyString, UserData.postalCode);
        checkout.clickContinueButton();
        Assert.assertEquals(checkout.getErrorLastNameNotification(), checkout.errorNotification());
    }

    @Test
    @Description("Test confirms impossible to make purchase with empty \"Zip/Postal Code\" field in the Checkout page.")
    public void buyProductWithIncorrectPostalCode() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CartPage cart = new CartPage(driver);
        Checkout checkout = new Checkout(driver);
        loginPage.login(UserData.userNameLogin, UserData.userPassword);
        homePage.clickAddCartSauceLabsBackpackButton();
        homePage.clickCartButton();
        cart.clickCheckoutButton();
        checkout.fillFields(UserData.firstName, UserData.lastName, UserData.emptyString);
        checkout.clickContinueButton();
        Assert.assertEquals(checkout.getErrorPostalCodeNotification(), checkout.errorNotification());
    }

    @Test
    @Description(value = "Test confirms possibility to cancel purchase before customer fills its personal data")
    public void cancelPurchase() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CartPage cart = new CartPage(driver);
        Checkout checkout = new Checkout(driver);
        Overview overview = new Overview(driver);
        loginPage.login(UserData.userNameLogin, UserData.userPassword);
        homePage.clickAddCartSauceLabsBackpackButton();
        homePage.clickCartButton();
        cart.clickCheckoutButton();
        checkout.fillFields(UserData.firstName, UserData.lastName, UserData.postalCode);
        checkout.clickContinueButton();
        overview.clickCancelButton();
        Assert.assertEquals(6, homePage.getitemsSuiteInt());
    }
}