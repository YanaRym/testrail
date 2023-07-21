package ui.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.models.User;
import ui.service.*;

import static ui.constatns.DefaultProjectInfo.DEFAULT_NEW_PROJECT_NAME;
import static ui.constatns.DefaultUserInfo.DEFAULT_EMAIL;
import static ui.constatns.DefaultUserInfo.DEFAULT_PASSWORD;

@Story(value = "Dashboard page")
public class DashboardPageTest extends BaseTest {

    private DashboardPageService dashboardPageService;
    private LoginPageService loginPageService;
    private AddProjectFieldsPageService addProjectPageService;

    @BeforeClass()
    public void setUp() {
        loginPageService = new LoginPageService();
        dashboardPageService = new DashboardPageService();
        addProjectPageService = new AddProjectFieldsPageService();
    }

    @BeforeMethod()
    public void login() {
        User user = User.builder()
                .email(DEFAULT_EMAIL)
                .password(DEFAULT_PASSWORD)
                .build();
        loginPageService.loginWithKeepMeLogged(user);
    }

    @Test(description = "This test adds example project form Dashboard")
    @Description(value = "Add new project from Dashboard")
    public void checkProjectCanBeAddedFromDashboardTest() {
        dashboardPageService.open()
                .addProject(DEFAULT_NEW_PROJECT_NAME);
        Assert.assertTrue(addProjectPageService.isProjectCreated(DEFAULT_NEW_PROJECT_NAME),
                "Project hasn't been added.");
    }

    @Test(description = "This test adds new project without name form Dashboard")
    @Description(value = "Add new project without name")
    public void checkProjectCantBeAddedFromDashboardWithoutNameTest() {
        dashboardPageService.open()
                .addProject("");
        Assert.assertTrue(addProjectPageService.isErrorMessageDisplayed(),
                "Error message isn't displayed.");
    }
}
