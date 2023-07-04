package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.models.Project;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;


public class ExampleProjectPage extends BasePage {

    private static final String EXAMPLE_PROJECT_NAME_XPATH = "//div[contains(text(), '%s')]";


    public boolean isExampleProjectCreated(Project project) {
        //  WebElement projectTitle = driver.findElement(By.xpath(String.format(EXAMPLE_PROJECT_NAME_XPATH, project.getProjectName())));
        //driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        //WebDriverWait wait = new WebDriverWait(driver, 20);
        //wait.until(ExpectedConditions.visibilityOf(projectTitle));
        Wait<WebDriver> fluent = new FluentWait<>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(5, SECONDS)
                .ignoring(NoSuchElementException.class);
        WebElement projectTitle = fluent.until(driver -> driver.findElement(By.xpath(String.format(EXAMPLE_PROJECT_NAME_XPATH, project.getProjectName()))));
        return projectTitle.isDisplayed();
    }
}
