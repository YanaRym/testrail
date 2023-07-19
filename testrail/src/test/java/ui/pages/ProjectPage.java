package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Log4j2
public class ProjectPage extends BasePage {

    private static final String PROJECT_NAME_XPATH = "//a[contains(text(), '%s')]";
    private static final Duration WAIT_FOR_PROJECT_TIMEOUT = Duration.ofSeconds(60);


    @FindBy(xpath = "//a[contains(text(), 'Edit')]")
    private WebElement editButton;
    @FindBy(xpath = "//input[@id='is_completed']")
    private WebElement projectCompleteCheckbox;
    @FindBy(xpath = "//button[@id='accept']")
    private WebElement saveButton;
    @FindBy(xpath = "//div[@class='message message-success']")
    private WebElement successMessage;
    @FindBy(xpath = "//div[@id='activityContainer']")
    private WebElement activityDiagram;
    @FindBy(xpath = "//a[@id='sidebar-milestones-add']")
    private WebElement addMilestoneButton;
    @FindBy(xpath = "//a[@id='sidebar-runs-add']")
    private WebElement addTestRunsButton;
    @FindBy(xpath = "//a[@id='sidebar-cases-add']")
    private WebElement addTestCases;
    @FindBy(xpath = "//a[@id='sidebar-suites-viewall']")
    private WebElement viewAllTestCasesButton;


    @Step("Check if example project name is displayed")
    public boolean isExampleProjectNameDisplayed(String projectName) {
        log.info("Check example project name is displayed");
        WebDriverWait wait = new WebDriverWait(driver, WAIT_FOR_PROJECT_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(activityDiagram));
        WebElement projectTitle = driver.findElement(By.xpath(String.format(PROJECT_NAME_XPATH, projectName)));
        return projectTitle.isDisplayed();
    }

    @Step("Check if project name is displayed")
    public boolean isProjectNameDisplayed(String projectName) {
        log.info("Check project name is displayed");
        WebElement projectTitle = driver.findElement(By.xpath(String.format(PROJECT_NAME_XPATH, projectName)));
        return projectTitle.isDisplayed();
    }

    @Step("Click 'Edit' button")
    public ProjectPage clickEditButton() {
        log.info("Edit project");
        editButton.click();
        return this;
    }

    @Step("Tick 'Complete' checkbox")
    public ProjectPage checkCompleteCheckbox() {
        log.info("Mark project as complete");
        waitElementToBeClickable(projectCompleteCheckbox).click();
        return this;
    }

    @Step("Click 'Save' button")
    public void clickSaveButton() {
        log.info("Click save");
        saveButton.click();
    }

    @Step("Check if success message is displayed")
    public boolean isSuccessMessageDisplayed() {
        log.info("Check success message is displayed");
        WebDriverWait wait = new WebDriverWait(driver, WAIT_FOR_PROJECT_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        return successMessage.isDisplayed();
    }

    @Step("Click 'Add milestone' button")
    public MilestonePage clickAddMilestoneButton() {
        log.info("Add new milestone");
        waitElementToBeClickable(addMilestoneButton).click();
        return new MilestonePage();
    }

    @Step("Click 'View all' test cases button")
    public TestCasePage clickViewAllButton() {
        log.info("View all test cases");
        waitElementToBeClickable(viewAllTestCasesButton).click();
        return new TestCasePage();
    }
}
