package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AddProjectFieldsPage extends BasePage {

    @FindBy(xpath = "//input[@id='name']")
    private WebElement projectNameInputField;
    @FindBy(xpath = "//button[@id='accept']")
    private WebElement acceptButton;
    @FindBy(xpath = "//div[@class='message message-error']")
    private WebElement noNameErrorMessage;


    @Step("Fill in project name field")
    public AddProjectFieldsPage fillInProjectName(String projectName) {
        waitVisibilityOf(projectNameInputField).sendKeys(projectName);
        return this;
    }

    @Step("Click 'Add project' button")
    public void clickAcceptProjectButton() {
        waitVisibilityOf(acceptButton).click();
    }

    @Step("Check if no project name message is displayed")
    public boolean isNoNameErrorMessageDisplayed() {
        return waitVisibilityOf(noNameErrorMessage).isDisplayed();
    }
}

