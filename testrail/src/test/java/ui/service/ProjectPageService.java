package ui.service;

import io.qameta.allure.Step;
import ui.pages.ProjectPage;

public class ProjectPageService {


    @Step("Check if example project name is displayed")
    public boolean isExampleProjectNameDisplayed(String projectName) {
        ProjectPage projectPage = new ProjectPage();
        return projectPage.isExampleProjectNameDisplayed(projectName);
    }

    @Step("Check if project name is displayed")
    public boolean isProjectNameDisplayed(String projectName) {
        ProjectPage projectPage = new ProjectPage();
        return projectPage.isProjectNameDisplayed(projectName);
    }

    @Step("Edit project")
    public ProjectPage editProject() {
        ProjectPage projectPage = new ProjectPage();
        projectPage.clickEditButton()
                .checkCompleteCheckbox()
                .clickSaveButton();
        return projectPage;
    }

    @Step("Check if procedure is successful")
    public boolean isSuccess() {
        ProjectPage projectPage = new ProjectPage();
        return projectPage.isSuccessMessageDisplayed();
    }

    @Step("Check if project is deleted")
    public boolean isProjectDeleted(String projectName) {
        ProjectPage projectPage = new ProjectPage();
        return projectPage.isProjectNotFound(projectName);
    }

    @Step("Click 'Add milestone' button")
    public MilestonePageService clickAddMilestoneButton(){
        ProjectPage projectPage = new ProjectPage();
        projectPage.clickAddMilestoneButton();
        return new MilestonePageService();
    }
    @Step("Click 'View All' button")
    public TestCasePageService clickViewAllButton(){
        ProjectPage projectPage = new ProjectPage();
        projectPage.clickViewAllButton();
        return new TestCasePageService();
    }
}
