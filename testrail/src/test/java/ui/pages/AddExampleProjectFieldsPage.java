package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


@Log4j2
public class AddExampleProjectFieldsPage extends BasePage {


    @FindBy(xpath = "//input[@id='addProjectName']")
    private WebElement exampleProjectNameInputField;
    @FindBy(xpath = "//button[contains(text(), 'Add Example Project')]")
    private WebElement addExampleProjectConfirmationButton;


    @Step("Fill in example project name field")
    public AddExampleProjectFieldsPage inputExampleProjectName(String projectName) {
        log.info("Fill in example project name field");
        waitVisibilityOf(exampleProjectNameInputField).sendKeys(projectName);
        return this;
    }

    @Step("Click 'Add example project' button")
    public void exampleProjectConfirmationButtonClick() {
        log.info("Confirm addition of a new example project");
        waitVisibilityOf(addExampleProjectConfirmationButton).click();
    }
}
