package tests;

import base.BaseTest;
import endpoints.UserEndpoint;
import org.junit.jupiter.api.Test;
import utils.PlanetsFactory;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PlanetsTest extends BaseTest {
    @Test
    public void listarTodosPlanetas() {
        given()
                .when()
                .get(UserEndpoint.TODOS_PLANETAS)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void validaPrimeiroPlaneta() {
        given()
                .when()
                .get(UserEndpoint.PRIMEIRO_PLANETA)
                .then()
                .statusCode(200)
                .body("name", equalTo("Tatooine"))
                .body("rotation_period", notNullValue())
                .body("url", containsString("planets/1"))
                .log().all();
    }

    @Test
    public void validaUltimoPlaneta() {
        given()
                .when()
                .get(UserEndpoint.ULTIMO_PLANETA)
                .then()
                .statusCode(200)
                .body("name", equalTo("Kamino"))
                .body("rotation_period", notNullValue())
                .body("url", containsString("planets/10"))
                .log().all();
    }

    @Test
    public void validaBodyCompletoUltimoPlaneta() {
        String expectedBody = PlanetsFactory.getExpectedBody();
        given()
                .when()
                .get(UserEndpoint.ULTIMO_PLANETA)
                .then()
                .statusCode(200)
                .body("", equalTo(io.restassured.path.json.JsonPath.from(expectedBody).getMap("")))
                .log().all();
    }
}