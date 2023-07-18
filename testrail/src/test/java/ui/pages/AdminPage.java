package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.service.AddExampleProjectFieldsPageService;
import ui.service.AddProjectFieldsPageService;

public class AdminPage extends BasePage {

    private String deleteProjectButtonLink = "//a[contains(text(), '%s')]/../following-sibling::*/a/div[@class='icon-small-delete']";
    private String deleteProjectCheckbox = "//strong[contains(text(), '%s')]/../..//input[@type='checkbox']";
    private String okDeleteButton = "//strong[contains(text(), '%s')]/../../following-sibling::*//a[contains(text(), 'OK')]";
    private String cancelDeleteButton = "//strong[contains(text(), '%s')]/../../following-sibling::*//a[contains(text(), 'Cancel')]";

    @FindBy(xpath = "//a[@id='navigation-sub-projects']")
    private WebElement projectNavigationButton;
    @FindBy(xpath = "//a[@id='navigation-sub-users']")
    private WebElement usersAndRolesNavigationButton;
    @FindBy(xpath = "//a[@class='button button-left button-add'][1]")
    private WebElement addProjectButton;
    @FindBy(xpath = "//a[@class='button button-left button-add'][2]")
    private WebElement addExampleProjectButton;


    @Step("Open Administration page")
    public AdminPage openAdminPage(String url) {
        driver.get(url);
        return this;
    }

    @Step("Click 'Projects' button")
    public void clickProjectsButton() {
        waitElementToBeClickable(projectNavigationButton).click();
    }

    @Step("Click 'Delete' button")
    public AdminPage clickDeleteButton(String projectName) {
        WebElement link = driver.findElement(By.xpath(String.format(deleteProjectButtonLink, projectName)));
        waitVisibilityOf(link).click();
        return this;
    }

    @Step("Tick 'Yes, delete this project' checkbox")
    public AdminPage checkDeleteProjectCheckbox(String projectName) {
        WebElement deleteCheckbox = driver.findElement(By.xpath(String.format(deleteProjectCheckbox, projectName)));
        waitVisibilityOf(deleteCheckbox).click();
        return this;
    }

    @Step("Click 'Ok' button")
    public void clickOkButton(String projectName) {
        WebElement okButton = driver.findElement(By.xpath(String.format(okDeleteButton, projectName)));
        waitElementToBeClickable(okButton).click();
    }

    public void clickCancelButton(String projectName) {
        WebElement cancelButton = driver.findElement(By.xpath(String.format(cancelDeleteButton, projectName)));
        waitElementToBeClickable(cancelButton).click();
    }

    @Step("Click 'Add project' button")
    public AddProjectFieldsPageService clickAddProjectButton() {
        waitElementToBeClickable(addProjectButton).click();
        return new AddProjectFieldsPageService();
    }

    @Step("Click 'Add example project' button")
    public AddExampleProjectFieldsPageService clickAddExampleProjectButton() {
        waitElementToBeClickable(addExampleProjectButton).click();
        return new AddExampleProjectFieldsPageService();
    }
}
