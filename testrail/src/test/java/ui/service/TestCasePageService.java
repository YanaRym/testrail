package ui.service;

import io.qameta.allure.Step;
import ui.models.Project;
import ui.pages.TestCasePage;

public class TestCasePageService {

    private final TestCasePage testCasePage = new TestCasePage();

    @Step("Add section")
    public TestCasePageService addSection(Project project) {
        testCasePage.clickAddSectionButton()
                .fillInSectionNameField(project.getSectionName())
                .fillInSectionDescriptionField(project.getSectionDescription())
                .confirmNewSection();
        return this;
    }

    @Step("Add new test case")
    public ProjectPageService addTestCase(Project project) {
        testCasePage.clickAddTestCaseButton()
                .chooseSection(project.getSectionName())
                .chooseTemplate(project.getTestCaseTemplate())
                .chooseType(project.getTestCaseType())
                .choosePriority(project.getTestCasePriority())
                .fillInTestCaseTitleField(project.getTestCaseTitle())
                .clickSubmitTestCase();
        return new ProjectPageService();
    }
}
