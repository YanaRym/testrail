package ui.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import ui.driver.DriverSingleton;
import utilities.TestListener;

@Listeners(TestListener.class)
public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void startBrowser() {
        driver = DriverSingleton.getInstance().getDriver();
    }

        @AfterMethod(alwaysRun = true)
    public void stopBrowser() {
        DriverSingleton.getInstance().closeDriver();
    }
}