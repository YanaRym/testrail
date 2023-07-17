package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class AddExampleProjectFieldsPage extends BasePage {


    private final static Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(60);
    private static final String EXAMPLE_PROJECT_NAME_XPATH = "//div[contains(text(), '%s')]";

    @FindBy(xpath = "//input[@id='addProjectName']")
    private WebElement exampleProjectNameInputField;
    @FindBy(xpath = "//button[contains(text(), 'Add Example Project')]")
    private WebElement addExampleProjectConfirmationButton;


    @Step("Fill in example project name field")
    public AddExampleProjectFieldsPage inputExampleProjectName(String projectName) {
        waitVisibilityOf(exampleProjectNameInputField).sendKeys(projectName);
        return this;
    }

    @Step("Click 'Add example project' button")
    public void exampleProjectConfirmationButtonClick() {
        waitVisibilityOf(addExampleProjectConfirmationButton).click();
    }

    @Step("Check if example project name is displayed")
    public boolean isExampleProjectCreated(String projectName) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(EXAMPLE_PROJECT_NAME_XPATH, projectName))));
        WebElement projectTitle = driver.findElement(By.xpath(String.format(EXAMPLE_PROJECT_NAME_XPATH, projectName)));
        return projectTitle.isDisplayed();
    }
}
