package ui.service;

import io.qameta.allure.Step;
import ui.pages.AdminPage;

import static ui.constatns.PageUrls.ADMIN_PAGE;

public class AdminPageService {


    @Step("Open Administration page")
    public AdminPageService open() {
        AdminPage adminPage = new AdminPage();
        adminPage.openAdminPage(ADMIN_PAGE);
        return this;
    }

    @Step("Go to 'Projects' directory")
    public void goToProjectDirectory() {
        AdminPage adminPage = new AdminPage();
        adminPage.clickProjectsButton();
    }

    @Step("Click 'Delete'")
    public AdminPageService clickDeleteProject(String projectName) {
        AdminPage adminPage = new AdminPage();
        adminPage.clickDeleteButton(projectName);
        return this;
    }

    @Step("Confirm deletion")
    public AdminPageService confirmDeletion(String projectName) {
        AdminPage adminPage = new AdminPage();
        adminPage.checkDeleteProjectCheckbox(projectName);
        return this;
    }

    @Step("Click 'Ok' button")
    public void clickOkButton(String projectName) {
        AdminPage adminPage = new AdminPage();
        adminPage.clickOkButton(projectName);
    }

    @Step("Add project")
    public void addProject(String projectName) {
        AdminPage adminPage = new AdminPage();
        AddProjectFieldsPageService addProjectPageFieldsService = adminPage.clickAddProjectButton();
        addProjectPageFieldsService.addProject(projectName);
    }

    @Step("Add example project")
    public void addExampleProject(String projectName) {
        AdminPage adminPage = new AdminPage();
        AddExampleProjectFieldsPageService addExampleProjectFieldsPageService = adminPage.clickAddExampleProjectButton();
        addExampleProjectFieldsPageService.addExampleProject(projectName);
    }
}
