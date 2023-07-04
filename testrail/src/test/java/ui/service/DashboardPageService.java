package ui.service;

import ui.models.Project;
import ui.pages.AddProjectPage;
import ui.pages.DashboardPage;

import static ui.constatns.PageUrls.TESTRAIL_DASHBOARD_PAGE;

public class DashboardPageService {

    public AddProjectPage addProject(Project project) {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.openDashboardPage(TESTRAIL_DASHBOARD_PAGE)
                .clickAddProjectButton();
        AddProjectPage addProjectPage = new AddProjectPage();
        addProjectPage.fillInProjectName(project)
                .clickAcceptProjectButton();
        return addProjectPage;
    }


    public void addExampleProject(Project project) {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.openDashboardPage(TESTRAIL_DASHBOARD_PAGE)
                .clickAddExampleProjectButton();
        dashboardPage.inputExampleProjectName(project.getProjectName());
        dashboardPage.exampleProjectConfirmationButtonClick();
    }

}
