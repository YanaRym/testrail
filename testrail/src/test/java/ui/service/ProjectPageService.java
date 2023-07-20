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
    public void editProject() {
        ProjectPage projectPage = new ProjectPage();
        projectPage.clickEditButton()
                .checkCompleteCheckbox()
                .clickSaveButton();
    }

    @Step("Check if procedure is successful")
    public boolean isSuccess() {
        ProjectPage projectPage = new ProjectPage();
        return projectPage.isSuccessMessageDisplayed();
    }

    @Step("Add milestone")
    public MilestonePageService addMilestone() {
        ProjectPage projectPage = new ProjectPage();
        projectPage.clickAddMilestoneButton();
        return new MilestonePageService();
    }

    @Step("View All test cases")
    public TestCasePageService viewAllTestCases() {
        ProjectPage projectPage = new ProjectPage();
        projectPage.clickViewAllButton();
        return new TestCasePageService();
    }

    @Step("Add test run")
    public TestRunPageService clickAddTestRun() {
        ProjectPage projectPage = new ProjectPage();
        projectPage.clickAddTestRunButton();
        return new TestRunPageService();
    }
}
