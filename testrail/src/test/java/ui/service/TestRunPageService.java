package ui.service;

import io.qameta.allure.Step;
import ui.models.Project;
import ui.pages.TestRunPage;

public class TestRunPageService {

    @Step("Add new test run")
    public void addTTestRun(Project project) {
        TestRunPage testRunPage = new TestRunPage();
        testRunPage.chooseMilestone(project.getMilestoneName())
                .chooseUser()
                .fillInDescription(project.getTestRunDescription())
                .clickSpecificTestCasesButton()
                .clickChangeSelectionButton()
                .chooseTestCases(project.getTestCaseTitle())
                .clickOk()
                .confirmAdditionOfTestRun();
    }
}
