package api.adapters;

import api.models.Milestone;
import io.restassured.response.Response;

public class MilestoneAdapter extends BaseAdapter {

    private static final String ADD_MILESTONE_API_ENDPOINT = "api/v2/add_milestone/%d";
    private static final String GET_MILESTONES_API_ENDPOINT = "api/v2/get_milestones/%d";
    private static final String DELETE_MILESTONE_API_ENDPOINT = "api/v2/delete_milestone/%d";

    public Response addMilestone(int projectId, Milestone milestone) {
        return post(String.format(ADD_MILESTONE_API_ENDPOINT, projectId), converter.toJson(milestone));
    }

    public Response getMilestones(int projectId) {
        return get(String.format(GET_MILESTONES_API_ENDPOINT, projectId));
    }

    public Response deleteMilestone(int milestoneId) {
        return delete(String.format(DELETE_MILESTONE_API_ENDPOINT, milestoneId));
    }

    public int getMilestoneIdByName(int projectId, String milestoneName) {
        return get(String.format(GET_MILESTONES_API_ENDPOINT, projectId)).jsonPath().
                getInt(String.format("milestones.find { it.name == '%s' }.id", milestoneName));
    }
}
