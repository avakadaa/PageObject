package pages;

import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends webDriverInit {

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private String title = "Swag Labs";
    private String errorNotificationUsername = "Epic sadface: Username is required";
    private String errorNotificationPassword = "Epic sadface: Password is required";
    private String strUsernameAndPassDoNotMatch = "Epic sadface: Username and password do not match any user in this service";

    private By fieldUsername = By.id("user-name");
    private By fieldPassword = By.id("password");
    private By loginButton = By.id("login-button");
    private By userNameIsRequired = By.xpath("//h3[text()='Epic sadface: Username is required']");
    private By passIsRequired = By.xpath("//h3[text()='Epic sadface: Password is required']");
    private By errorNotificationUsernameAndPassword = By.xpath("//h3[@data-test='error']");

    @Description("Fill \"Username\" field with data ({login}), fill \"Password\" field with data ({password}) and click \"LOGIN\" button")
    public void login(String login, String password) {
        driver.findElement(fieldUsername).sendKeys(login);
        driver.findElement(fieldPassword).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public String getErrorNotificationUsername() {
        return errorNotificationUsername;
    }

    public String getErrorNotificationPassword() {
        return errorNotificationPassword;
    }

    public String notificationUsername() {
        WebElement strUserNameIsRequired = driver.findElement(userNameIsRequired);
        return strUserNameIsRequired.getText();
    }

    public String notificationUsernameAndPassword() {
        WebElement strNotificationUsernameAndPassword = driver.findElement(errorNotificationUsernameAndPassword);
        return strNotificationUsernameAndPassword.getText();
    }

    public String notificationPassword() {
        WebElement strNotificationPassword = driver.findElement(passIsRequired);
        return strNotificationPassword.getText();
    }

    public String getStrUsernameAndPassDoNotMatch() {
        return strUsernameAndPassDoNotMatch;
    }

    public Boolean loginButtonIsDisplayed() {
        return driver.findElement(loginButton).isDisplayed();
    }
}