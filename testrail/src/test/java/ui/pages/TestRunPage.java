package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class TestRunPage extends BasePage {

    private static final String MILESTONE_XPATH = "//li[contains(text(), '%s')]";
    private static final String TEST_CASE_XPATH = "//span[contains(text(), '%s')]/../../..//input[@type='checkbox']";

    @FindBy(xpath = "//div[@id='milestone_id_chzn']")
    private WebElement milestoneListField;
    @FindBy(xpath = "//div[@id='description_display']")
    private WebElement descriptionField;
    @FindBy(xpath = "//div[@id='assignedto_id_chzn']")
    private WebElement assignedToField;
    @FindBy(xpath = "//li[@id='assignedto_id_chzn_o_1']")
    private WebElement assignToMeChoice;
    @FindBy(xpath = "//input[@id='includeSpecific']")
    private WebElement specificTestCasesButton;
    @FindBy(xpath = "//a[contains(text(), 'change selection')]")
    private WebElement changeTestCaseSelectionButton;
    @FindBy(xpath = "//button[@id='selectCasesSubmit']")
    private WebElement okButton;
    @FindBy(xpath = "//button[@id='accept']")
    private WebElement addTestRunButton;


    @Step("Choose milestone")
    public TestRunPage chooseMilestone(String milestoneName) {
        log.info("Choose milestone");
        waitElementToBeClickable(milestoneListField).click();
        waitVisibilityOf(driver.findElement((By.xpath(String.format(MILESTONE_XPATH, milestoneName))))).click();
        return this;
    }

    @Step("Choose user")
    public TestRunPage chooseUser() {
        log.info("Choose user");
        waitElementToBeClickable(assignedToField).click();
        waitVisibilityOf(assignToMeChoice).click();
        return this;
    }

    @Step("Fill in description field")
    public TestRunPage fillInDescription(String testCaseDescription) {
        log.info("Fill in description field");
        waitVisibilityOf(descriptionField).sendKeys(testCaseDescription);
        return this;
    }

    @Step("Click 'Specific test cases' button")
    public TestRunPage clickSpecificTestCasesButton() {
        log.info("Click 'Specific test cases' button");
        waitElementToBeClickable(specificTestCasesButton).click();
        return this;
    }

    @Step("Click 'change selection' button")
    public TestRunPage clickChangeSelectionButton() {
        log.info("Change selection of test cases");
        waitElementToBeClickable(changeTestCaseSelectionButton).click();
        return this;
    }

    @Step("Choose test cases")
    public TestRunPage chooseTestCases(String testCaseTitle) {
        log.info("Choose test cases");
        waitVisibilityOf(driver.findElement(By.xpath(String.format(TEST_CASE_XPATH, testCaseTitle)))).click();
        return this;
    }

    @Step("Click ok")
    public TestRunPage clickOk() {
        log.info("Click ok");
        waitElementToBeClickable(okButton).click();
        return this;
    }

    @Step("Confirm addition of test run")
    public void confirmAdditionOfTestRun() {
        log.info("Confirm creation of new test run");
        waitElementToBeClickable(addTestRunButton).click();
    }
}
