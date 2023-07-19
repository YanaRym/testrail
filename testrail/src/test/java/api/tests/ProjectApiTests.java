package api.tests;

import api.adapters.ProjectAdapter;
import api.models.Project;
import org.testng.Assert;
import org.testng.annotations.Test;

import static api.constants.ProjectsInfo.*;
import static java.net.HttpURLConnection.HTTP_OK;

public class ProjectApiTests {


    @Test
    public void getProjectTest() {
        int statusCode = new ProjectAdapter().getSpecificProject(DEFAULT_PROJECT_ID).statusCode();
        Assert.assertEquals(statusCode, HTTP_OK);
    }

    @Test
    public void addNewProjectTest() {
        Project project = Project.builder()
                .name(DEFAULT_PROJECT_NAME)
                .announcement(DEFAULT_PROJECT_ANNOUNCEMENT)
                .showAnnouncement(true)
                .build();
        int statusCode = new ProjectAdapter().addProject(project).statusCode();
        Assert.assertEquals(statusCode, HTTP_OK);
    }

    @Test //?????????????????????????????????
    public void deleteProjectTest() {
        Project project = Project.builder()
                .name("Test project").build();
        int id = new ProjectAdapter().getId(project.getProjectId(), project);
        int statusCode = new ProjectAdapter().deleteProject(id).statusCode();
        Assert.assertEquals(statusCode, HTTP_OK);
    }
}
