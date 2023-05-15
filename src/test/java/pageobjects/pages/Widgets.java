package pageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.DriverManager;

public class Widgets {
    public static void clickOnAccordion(WebDriver driver) {
        String xpath = "//*[contains(text(), 'Accordian')]";
        WebElement element = driver.findElement(By.xpath(xpath));
        DriverManager.waitForElement(driver, element);

        element.click();
    }

    public static String retrieveWhyDoWeUseItText(WebDriver driver) {
        WebElement element = driver.findElement(By.id("section3Heading"));
        DriverManager.waitForElement(driver, element);
        element.click();

        element = driver.findElement(By.id("section3Content"));
        DriverManager.waitForElement(driver, element);

        return element.getText();
    }
}
