package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.service.AddProjectFieldsPageService;

public class DashboardPage extends BasePage {

    private String projectLink = "//div[@id='content_container']//a[contains(text(),'%s')]";

    @FindBy(xpath = "//span[@class='navigation-username']")
    private WebElement username;
    @FindBy(xpath = "//a[contains(text(), 'Add Project')]")
    private WebElement addProjectButton;
    @FindBy(xpath = "//a[@id='navigation-admin']")
    private WebElement adminButton;


    @Step("Open Dashboard Page")
    public void openDashboardPage(String url) {
        driver.get(url);
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

    @Step("Click project link")
    public void clickProjectLink(String projectName) {
        WebElement link = driver.findElement(By.xpath(String.format(projectLink, projectName)));
        waitVisibilityOf(link).click();
    }

    @Step("Click 'Administration' button")
    public void clickAdminButton() {
        waitElementToBeClickable(adminButton).click();
    }
}
