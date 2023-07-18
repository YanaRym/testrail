package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AddExampleProjectFieldsPage extends BasePage {


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
}
