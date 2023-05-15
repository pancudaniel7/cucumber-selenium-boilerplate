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

    private static final WebDriver driver;

    static {
        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static WebDriver driver() {
        return driver;
    }

    public static void waitForElement(WebDriver driver, WebElement element) {
        //Generic wait script which can be used for all elements.
        //If you want to wait for more than 10 seconds, you can use the function beneath this one.
        waitForElement(driver, element, 10);
    }

    public static void waitForElement(WebDriver driver, WebElement element, long seconds) {
        //Overloading of method waitForElement, when you know an element takes more then 10 seconds to load.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (NoSuchElementException | TimeoutException | StaleElementReferenceException e) {
            //exception handling: generate clean error message
            Assert.fail("Element not found on page: " + element);
        }
    }

    public static void waitForElements(WebDriver driver, List<WebElement> elementList) {
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
