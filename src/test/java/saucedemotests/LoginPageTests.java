package saucedemotests;

import jdk.jfr.Description;
import org.junit.Assert;
import org.junit.Test;
import data.UserData;
import pages.HomePage;
import pages.LoginPage;
import pages.webDriverInit;

public class LoginPageTests extends webDriverInit {

    @Test
    @Description("Login with correct Username and Password")
    public void CorrectLogin() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login(UserData.userNameLogin, UserData.userPassword);
        Assert.assertTrue(homePage.getVisibleCartButton().isDisplayed());
    }

    @Test
    @Description("Login with empty Username field and see notification about requirement of Username data")
    public void LoginWithEmptyUsername() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(UserData.emptyString, UserData.userNameLogin);
        Assert.assertEquals(loginPage.getErrorNotificationUsername(), loginPage.notificationUsername());
    }

    @Test
    @Description("Login with empty Password and see notification about requirement of Password data")
    public void LoginWithEmptyPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(UserData.userNameLogin, UserData.emptyString);
        Assert.assertEquals(loginPage.getErrorNotificationPassword(), loginPage.notificationPassword());
    }

    @Test
    @Description("Login with empty Username and Password end see error notification")
    public void loginWithEmptyUsernameAndPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(UserData.emptyString, UserData.emptyString);
        Assert.assertEquals(loginPage.getErrorNotificationUsername(), loginPage.notificationUsername());
    }

    @Test
    @Description("Login with incorrect Username and see error notification about incorrect match of any user in this service")
    public void incorrectLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(UserData.incorrectUsername, UserData.userPassword);
        Assert.assertEquals(loginPage.getStrUsernameAndPassDoNotMatch(), loginPage.notificationUsernameAndPassword());
    }

    @Test
    @Description("Login with incorrect Password and see error notification about incorrect match of any user in this service")
    public void incorrectPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(UserData.userNameLogin, UserData.incorrectPassword);
        Assert.assertEquals(loginPage.getStrUsernameAndPassDoNotMatch(), loginPage.notificationUsernameAndPassword());
    }

    @Test
    @Description("Login with incorrect Username and Password and see error notification about incorrect match of any user in this service")
    public void incorrectLoginAndPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(UserData.incorrectUsername, UserData.incorrectPassword);
        Assert.assertEquals(loginPage.getStrUsernameAndPassDoNotMatch(), loginPage.notificationUsernameAndPassword());
    }
}