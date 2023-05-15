package pageobjects.pages;

import static utils.DriverManager.driver;

public class Home {

    public static void clickOnWidgetsPage() {
        driver().get("https://demoqa.com/");
    }
}
