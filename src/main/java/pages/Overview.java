package pages;

import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Overview {

    public WebDriver driver;

    public Overview(WebDriver driver) {
        this.driver = driver;
    }

    private By finishButton = By.xpath("//button[@class='btn btn_action btn_medium cart_button']");
    private By cancelButton = By.xpath("//button[@class='btn btn_secondary back btn_medium cart_cancel_link']");

    @Description("Click \"FINISH\" button on the Overview page")
    public void clickFinishButton() {
        driver.findElement(finishButton).click();
    }

    public void clickCancelButton() {
        driver.findElement(cancelButton).click();
    }
}