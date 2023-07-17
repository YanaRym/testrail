package ui.tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.*;
import ui.models.User;
import ui.service.AdminPageService;
import ui.service.DashboardPageService;
import ui.service.LoginPageService;
import ui.service.ProjectPageService;


import static ui.constatns.DefaultProjectInfo.DEFAULT_EXAMPLE_PROJECT_NAME;
import static ui.constatns.DefaultProjectInfo.DEFAULT_PROJECT_NAME;
import static ui.constatns.DefaultUserInfo.DEFAULT_EMAIL;
import static ui.constatns.DefaultUserInfo.DEFAULT_PASSWORD;

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

    @Test(priority = 2, description = "This test deletes project")
    @Description(value = "Delete the project from Administration")
    public void deleteProjectTest() {
        adminPageService.clickDeleteProject(DEFAULT_PROJECT_NAME)
                .confirmDeletion(DEFAULT_PROJECT_NAME)
                .clickOkButton(DEFAULT_PROJECT_NAME);
        Assert.assertTrue(projectPageService.isProjectDeleted(DEFAULT_PROJECT_NAME),
                "Project hasn't been deleted.");
    }

    @Test(priority = 1, description = "This test adds project form Administration")
    @Description(value = "Add new project from Administration")
    public void addProjectFromAdminPageTest() {
        adminPageService.addProject(DEFAULT_PROJECT_NAME);
        Assert.assertTrue(projectPageService.isProjectNameDisplayed(DEFAULT_PROJECT_NAME),
                "Project hasn't been added.");
    }

    @Test(description = "This test adds example project form Administration")
    @Description(value = "Add new example project from Administration")
    public void addExampleProjectFromAdminPageTest() {
        adminPageService.addExampleProject(DEFAULT_EXAMPLE_PROJECT_NAME);
        Assert.assertTrue(projectPageService.isExampleProjectNameDisplayed(DEFAULT_EXAMPLE_PROJECT_NAME),
                "Example Project hasn't been added.");
    }
}

