package api.tests;

import api.adapters.MilestoneAdapter;
import api.models.Milestone;
import org.testng.Assert;
import org.testng.annotations.Test;


import static api.constants.ProjectsInfo.DEFAULT_MILESTONE_START_DATE;
import static api.constants.ProjectsInfo.DEFAULT_PROJECT_ID;
import static java.net.HttpURLConnection.HTTP_OK;

public class MilestoneTests {

    @Test
    public void addMilestoneTest() {
        Milestone milestone = Milestone.builder()
                .name("Planning phase")
                .description("This milestone marks planning phase")
                .startOn(DEFAULT_MILESTONE_START_DATE)
                .build();
        int statusCode = new MilestoneAdapter().addMilestone(DEFAULT_PROJECT_ID, milestone).statusCode();
        Assert.assertEquals(statusCode, HTTP_OK);
    }

    @Test
    public void getMilestonesTest() {
        int statusCode = new MilestoneAdapter().getMilestones(DEFAULT_PROJECT_ID).statusCode();
        Assert.assertEquals(statusCode, HTTP_OK);
    }

    @Test
    public void deleteMilestoneTest() {
        int statusCode = new MilestoneAdapter().deleteMilestone(326).statusCode();
        Assert.assertEquals(statusCode, HTTP_OK);
    }
}
