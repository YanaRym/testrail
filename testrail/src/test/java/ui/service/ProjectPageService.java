package ui.service;

import io.qameta.allure.Step;
import ui.pages.ProjectPage;

public class ProjectPageService {

    private final ProjectPage projectPage = new ProjectPage();

    @Step("Check if example project name is displayed")
    public boolean isExampleProjectNameDisplayed(String projectName) {
        return projectPage.isExampleProjectNameDisplayed(projectName);
    }

    @Step("Check if project name is displayed")
    public boolean isProjectNameDisplayed(String projectName) {
        return projectPage.isProjectNameDisplayed(projectName);
    }

    @Step("Edit project")
    public void editProject() {
        projectPage.clickEditButton()
                .checkCompleteCheckbox()
                .clickSaveButton();
    }

    @Step("Check if procedure is successful")
    public boolean isSuccess() {
        return projectPage.isSuccessMessageDisplayed();
    }

    @Step("Add milestone")
    public MilestonePageService addMilestone() {
        projectPage.clickAddMilestoneButton();
        return new MilestonePageService();
    }

    @Step("View All test cases")
    public TestCasePageService viewAllTestCases() {
        projectPage.clickViewAllButton();
        return new TestCasePageService();
    }

    @Step("Add test run")
    public TestRunPageService clickAddTestRun() {
        projectPage.clickAddTestRunButton();
        return new TestRunPageService();
    }
}
