package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


@Log4j2
public class TestCasePage extends BasePage {

    private static final String OBJECT_XPATH = "//li[contains(text(), '%s')]";
    private static final Duration WAIT_DISAPPEAR_SECONDS = Duration.ofSeconds(20);

    @FindBy(xpath = "//a[contains(text(), 'Add Section')]")
    private WebElement addFirstSectionButton;
    @FindBy(xpath = "//a[@id='addSection']")
    private WebElement addSectionButton;
    @FindBy(xpath = "//a[@id='sidebar-cases-add']")
    private WebElement addTestCaseButton;
    @FindBy(xpath = "//input[@name='editSectionName']")
    private WebElement sectionNameInputField;
    @FindBy(xpath = "//div[@id='editSectionDescription_display']")
    private WebElement sectionDescriptionInputField;
    @FindBy(xpath = "//span[@class='editSectionAdd']")
    private WebElement submitSectionButton;
    @FindBy(xpath = "//input[@name='title']")
    private WebElement testCaseTitleInputField;
    @FindBy(xpath = "//div[@id='section_id_chzn']")
    private WebElement sectionList;
    @FindBy(xpath = "//div[@id='template_id_chzn']")
    private WebElement templateList;
    @FindBy(xpath = "//div[@id='type_id_chzn']")
    private WebElement typeList;
    @FindBy(xpath = "//div[@id='priority_id_chzn']")
    private WebElement priorityList;
    @FindBy(xpath = "//button[@id='accept']")
    private WebElement submitTestCaseButton;
    @FindBy(xpath = "//div[@class='blockUI blockOverlay']")
    private WebElement blocker;

    @Step("Click 'Add Section' button")
    public TestCasePage clickAddSectionButton() {
        log.info("Add section");
        WebDriverWait wait = new WebDriverWait(driver, WAIT_DISAPPEAR_SECONDS);
        wait.until(ExpectedConditions.invisibilityOf(blocker));
        if (!addFirstSectionButton.isDisplayed()) {
            addSectionButton.click();
        } else {
            addFirstSectionButton.click();
        }
        return this;
    }

    @Step("Fill in section name field")
    public TestCasePage fillInSectionNameField(String sectionName) {
        log.info("Fill in section name");
        waitVisibilityOf(sectionNameInputField).sendKeys(sectionName);
        return this;
    }

    @Step("Fill in section description field")
    public TestCasePage fillInSectionDescriptionField(String sectionDescription) {
        log.info("Fill in section description");
        waitVisibilityOf(sectionDescriptionInputField).sendKeys(sectionDescription);
        return this;
    }

    @Step("Confirm addition of section")
    public TestCasePage confirmNewSection() {
        log.info("Confirm section addition");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", submitSectionButton);
        return this;
    }

    @Step("Click 'Add Test Case' button")
    public TestCasePage clickAddTestCaseButton() {
        log.info("Add test case");
        addTestCaseButton.click();
        return this;
    }

    @Step("Fill in test case title field")
    public TestCasePage fillInTestCaseTitleField(String testCaseTitle) {
        log.info("Fill in test case title");
        waitVisibilityOf(testCaseTitleInputField).sendKeys(testCaseTitle);
        return this;
    }

    @Step("Choose section")
    public TestCasePage chooseSection(String sectionName) {
        log.info("Choose section");
        WebDriverWait wait = new WebDriverWait(driver, WAIT_DISAPPEAR_SECONDS);
        wait.until(ExpectedConditions.invisibilityOf(blocker));
        waitElementToBeClickable(sectionList).click();
        waitVisibilityOf(driver.findElement(By.xpath(String.format(OBJECT_XPATH, sectionName)))).click();
        return this;
    }

    @Step("Choose template")
    public TestCasePage chooseTemplate(String template) {
        log.info("Choose template");
        waitVisibilityOf(templateList).click();
        waitVisibilityOf(driver.findElement(By.xpath(String.format(OBJECT_XPATH, template)))).click();
        return this;
    }

    @Step("Choose type")
    public TestCasePage chooseType(String type) {
        log.info("Choose type");
        waitVisibilityOf(typeList).click();
        waitVisibilityOf(driver.findElement(By.xpath(String.format(OBJECT_XPATH, type)))).click();
        return this;
    }

    @Step("Choose priority")
    public TestCasePage choosePriority(String priority) {
        log.info("Choose priority");
        waitVisibilityOf(priorityList).click();
        waitVisibilityOf(driver.findElement(By.xpath(String.format(OBJECT_XPATH, priority)))).click();
        return this;
    }

    @Step("Click 'Submit Test Case'")
    public void clickSubmitTestCase() {
        log.info("Confirm creation of a new test case");
        waitVisibilityOf(submitTestCaseButton).click();
    }
}
