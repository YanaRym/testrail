package ui.service;

import io.qameta.allure.Step;
import ui.pages.AddProjectFieldsPage;
import ui.pages.ProjectPage;

public class AddProjectFieldsPageService {


    @Step("Add project")
    public void addProject(String projectName) {
        AddProjectFieldsPage addProjectFieldsPage = new AddProjectFieldsPage();
        addProjectFieldsPage.fillInProjectName(projectName)
                .clickAcceptProjectButton();
    }

    @Step("Check if project is created")
    public boolean isProjectCreated(String projectName) {
        ProjectPage projectPage = new ProjectPage();
        return projectPage.isProjectNameDisplayed(projectName);
    }

    @Step("Check if error message is displayed")
    public boolean isErrorMessageDisplayed() {
        AddProjectFieldsPage addProjectPage = new AddProjectFieldsPage();
        return addProjectPage.isNoNameErrorMessageDisplayed();
    }
}
