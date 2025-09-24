package endpoints;

import base.BaseTest;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserEndpoint extends BaseTest {

    private static final String USERS = "/users";

    public static Response getUser(int id) {
        return given()
                .spec(BaseTest.requestSpec)
                .pathParam("id", id)
                .when()
                .get(USERS + "/{id}");
    }

}
