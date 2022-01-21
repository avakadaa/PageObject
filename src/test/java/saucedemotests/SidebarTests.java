package saucedemotests;

import jdk.jfr.Description;
import org.junit.Assert;
import org.junit.Test;
import data.UserData;
import pages.HomePage;
import pages.LoginPage;
import pages.webDriverInit;

public class SidebarTests extends webDriverInit {

    @Test
    @Description("Check correct working \"All Items\" button inside Sidebar.")
    public void allItemsLink() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login(UserData.userNameLogin, UserData.userPassword);
        homePage.clickSideBarButton();
        homePage.clickAllItemsButton();
        Assert.assertEquals(6, homePage.getitemsSuiteInt());
    }

    @Test
    @Description("Check correct working \"About\" button inside Sidebar.")
    public void aboutLink() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login(UserData.userNameLogin, UserData.userPassword);
        homePage.clickSideBarButton();
        homePage.clickAboutButton();
        Assert.assertEquals("https://saucelabs.com/", homePage.getCurrentURL());
    }

    @Test
    @Description("Check correct working \"Logout\" button inside Sidebar.")
    public void logoutLink() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login(UserData.userNameLogin, UserData.userPassword);
        homePage.clickSideBarButton();
        homePage.clickLogoutButton();
        Assert.assertTrue(loginPage.loginButtonIsDisplayed());
    }
}