package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.models.Project;


public class ExampleProjectPage extends BasePage {

    private static final String EXAMPLE_PROJECT_NAME_XPATH = "//div[contains(text(), '%s')]";


    public boolean isExampleProjectCreated(Project project) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(EXAMPLE_PROJECT_NAME_XPATH, project.getProjectName()))));
        WebElement projectTitle = driver.findElement(By.xpath(String.format(EXAMPLE_PROJECT_NAME_XPATH, project.getProjectName())));
        return projectTitle.isDisplayed();
    }
}
