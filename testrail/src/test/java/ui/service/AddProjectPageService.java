package ui.service;

import ui.models.Project;
import ui.pages.AddProjectPage;
import ui.pages.ProjectPage;

public class AddProjectPageService {

    public boolean isProjectCreated(Project project) {
        ProjectPage projectPage = new ProjectPage();
        return projectPage.isProjectNameDisplayed(project);
    }

    public boolean isErrorMessageDisplayed(){
        AddProjectPage addProjectPage = new AddProjectPage();
        return addProjectPage.isNoNameErrorMessageDisplayed();
    }
}
