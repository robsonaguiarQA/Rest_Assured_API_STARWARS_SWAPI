package tests;

import base.BaseTest;
import endpoints.UserEndpoint;
import org.junit.jupiter.api.Test;
import utils.SpeciesFactory;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class SpeciesTest extends BaseTest {
    @Test
    public void listarTodasEspecies() {
        given()
                .when()
                .get(UserEndpoint.TODAS_ESPECIES)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void validarPrimeiraEspecie() {
        given()
                .when()
                .get(UserEndpoint.PRIMEIRA_ESPECIE)
                .then()
                .statusCode(200)
                .body("name", equalTo("Human"))
                .body("classification", equalTo("mammal"))
                .body("url", containsString("species/1"))
                .log().all();
    }

    @Test
    public void validarUltimaEspecie() {
        given()
                .when()
                .get(UserEndpoint.ULTIMA_ESPECIE)
                .then()
                .statusCode(200)
                .body("name", equalTo("Sullustan"))
                .body("classification", equalTo("mammal"))
                .body("url", containsString("species/10"))
                .log().all();
    }

    @Test
    public void validarBodyCompletoUltimaEspecie() {
        String expectedBody = SpeciesFactory.getExpectedBody();
        given()
                .when()
                .get(UserEndpoint.ULTIMA_ESPECIE)
                .then()
                .statusCode(200)
                .body("", equalTo(io.restassured.path.json.JsonPath.from(expectedBody).getMap("")))
                .log().all();
    }
}