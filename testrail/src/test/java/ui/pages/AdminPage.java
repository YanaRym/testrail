package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.service.AddExampleProjectFieldsPageService;
import ui.service.AddProjectFieldsPageService;

@Log4j2
public class AdminPage extends BasePage {

    private static final String deleteProjectButtonLink = "//a[contains(text(), '%s')]/../following-sibling::*/a/div[@class='icon-small-delete']";
    private static final String deleteProjectCheckbox = "//strong[contains(text(), '%s')]/../..//input[@type='checkbox']";
    private static final String okDeleteButton = "//strong[contains(text(), '%s')]/../../following-sibling::*//a[contains(text(), 'OK')]";

    @FindBy(xpath = "//a[@id='navigation-sub-projects']")
    private WebElement projectNavigationButton;
    @FindBy(xpath = "//a[@class='button button-left button-add'][1]")
    private WebElement addProjectButton;
    @FindBy(xpath = "//a[@class='button button-left button-add'][2]")
    private WebElement addExampleProjectButton;


    @Step("Open Administration page")
    public AdminPage openAdminPage(String url) {
        log.info("Open administration");
        driver.get(url);
        return this;
    }

    @Step("Click 'Projects' button")
    public void clickProjectsButton() {
        log.info("Go to projects directory");
        waitElementToBeClickable(projectNavigationButton).click();
    }

    @Step("Click 'Delete' button")
    public AdminPage clickDeleteButton(String projectName) {
        log.info("Click 'delete'");
        WebElement link = driver.findElement(By.xpath(String.format(deleteProjectButtonLink, projectName)));
        waitVisibilityOf(link).click();
        return this;
    }

    @Step("Tick 'Yes, delete this project' checkbox")
    public AdminPage checkDeleteProjectCheckbox(String projectName) {
        log.info("Confirm deletion");
        WebElement deleteCheckbox = driver.findElement(By.xpath(String.format(deleteProjectCheckbox, projectName)));
        waitVisibilityOf(deleteCheckbox).click();
        return this;
    }

    @Step("Click 'Ok' button")
    public void clickOkButton(String projectName) {
        log.info("Click ok");
        WebElement okButton = driver.findElement(By.xpath(String.format(okDeleteButton, projectName)));
        waitElementToBeClickable(okButton).click();
    }

    @Step("Click 'Add project' button")
    public AddProjectFieldsPageService clickAddProjectButton() {
        log.info("Click add new project");
        waitElementToBeClickable(addProjectButton).click();
        return new AddProjectFieldsPageService();
    }

    @Step("Click 'Add example project' button")
    public AddExampleProjectFieldsPageService clickAddExampleProjectButton() {
        log.info("Click add new example project");
        waitElementToBeClickable(addExampleProjectButton).click();
        return new AddExampleProjectFieldsPageService();
    }
}
