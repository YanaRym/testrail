package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class MilestonePage extends BasePage {

    @FindBy(xpath = "//input[@name='name']")
    private WebElement milestoneNameInputField;
    @FindBy(xpath = "//input[@name='reference']")
    private WebElement milestoneReferenceInputField;
    @FindBy(xpath = "//div[@id='description_display']")
    private WebElement milestoneDescriptionInputField;
    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement milestoneIsCompleteCheckbox;
    @FindBy(xpath = "//button[@id='accept']")
    private WebElement addMilestoneButton;

    @Step("Fill in milestone name field")
    public MilestonePage fillInMilestoneNameField(String milestoneName) {
        log.info("Fill in milestone name");
        waitVisibilityOf(milestoneNameInputField).sendKeys(milestoneName);
        return this;
    }

    @Step("Fill in milestone reference field")
    public MilestonePage fillInMilestoneReferenceField(String milestoneReference) {
        log.info("Fill in milestone reference");
        waitVisibilityOf(milestoneReferenceInputField).sendKeys(milestoneReference);
        return this;
    }

    @Step("Fill in milestone description")
    public MilestonePage fillInMilestoneDescriptionField(String milestoneDescription) {
        log.info("Fill in milestone description");
        waitVisibilityOf(milestoneDescriptionInputField).sendKeys(milestoneDescription);
        return this;
    }

    @Step("Click 'Add milestone' button")
    public void clickAddMilestoneButton() {
        log.info("Click add milestone");
        waitElementToBeClickable(addMilestoneButton).click();
    }

}
