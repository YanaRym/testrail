package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.models.Project;

public class ProjectPage extends BasePage {


    private static final String PROJECT_NAME_XPATH = "//a[contains(text(), '%s')]";


    public boolean isProjectNameDisplayed(Project project) {
        WebElement projectTitle = driver.findElement(By.xpath(String.format(PROJECT_NAME_XPATH, project.getProjectName())));
        return projectTitle.isDisplayed();
    }
}
