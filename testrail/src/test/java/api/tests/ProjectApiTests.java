package api.tests;

import api.adapters.ProjectAdapter;
import api.models.Project;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static api.constants.ProjectsInfo.*;
import static java.net.HttpURLConnection.HTTP_OK;

@Story("Projects management")
public class ProjectApiTests {

    private ProjectAdapter projectAdapter;

    @BeforeClass
    public void setUp() {
        projectAdapter = new ProjectAdapter();
    }

    @Test(description = "This test gets specific project")
    @Description(value = "Get specific project")
    public void checkStatusCodeOfGettingProjectTest() {
        int statusCode = projectAdapter.getSpecificProject(2).statusCode();
        Assert.assertEquals(statusCode, HTTP_OK,
                "Failed to get the project.");
    }

    @Test(description = "This test gets all projects")
    @Description(value = "Get all projects")
    public void checkStatusCodeOfGettingAllProjects() {
        int statusCode = projectAdapter.getAllProjects().statusCode();
        Assert.assertEquals(statusCode, HTTP_OK,
                "Failed to get projects.");
    }

    @Test(description = "This test adds new project")
    @Description(value = "Add new project")
    public void checkNewProjectCanBeAddedTest() {
        Project project = Project.builder()
                .name(DEFAULT_NEW_PROJECT_NAME)
                .announcement(DEFAULT_PROJECT_ANNOUNCEMENT)
                .showAnnouncement(true)
                .build();
        int statusCode = projectAdapter.addProject(project).statusCode();
        Assert.assertEquals(statusCode, HTTP_OK,
                "Failed to add new project.");
    }

    @Test(description = "This test deletes project", dependsOnMethods = "checkNewProjectCanBeAddedTest")
    @Description(value = "Delete project")
    public void checkProjectCanBeDeletedTest() {
        Project project = Project.builder()
                .name("Test API project").build();
        int id = projectAdapter.getProjectIdByName(project.getName());
        int statusCode = projectAdapter.deleteProject(id).statusCode();
        Assert.assertEquals(statusCode, HTTP_OK,
                "Failed to delete the project");
    }
}
