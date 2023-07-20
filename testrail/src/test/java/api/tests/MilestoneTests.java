package api.tests;

import api.adapters.MilestoneAdapter;
import api.models.Milestone;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static api.constants.ProjectsInfo.DEFAULT_MILESTONE_START_DATE;
import static api.constants.ProjectsInfo.DEFAULT_PROJECT_ID;
import static java.net.HttpURLConnection.HTTP_OK;

@Story("Milestones management")
public class MilestoneTests {

    private MilestoneAdapter milestoneAdapter;

    @BeforeClass
    public void setUp() {
        milestoneAdapter = new MilestoneAdapter();
    }

    @Test(priority = 1, description = "This test adds new milestone")
    @Description(value = "Add new milestone")
    public void addMilestoneTest() {
        Milestone milestone = Milestone.builder()
                .name("Planning phase")
                .description("This milestone marks planning phase")
                .startOn(DEFAULT_MILESTONE_START_DATE)
                .build();
        int statusCode = new MilestoneAdapter().addMilestone(DEFAULT_PROJECT_ID, milestone).statusCode();
        Assert.assertEquals(statusCode, HTTP_OK,
                "Failed to add milestone.");
    }

    @Test(description = "This test gets all milestones")
    @Description(value = "Get all milestones")
    public void getMilestonesTest() {
        int statusCode = new MilestoneAdapter().getMilestones(DEFAULT_PROJECT_ID).statusCode();
        Assert.assertEquals(statusCode, HTTP_OK,
                "Failed to get milestones.");
    }

    @Test(priority = 2, description = "This test deletes milestone", dependsOnMethods = "addMilestoneTest")
    @Description("Delete milestone")
    public void deleteMilestoneTest() {
        Milestone milestone = Milestone.builder()
                .name("Planning phase").build();
        int id = milestoneAdapter.getMilestoneIdByName(DEFAULT_PROJECT_ID, milestone.getName());
        int statusCode = new MilestoneAdapter().deleteMilestone(id).statusCode();
        Assert.assertEquals(statusCode, HTTP_OK,
                "Failed to delete milestone.");
    }
}
