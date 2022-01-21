package pages;

import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Finish {

    public WebDriver driver;

    public Finish(WebDriver driver) {
        this.driver = driver;
    }

    private By gratitudeNotification = By.xpath("//h2[text()='THANK YOU FOR YOUR ORDER']");

    @Description("Return notification with gratitude")
    public String getGratitudeNotification() {
        return driver.findElement(gratitudeNotification).getText();
    }
}