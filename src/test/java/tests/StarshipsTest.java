package tests;

import base.BaseTest;
import endpoints.UserEndpoint;
import org.junit.jupiter.api.Test;
import utils.StarshipsFactory;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class StarshipsTest extends BaseTest {
    @Test
    public void listarTodasNaves() {
        given()
                .when()
                .get(UserEndpoint.TODAS_NAVES)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void validarPrimeiraNave() {
        given()
                .when()
                .get(UserEndpoint.PRIMEIRA_NAVE)
                .then()
                .body("name", equalTo("CR90 corvette"))
                .body("model", equalTo("CR90 corvette"))
                .body("url", containsString("starships/2"))
                .statusCode(200)
                .log().all();
    }

    @Test
    public void validarUltimaNave() {
        given()
                .when()
                .get(UserEndpoint.ULTIMA_NAVE)
                .then()
                .body("name", equalTo("Rebel transport"))
                .body("model", equalTo("GR-75 medium transport"))
                .body("url", containsString("starships/17"))
                .statusCode(200)
                .log().all();
    }

    @Test
    public void validarBodyCompletoUltimaNave() {
        String expectedBody = StarshipsFactory.getExpectedBody();
        given()
                .when()
                .get(UserEndpoint.ULTIMA_NAVE)
                .then()
                .statusCode(200)
                .body("", equalTo(io.restassured.path.json.JsonPath.from(expectedBody).getMap("")))
                .log().all();
    }
}