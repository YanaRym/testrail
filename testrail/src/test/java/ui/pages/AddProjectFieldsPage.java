package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class AddProjectFieldsPage extends BasePage {

    @FindBy(xpath = "//input[@id='name']")
    private WebElement projectNameInputField;
    @FindBy(xpath = "//button[@id='accept']")
    private WebElement acceptButton;
    @FindBy(xpath = "//div[@class='message message-error']")
    private WebElement noNameErrorMessage;

    @Step("Fill in project name field")
    public AddProjectFieldsPage fillInProjectName(String projectName) {
        log.info("Fill in project name field");
        waitVisibilityOf(projectNameInputField).sendKeys(projectName);
        return this;
    }

    @Step("Click 'Add project' button")
    public void clickAcceptProjectButton() {
        log.info("Confirm adding a new project");
        waitVisibilityOf(acceptButton).click();
    }

    @Step("Check if no project name message is displayed")
    public boolean isNoNameErrorMessageDisplayed() {
        log.info("Check error message is displayed");
        return waitVisibilityOf(noNameErrorMessage).isDisplayed();
    }
}
