package ui.service;

import io.qameta.allure.Step;
import ui.models.Project;
import ui.pages.TestCasePage;

public class TestCasePageService {

    @Step("Add section")
    public TestCasePageService addSection(Project project) {
        TestCasePage testCasePage = new TestCasePage();
        testCasePage.clickAddSectionButton()
                .fillInSectionNameField(project.getSectionName())
                .fillInSectionDescriptionField(project.getSectionDescription())
                .confirmNewSection();
        return this;
    }

    @Step("Add new test case")
    public ProjectPageService addTestCase(Project project) {
        TestCasePage testCasePage = new TestCasePage();
        testCasePage.clickAddTestCaseButton()
                .fillInTestCaseTitleField(project.getTestCaseTitle())
                .chooseSection(project.getSectionName())
                .chooseTemplate(project.getTestCaseTemplate())
                .chooseType(project.getTestCaseType())
                .choosePriority(project.getTestCasePriority())
                .clickSubmitTestCase();
        return new ProjectPageService();
    }
}
