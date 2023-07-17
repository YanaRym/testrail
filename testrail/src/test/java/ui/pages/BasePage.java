package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.driver.DriverSingleton;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver = DriverSingleton.getInstance().getDriver();

    protected final static Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(10);

    protected BasePage() {
        PageFactory.initElements(driver, this);
    }

    protected WebElement waitVisibilityOf(WebElement element) {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement waitElementToBeClickable(WebElement element) {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(element));
    }
}