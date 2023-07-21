package ui.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.*;
import ui.models.User;
import ui.service.AdminPageService;
import ui.service.DashboardPageService;
import ui.service.LoginPageService;
import ui.service.ProjectPageService;


import static ui.constatns.DefaultProjectInfo.DEFAULT_EXAMPLE_PROJECT_NAME;
import static ui.constatns.DefaultProjectInfo.DEFAULT_NEW_PROJECT_NAME;
import static ui.constatns.DefaultUserInfo.DEFAULT_EMAIL;
import static ui.constatns.DefaultUserInfo.DEFAULT_PASSWORD;

@Story(value = "Administration page")
public class AdminPageTest extends BaseTest {

    private DashboardPageService dashboardPageService;
    private LoginPageService loginPageService;
    private AdminPageService adminPageService;
    private ProjectPageService projectPageService;


    @BeforeClass()
    public void setUp() {
        loginPageService = new LoginPageService();
        dashboardPageService = new DashboardPageService();
        adminPageService = new AdminPageService();
        projectPageService = new ProjectPageService();
    }

    @BeforeMethod()
    public void login() {
        User user = User.builder()
                .email(DEFAULT_EMAIL)
                .password(DEFAULT_PASSWORD)
                .build();
        loginPageService.loginWithKeepMeLogged(user);
        dashboardPageService.goToAdminPage()
                .goToProjectDirectory();
    }

    @Test(priority = 1, description = "This test adds project form Administration")
    @Description(value = "Add new project from Administration")
    public void checkProjectCanBeAddedFromAdminPageTest() {
        adminPageService.addProject(DEFAULT_NEW_PROJECT_NAME);
        Assert.assertTrue(projectPageService.isProjectNameDisplayed(DEFAULT_NEW_PROJECT_NAME),
                "Project hasn't been added.");
    }

    @Test(priority = 2, description = "This test adds example project form Administration")
    @Description(value = "Add new example project from Administration")
    public void checkExampleProjectCanBeAddedFromAdminPageTest() {
        adminPageService.addExampleProject(DEFAULT_EXAMPLE_PROJECT_NAME);
        Assert.assertTrue(projectPageService.isExampleProjectNameDisplayed(DEFAULT_EXAMPLE_PROJECT_NAME),
                "Example Project hasn't been added.");
    }


    @Test(priority = 3, dependsOnMethods = "checkExampleProjectCanBeAddedFromAdminPageTest", description = "This test deletes project")
    @Description(value = "Delete the project from Administration")
    public void CheckProjectCanBeDeletedTest() {
        adminPageService.clickDeleteProject(DEFAULT_EXAMPLE_PROJECT_NAME)
                .confirmDeletion(DEFAULT_EXAMPLE_PROJECT_NAME)
                .clickOkButton(DEFAULT_EXAMPLE_PROJECT_NAME);
        Assert.assertTrue(projectPageService.isSuccess(),
                "Project hasn't been deleted.");
    }
}

