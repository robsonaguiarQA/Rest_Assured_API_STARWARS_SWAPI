package tests;

import base.BaseTest;
import endpoints.UserEndpoint;
import org.junit.jupiter.api.Test;
import utils.VehiclesFactory;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class VehiclesTest extends BaseTest {

    @Test
    public void listarTodosVeiculos() {
        given()
                .when()
                .get(UserEndpoint.TODOS_VEICULOS)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void listarPrimeiroVeiculo() {
        given()
                .when()
                .get(UserEndpoint.PRIMEIRO_VEICULO)
                .then()
                .statusCode(200)
                .body("name", equalTo("Sand Crawler"))
                .body("model", equalTo("Digger Crawler"))
                .body("url", containsString("vehicles/4"))
                .log().all();
    }

    @Test
    public void listarUltimoVeiculo() {
        given()
                .when()
                .get(UserEndpoint.ULTIMO_VEICULO)
                .then()
                .statusCode(200)
                .body("name", equalTo("Sail barge"))
                .body("model", equalTo("Modified Luxury Sail Barge"))
                .body("url", containsString("vehicles/24"))
                .log().all();
    }
    @Test
    public void listarBodyCompletoUltimoVeiculo() {
        String expectedBody = VehiclesFactory.getExpectedBody();
        given()
                .when()
                .get(UserEndpoint.ULTIMO_VEICULO)
                .then()
                .statusCode(200)
                .body("", equalTo(io.restassured.path.json.JsonPath.from(expectedBody).getMap("")))
                .log().all();
    }
}