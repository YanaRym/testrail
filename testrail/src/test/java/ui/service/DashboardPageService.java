package ui.service;

import io.qameta.allure.Step;
import ui.pages.DashboardPage;

import static ui.constatns.PageUrls.DASHBOARD_PAGE;

public class DashboardPageService {

    private final DashboardPage dashboardPage = new DashboardPage();


    @Step("Open Dashboard page")
    public DashboardPageService open() {
        dashboardPage.openDashboardPage(DASHBOARD_PAGE);
        return this;
    }

    @Step("Add project")
    public void addProject(String projectName) {
        AddProjectFieldsPageService addProjectPageFieldsService = dashboardPage.clickAddProjectButton();
        addProjectPageFieldsService.addProject(projectName);
    }

    @Step("Go to project info directory")
    public ProjectPageService goToProjectInfo(String projectName) {
        dashboardPage.clickProjectLink(projectName);
        return new ProjectPageService();
    }

    @Step("Go to Administration page")
    public AdminPageService goToAdminPage() {
        dashboardPage.clickAdminButton();
        return new AdminPageService();
    }
}
