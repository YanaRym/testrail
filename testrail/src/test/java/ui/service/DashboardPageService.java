package ui.service;

import io.qameta.allure.Step;
import ui.pages.DashboardPage;

import static ui.constatns.PageUrls.DASHBOARD_PAGE;

public class DashboardPageService {


    @Step("Open Dashboard page")
    public DashboardPageService open() {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.openDashboardPage(DASHBOARD_PAGE);
        return this;
    }

    @Step("Add project")
    public void addProject(String projectName) {
        DashboardPage dashboardPage = new DashboardPage();
        AddProjectFieldsPageService addProjectPageFieldsService = dashboardPage.clickAddProjectButton();
        addProjectPageFieldsService.addProject(projectName);
    }

    @Step("Go to project info directory")
    public ProjectPageService goToProjectInfo(String projectName) {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.clickProjectLink(projectName);
        return new ProjectPageService();
    }


    @Step("Go to Administration page")
    public AdminPageService goToAdminPage() {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.clickAdminButton();
        return new AdminPageService();
    }
}
