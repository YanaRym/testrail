package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.service.AddExampleProjectFieldsPageService;
import ui.service.AddProjectFieldsPageService;

public class DashboardPage extends BasePage {

    private String projectLink = "//div[@id='content_container']//a[contains(text(),'%s')]";

    @FindBy(xpath = "//span[@class='navigation-username']")
    private WebElement username;
    @FindBy(xpath = "//a[contains(text(), 'Add Project')]")
    private WebElement addProjectButton;
    @FindBy(xpath = "//a[@id='navigation-empty-addexampleproject']")
    private WebElement addExampleProjectButton;
    //    @FindBy(xpath = "//a[contains(text(), 'create new project')]")
//    private WebElement createNewProjectLink;
    @FindBy(xpath = "//a[@id='navigation-admin']")
    private WebElement adminButton;


    @Step("Open Dashboard Page")
    public DashboardPage openDashboardPage(String url) {
        driver.get(url);
        return this;
    }

    @Step("Check if username is displayed")
    public boolean isUsernameDisplayed() {
        return waitVisibilityOf(username).isDisplayed();
    }

    @Step("Click 'Add project' button")
    public AddProjectFieldsPageService clickAddProjectButton() {
        waitVisibilityOf(addProjectButton).click();
        return new AddProjectFieldsPageService();
    }

    @Step("Click 'Add example project' button")
    public AddExampleProjectFieldsPageService clickAddExampleProjectButton() {
        waitVisibilityOf(addExampleProjectButton).click();
        return new AddExampleProjectFieldsPageService();
    }

    @Step("Click project link")
    public ProjectPage clickProjectLink(String projectName) {
        WebElement link = driver.findElement(By.xpath(String.format(projectLink, projectName)));
        waitVisibilityOf(link).click();
        return new ProjectPage();
    }

////    public DashboardPage clickCreateProjectsLink() {
////        waitElementToBeClickable(createNewProjectLink).click();
////        return this;
//    }

    @Step("Click 'Administration' button")
    public AdminPage clickAdminButton() {
        waitElementToBeClickable(adminButton).click();
        return new AdminPage();
    }
}
