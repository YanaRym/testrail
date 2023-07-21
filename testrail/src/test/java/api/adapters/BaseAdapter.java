package api.adapters;

import com.google.gson.Gson;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static api.constants.ApiStringConstants.*;

public class BaseAdapter {


    private static final String AUTHORIZATION = "Authorization";
    private static final String AUTHORIZATION_VALUE = "Basic ZXlza3lxQG1haWx0by5wbHVzOmpzJSN6ZmgxMEE=";
    private static final String BASE_URL = "https://janefost.testrail.io/index.php?/";


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

}
