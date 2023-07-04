package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.models.Project;


public class AddProjectPage extends BasePage {

    @FindBy(xpath = "//input[@id='name']")
    private WebElement projectNameInputField;
    @FindBy(xpath = "//button[@id='accept']")
    private WebElement acceptButton;

    @FindBy(xpath = "//div[@class='message message-error']")
    private WebElement noNameErrorMessage;


    public AddProjectPage fillInProjectName(Project project) {
        waitVisibilityOf(projectNameInputField).sendKeys(project.getProjectName());
        return this;
    }

    public void clickAcceptProjectButton() {
        waitVisibilityOf(acceptButton).click();
    }

    public boolean isNoNameErrorMessageDisplayed() {
      return waitVisibilityOf(noNameErrorMessage).isDisplayed();
    }
}

