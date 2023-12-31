package ui.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.models.Project;
import ui.models.User;
import ui.service.*;

import static ui.constatns.DefaultProjectInfo.*;
import static ui.constatns.DefaultProjectInfo.DEFAULT_MILESTONE_DESCRIPTION;
import static ui.constatns.DefaultUserInfo.DEFAULT_EMAIL;
import static ui.constatns.DefaultUserInfo.DEFAULT_PASSWORD;

@Story(value = "Project page")
public class ProjectPageTest extends BaseTest {

    private DashboardPageService dashboardPageService;
    private ProjectPageService projectPageService;
    private LoginPageService loginPageService;

    @BeforeClass()
    public void setUp() {
        dashboardPageService = new DashboardPageService();
        projectPageService = new ProjectPageService();
        loginPageService = new LoginPageService();
        User user = User.builder()
                .email(DEFAULT_EMAIL)
                .password(DEFAULT_PASSWORD)
                .build();
        loginPageService.loginWithKeepMeLogged(user);
    }

    @Test(priority = 1, description = "This test creates milestone")
    @Description(value = "Create milestone")
    public void checkMilestoneCanBeAddedTest() {
        Project project = Project.builder()
                .projectName(DEFAULT_PROJECT_NAME)
                .milestoneName(DEFAULT_MILESTONE_NAME)
                .milestoneReference(DEFAULT_MILESTONE_REFERENCE)
                .milestoneDescription(DEFAULT_MILESTONE_DESCRIPTION)
                .build();
        dashboardPageService.open()
                .goToProjectInfo(project.getProjectName())
                .addMilestone()
                .fillInMilestoneInfo(project);
        Assert.assertTrue(projectPageService.isSuccess(), "Creation of milestone failed.");
    }

    @Test(priority = 2, description = "This test creates new test case in a new test section")
    @Description(value = "Create new test case in a new section")
    public void checkNewTestCaseCanBeAddedTest() {
        Project project = Project.builder()
                .projectName(DEFAULT_PROJECT_NAME)
                .sectionName(DEFAULT_TEST_CASE_SECTION_NAME)
                .sectionDescription(DEFAULT_TEST_CASE_SECTION_DESCRIPTION)
                .testCaseTitle(DEFAULT_TEST_CASE_TITLE)
                .testCaseTemplate(DEFAULT_TEST_CASE_TEMPLATE)
                .testCaseType(DEFAULT_TEST_CASE_TYPE)
                .testCasePriority(DEFAULT_TEST_CASE_PRIORITY)
                .build();
        dashboardPageService.open()
                .goToProjectInfo(project.getProjectName())
                .viewAllTestCases()
                .addSection(project)
                .addTestCase(project);
        Assert.assertTrue(projectPageService.isSuccess());
    }

    @Test(priority = 3, description = "This test creates new test run")
    @Description(value = "Create new test run")
    public void checkNewTestRunCanBeAddedTest() {
        Project project = Project.builder()
                .projectName(DEFAULT_PROJECT_NAME)
                .milestoneName(DEFAULT_MILESTONE_NAME)
                .testRunDescription(DEFAULT_TEST_RUN_DESCRIPTION)
                .testCaseTitle(DEFAULT_TEST_CASE_TITLE)
                .build();
        dashboardPageService.open()
                .goToProjectInfo(project.getProjectName())
                .clickAddTestRun()
                .addTTestRun(project);
        Assert.assertTrue(projectPageService.isSuccess());

    }

    @Test(priority = 4, description = "This test completes project")
    @Description(value = "Mark project as complete")
    public void checkProjectCanBeMarkedAsCompleteTest() {
        dashboardPageService.open()
                .goToProjectInfo(DEFAULT_PROJECT_NAME)
                .editProject();
        Assert.assertTrue(projectPageService.isSuccess(),
                "Project completion failed.");
    }
}
