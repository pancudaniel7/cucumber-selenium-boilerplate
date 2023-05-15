package utils;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class DriverManager {

    private WebDriver driver;

    public static WebDriver driver() {
        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");

        DriverManager driverManager = new DriverManager();
        driverManager.driver = new ChromeDriver();
        driverManager.driver.manage().window().maximize();
        return driverManager.driver;
    }

    public void waitForElement(WebElement element) {
        //Generic wait script which can be used for all elements.
        //If you want to wait for more than 10 seconds, you can use the function beneath this one.
        waitForElement(element, 10);
    }

    public void waitForElement(WebElement element, long seconds) {
        //Overloading of method waitForElement, when you know an element takes more then 10 seconds to load.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (NoSuchElementException | TimeoutException | StaleElementReferenceException e) {
            //exception handling: generate clean error message
            Assert.fail("Element not found on page: " + element);
        }
    }

    public void waitForElements(List<WebElement> elementList) {
        //Generic wait script which can be used for all list elements.
        //Waits for max 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
        } catch (NoSuchElementException | TimeoutException | StaleElementReferenceException e) {
            Assert.fail("Element not found on page: " + elementList);
        }
    }
}
