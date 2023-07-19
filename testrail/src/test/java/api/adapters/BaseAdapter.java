package api.adapters;

import com.google.gson.Gson;
import io.restassured.response.Response;
import ui.models.Project;

import static io.restassured.RestAssured.given;
import static api.constants.ApiStringConstants.*;
import static org.hamcrest.Matchers.equalTo;

public class BaseAdapter {


    private static final String AUTHORIZATION = "Authorization";
    private static final String AUTHORIZATION_VALUE = "Basic c2Fsb3ZvNDczNkBuYXNza2FyLmNvbTowOTA2SmFuZSE=";
    private static final String BASE_URL = "https://qat3.testrail.io/index.php?/";


    protected Gson converter = new Gson();


    protected Response get(String url) {
        return
                given()
                        .header(AUTHORIZATION, AUTHORIZATION_VALUE)
                        .header(CONTENT_TYPE, JSON)
                        .when()
                        .get(BASE_URL + url)
                        .then()
                        .log().all()
                        .extract().response();
    }


    protected Response post(String url, String body) {
        return
                given()
                        .header(AUTHORIZATION, AUTHORIZATION_VALUE)
                        .header(CONTENT_TYPE, JSON)
                        .body(body)
                        .when()
                        .post(BASE_URL + url)
                        .then()
                        .log().all()
                        .extract().response();
    }

    protected Response delete(String url) {
        return
                given()
                        .header(AUTHORIZATION, AUTHORIZATION_VALUE)
                        .header(CONTENT_TYPE, JSON)
                        .when()
                        .post(BASE_URL + url)
                        .then()
                        .log().all()
                        .extract().response();
    }

    protected int getProjectId(String url, String projectName) {
        Response response =
        given()
                .header(AUTHORIZATION, AUTHORIZATION_VALUE)
                .header(CONTENT_TYPE, JSON)
                .log().all()
                .when()
                .get(BASE_URL + url)
                .then()
                .log().all()
                .extract().response();

        response.then().assertThat().body("name", equalTo(projectName));

        int projectId = response.path("project_id");

        return projectId;
    }
}
