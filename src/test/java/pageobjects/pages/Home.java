package pageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.DriverManager;

import static utils.DriverManager.driver;

public class Home {

    public static void clickOnWidgetsPage(WebDriver driver) {
        String xpath = "//*[contains(text(), 'Widgets')]";
        WebElement element = driver.findElement(By.xpath(xpath));
        DriverManager.waitForElement(driver, element);
        element.click();
    }
}
