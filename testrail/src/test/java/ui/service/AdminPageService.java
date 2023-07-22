package ui.service;

import io.qameta.allure.Step;
import ui.pages.AdminPage;

import static ui.constatns.PageUrls.ADMIN_PAGE;

public class AdminPageService {

    private final AdminPage adminPage = new AdminPage();

    @Step("Open Administration page")
    public AdminPageService open() {
        adminPage.openAdminPage(ADMIN_PAGE);
        return this;
    }

    @Step("Go to 'Projects' directory")
    public void goToProjectDirectory() {
        adminPage.clickProjectsButton();
    }

    @Step("Click 'Delete'")
    public AdminPageService clickDeleteProject(String projectName) {
        adminPage.clickDeleteButton(projectName);
        return this;
    }

    @Step("Confirm deletion")
    public AdminPageService confirmDeletion(String projectName) {
        adminPage.clickDeleteProjectCheckbox(projectName);
        return this;
    }

    @Step("Click 'Ok' button")
    public void clickOkButton(String projectName) {
        adminPage.clickOkButton(projectName);
    }

    @Step("Add project")
    public void addProject(String projectName) {
        AddProjectFieldsPageService addProjectPageFieldsService = adminPage.clickAddProjectButton();
        addProjectPageFieldsService.addProject(projectName);
    }

    @Step("Add example project")
    public void addExampleProject(String projectName) {
        AddExampleProjectFieldsPageService addExampleProjectFieldsPageService = adminPage.clickAddExampleProjectButton();
        addExampleProjectFieldsPageService.addExampleProject(projectName);
    }
}
