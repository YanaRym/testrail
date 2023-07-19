package api.adapters;

import api.models.Project;
import io.restassured.response.Response;


public class ProjectAdapter extends BaseAdapter {

    private static final String GET_PROJECT_API_ENDPOINT = "api/v2/get_project/%d";

    private static final String ADD_PROJECT_API_ENDPOINT = "api/v2/add_project";

    private static final String DELETE_PROJECT_API_ENDPOINT = "api/v2/delete_project/%d";


    public Response getSpecificProject(int projectId) {
        return get(String.format(GET_PROJECT_API_ENDPOINT, projectId));
    }

    public Response addProject(Project project) {
        return post(ADD_PROJECT_API_ENDPOINT, converter.toJson(project));
    }

    public Response deleteProject(int projectId) {
        return delete(String.format(DELETE_PROJECT_API_ENDPOINT, projectId));
    }

    public int getId(int projectId, Project project) {
        return getProjectId(String.format(GET_PROJECT_API_ENDPOINT, projectId), project.getName());
    }
}
