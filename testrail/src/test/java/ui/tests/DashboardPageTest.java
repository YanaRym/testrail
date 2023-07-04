package ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.models.Project;
import ui.models.User;
import ui.pages.ExampleProjectPage;
import ui.service.AddProjectPageService;
import ui.service.DashboardPageService;
import ui.service.LoginPageService;

public class DashboardPageTest extends BaseTest {

    private DashboardPageService dashboardPageService;
    private LoginPageService loginPageService;
    private AddProjectPageService addProjectPageService;

    @BeforeClass()
    public void setUp() {
        loginPageService = new LoginPageService();
        dashboardPageService = new DashboardPageService();
        addProjectPageService = new AddProjectPageService();

    }

    @BeforeMethod()
    public void login() {
        User user = User.builder()
                .email("yvukac@mailto.plus")
                .password("4444Jane!")
                .build();
        loginPageService.loginWithKeepMeLogged(user);
    }

    @Test
    public void addProjectTest() {
        Project project = Project.builder()
                .projectName("Test Project 7")
                .build();
        dashboardPageService.addProject(project);
        Assert.assertTrue(addProjectPageService.isProjectCreated(project));
    }

    @Test
    public void addProjectWithoutNameTest(){
        Project project = Project.builder()
                .projectName("")
                .build();
        dashboardPageService.addProject(project);
        Assert.assertTrue(addProjectPageService.isErrorMessageDisplayed());
    }

    @Test
    public void addExampleProjectTest() {
        Project project = Project.builder()
                .projectName("First project")
                .build();
        dashboardPageService.addExampleProject(project);
        ExampleProjectPage exampleProjectPage = new ExampleProjectPage();
        Assert.assertTrue(exampleProjectPage.isExampleProjectCreated(project));
    }
}
