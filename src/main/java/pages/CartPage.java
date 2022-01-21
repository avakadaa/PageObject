package pages;

import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {

    public WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    private By checkoutButton = By.id("checkout");
    private By removeButton = By.xpath("//button[@id='remove-sauce-labs-backpack']");
    private By removeButtons = By.xpath("//button[@class='btn_secondary cart_button']");
    private By listOfItems = By.xpath("//div[@class='cart_item']");
    private By continueShoppingButton = By.xpath("//button[@class='btn btn_secondary back btn_medium']");

    @Description("Delete one product item from the cart by clicking \"REMOVE\" button")
    public void removeOneItemFromCart() {
        driver.findElement(removeButton).click();
    }

    @Description("Delete all items from the cart by clicking button \"REMOVE\" near every product item")
    public void removeAllItemsFromCart() {
        List<WebElement> removeButtonsList = driver.findElements(removeButtons);
        for (int i = 0; i < removeButtonsList.size(); i++) {
            removeButtonsList.get(i).click();
        }
    }

    public int listOfItems() {
        List<WebElement> items = driver.findElements(listOfItems);
        return items.size();
    }

    @Description("Click \"CHECKOUT\" button on the Cart page")
    public void clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
    }

    @Description("Click \"CONTINUE SHOPPING\" button on the Cart page")
    public void clickContinueShoppingButton() {
        driver.findElement(continueShoppingButton).click();
    }
}