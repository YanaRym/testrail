package ui.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
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
    }

    @BeforeMethod()
    public void logIn() {
        User user = User.builder()
                .email(DEFAULT_EMAIL)
                .password(DEFAULT_PASSWORD)
                .build();
        loginPageService.loginWithKeepMeLogged(user);
    }

    @Test(priority = 1, description = "This test creates milestone")
    @Description(value = "Create milestone")
    public void createMilestoneTest() {
        Project project = Project.builder()
                .projectName(DEFAULT_NEW_PROJECT_NAME)
                .milestoneName(DEFAULT_MILESTONE_NAME)
                .milestoneReference(DEFAULT_MILESTONE_REFERENCE)
                .milestoneDescription(DEFAULT_MILESTONE_DESCRIPTION)
                .build();
        dashboardPageService.goToProjectInfo(project.getProjectName())
                .addMilestone()
                .fillInMilestoneInfo(project);
        Assert.assertTrue(projectPageService.isSuccess(), "Creation of milestone failed.");
    }

    @Test(priority = 2, description = "This test creates new test case in a new test section")
    @Description(value = "Create new test case in a new section")
    public void createNewTestCaseTest() {
        Project project = Project.builder()
                .projectName(DEFAULT_NEW_PROJECT_NAME)
                .sectionName(DEFAULT_TEST_CASE_SECTION_NAME)
                .sectionDescription(DEFAULT_TEST_CASE_SECTION_DESCRIPTION)
                .testCaseTitle(DEFAULT_TEST_CASE_TITLE)
                .testCaseTemplate(DEFAULT_TEST_CASE_TEMPLATE)
                .testCaseType(DEFAULT_TEST_CASE_TYPE)
                .testCasePriority(DEFAULT_TEST_CASE_PRIORITY)
                .build();
        dashboardPageService.goToProjectInfo(project.getProjectName())
                .viewAllTestCases()
                .addSection(project)
                .addTestCase(project);
        Assert.assertTrue(projectPageService.isSuccess());
    }

    @Test(priority = 3, description = "This test completes project")
    @Description(value = "Mark project as complete")
    public void completeProjectTest() {
        dashboardPageService.goToProjectInfo(DEFAULT_NEW_PROJECT_NAME)
                .editProject();
        Assert.assertTrue(projectPageService.isSuccess(),
                "Project completion failed.");
    }
}
