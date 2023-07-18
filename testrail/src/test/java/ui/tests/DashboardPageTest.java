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

import static ui.constatns.DefaultProjectInfo.DEFAULT_EXAMPLE_PROJECT_NAME;
import static ui.constatns.DefaultProjectInfo.DEFAULT_PROJECT_NAME;
import static ui.constatns.DefaultUserInfo.DEFAULT_EMAIL;
import static ui.constatns.DefaultUserInfo.DEFAULT_PASSWORD;

@Story(value  = "Dashboard page")
public class DashboardPageTest extends BaseTest {

    private DashboardPageService dashboardPageService;
    private LoginPageService loginPageService;
    private AddProjectFieldsPageService addProjectPageService;
    private AddExampleProjectFieldsPageService exampleProjectPageService;

    @BeforeClass()
    public void setUp() {
        loginPageService = new LoginPageService();
        dashboardPageService = new DashboardPageService();
        addProjectPageService = new AddProjectFieldsPageService();
        exampleProjectPageService = new AddExampleProjectFieldsPageService();

    }

    @BeforeMethod()
    public void login() {
        User user = User.builder()
                .email(DEFAULT_EMAIL)
                .password(DEFAULT_PASSWORD)
                .build();
        loginPageService.loginWithKeepMeLogged(user);
    }

//    @Test(description = "This test adds project form Dashboard")
//    @Description(value = "Add example project from Dashboard")
//    public void addExampleProjectFromDashboardTest() {
//        dashboardPageService.open()
//                .addExampleProject(DEFAULT_EXAMPLE_PROJECT_NAME);
//        Assert.assertTrue(exampleProjectPageService.isProjectCreated(DEFAULT_EXAMPLE_PROJECT_NAME),
//                "Example Project hasn't been added.");
//    }

    @Test(description = "This test adds example project form Dashboard")
    @Description(value = "Add new project from Dashboard")
    public void addProjectFromDashboardTest() {
        dashboardPageService.open()
                .addProject(DEFAULT_PROJECT_NAME);
        Assert.assertTrue(addProjectPageService.isProjectCreated(DEFAULT_PROJECT_NAME),
                "Project hasn't been added.");
    }

    @Test(description = "This test adds new project without name form Dashboard")
    @Description(value = "Add new project without name")
    public void addProjectFromDashboardWithoutNameTest() {
        Project project = Project.builder()
                .projectName("")
                .build();
        dashboardPageService.open()
                .addProject(project.getProjectName());
        Assert.assertTrue(addProjectPageService.isErrorMessageDisplayed(),
                "Error message isn't displayed.");
    }

}
