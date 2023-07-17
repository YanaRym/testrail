package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestCasePage extends BasePage {

    private static String OBJECT_XPATH = "//li[contains(text(), '%s')]";

    @FindBy(xpath = "//a[@id='addSectionInline']")
    private WebElement addSectionButton;
    @FindBy(xpath = "//a[@id='sidebar-cases-add']")
    private WebElement addTestCaseButton;
    @FindBy(xpath = "//input[@name='editSectionName']") ////option[contains(text(), 'New')]
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

    @Step("Click 'Add Section' button")
    public TestCasePage clickAddSectionButton() {
        waitElementToBeClickable(addSectionButton).click();
        return this;
    }

    @Step("Fill in section name field")
    public TestCasePage fillInSectionNameField(String sectionName) {
        waitVisibilityOf(sectionNameInputField).sendKeys(sectionName);
        return this;
    }

    @Step("Fill in section description field")
    public TestCasePage fillInSectionDescriptionField(String sectionDescription) {
        waitVisibilityOf(sectionDescriptionInputField).sendKeys(sectionDescription);
        return this;
    }

    @Step("Confirm addition of section")
    public TestCasePage confirmNewSection() {
        waitElementToBeClickable(submitSectionButton).click();
        return this;
    }

    @Step("Click 'Add Test Case' button")
    public TestCasePage clickAddTestCaseButton() {
        waitElementToBeClickable(addTestCaseButton).click();
        return this;
    }

    @Step("Fill in test case title field")
    public TestCasePage fillInTestCaseTitleField(String testCaseTitle) {
        waitVisibilityOf(testCaseTitleInputField).sendKeys(testCaseTitle);
        return this;
    }

    @Step("Choose section")
    public TestCasePage chooseSection(String sectionName) {
        waitElementToBeClickable(sectionList).click();
        waitVisibilityOf(driver.findElement(By.xpath(String.format(OBJECT_XPATH, sectionName)))).click();
        return this;
    }

    @Step("Choose template")
    public TestCasePage chooseTemplate(String template) {
        waitVisibilityOf(templateList).click();
        waitVisibilityOf(driver.findElement(By.xpath(String.format(OBJECT_XPATH, template)))).click();
        return this;
    }

    @Step("Choose type")
    public TestCasePage chooseType(String type) {
        waitVisibilityOf(typeList).click();
        waitVisibilityOf(driver.findElement(By.xpath(String.format(OBJECT_XPATH, type)))).click();
        return this;
    }

    @Step("Choose priority")
    public TestCasePage choosePriority(String priority) {
        waitVisibilityOf(priorityList).click();
        waitVisibilityOf(driver.findElement(By.xpath(String.format(OBJECT_XPATH, priority)))).click();
        return this;
    }

    @Step("Click 'Submit Test Case'")
    public void clickSubmitTestCase() {
        waitVisibilityOf(submitTestCaseButton).click();
    }
}
