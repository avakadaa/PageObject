package pages;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class webDriverInit {

    public String baseUrl = "https://www.saucedemo.com";
    String driverPath = "src/main/resources/chromedriver";
    public WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @After
    public void close() {
        driver.quit();
    }
}