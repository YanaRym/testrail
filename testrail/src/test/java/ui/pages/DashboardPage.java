package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

    @FindBy (xpath = "//span[@class=\"navigation-username\"]")
    private WebElement username;

    @FindBy (xpath = "//a[contains(text(), 'Add Project')]")
    private WebElement addProjectButton;

    @FindBy (xpath = "//a[@id='navigation-empty-addexampleproject']")
    private  WebElement addExampleProjectButton;

    @FindBy (xpath = "//input[@id='addProjectName']")
    private WebElement exampleProjectNameInputField;

    @FindBy (xpath = "//button[contains(text(), 'Add Example Project')]")
    private WebElement addExampleProjectConfirmationButton;

    public DashboardPage openDashboardPage(String url) {
        driver.get(url);
        return this;
    }


    public boolean isUsernameDisplayed() {
        return waitVisibilityOf(username).isDisplayed();
    }

    public void clickAddProjectButton() {
        waitVisibilityOf(addProjectButton).click();
    }

    public void clickAddExampleProjectButton() {
        waitVisibilityOf(addExampleProjectButton).click();
    }


    public void inputExampleProjectName(String projectName){
        waitVisibilityOf(exampleProjectNameInputField).sendKeys(projectName);
    }

    public void exampleProjectConfirmationButtonClick(){
        waitVisibilityOf(addExampleProjectConfirmationButton).click();
    }
}
