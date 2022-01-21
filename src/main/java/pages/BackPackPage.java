package pages;

import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BackPackPage {

    public WebDriver driver;

    public BackPackPage(WebDriver driver) {
        this.driver = driver;
    }

    private By addToCartButton = By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']");
    private By cartButton = By.xpath("//div[@id='shopping_cart_container']/a");

    @Description("Click \"ADD TO CART\" button on the Sauce Labs Backpack page")
    public void clickAddToCartButton() {
        driver.findElement(addToCartButton).click();
    }

    @Description("Click Cart icon on the Sauce Labs Backpack page")
    public void clickCartButton() {
        driver.findElement(cartButton).click();
    }
}