import com.google.common.primitives.Booleans;
import org.junit.Assert;
import org.junit.Test;
import pageobjects.pages.Home;
import pageobjects.pages.Widgets;

import static java.lang.Thread.sleep;
import static utils.DriverManager.driver;

public class WidgetsTests {

    @Test
    public void weDoWeUseItTest() throws InterruptedException {
        driver().get("https://demoqa.com/");

        Home.clickOnWidgetsPage(driver());
        Widgets.clickOnAccordion(driver());

        String whyDoWeUseItText = Widgets.retrieveWhyDoWeUseItText(driver());

        boolean contains = whyDoWeUseItText.contains("Content here, content here");
        Assert.assertTrue(contains);
    }
}
