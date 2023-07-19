package api.adapters;

import api.models.User;
import io.restassured.response.Response;

public class UserAdapter extends BaseAdapter {

    private static final String GET_USERS_API_ENDPOINT = "api/v2/get_users";
    private static final String GET_USER_BY_EMAIL_API_ENDPOINT = "api/v2/get_user_by_email&email=%s";
    private static final String ADD_USER_API_ENDPOINT = "api/v2/add_user";


    public Response getUsers() {
        return get(GET_USERS_API_ENDPOINT);
    }

    public Response getUserByEmail(String email) {
        return get(String.format(GET_USER_BY_EMAIL_API_ENDPOINT, email));
    }

    public Response addUser(User user) {
        return post(ADD_USER_API_ENDPOINT, converter.toJson(user));
    }
}
