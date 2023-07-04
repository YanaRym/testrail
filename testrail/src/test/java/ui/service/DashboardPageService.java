package ui.service;

import ui.models.Project;
import ui.pages.AddProjectPage;
import ui.pages.DashboardPage;
import ui.pages.ExampleProjectPage;

import static ui.constatns.PageUrls.TESTRAIL_DASHBOARD_PAGE;

public class DashboardPageService {

    public AddProjectPage addProject(Project project) {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.openDashboardPage(TESTRAIL_DASHBOARD_PAGE)
                .clickAddProjectButton();
        AddProjectPage addProjectPage = new AddProjectPage();
        addProjectPage.fillInProjectName(project)
                .clickAcceptProjectButton();
        return new AddProjectPage();
    }


    public ExampleProjectPage addExampleProject(Project project) {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.openDashboardPage(TESTRAIL_DASHBOARD_PAGE)
                .clickAddExampleProjectButton();
        dashboardPage.inputExampleProjectName(project.getProjectName());
        dashboardPage.exampleProjectConfirmationButtonClick();
        return new ExampleProjectPage();
    }

}
