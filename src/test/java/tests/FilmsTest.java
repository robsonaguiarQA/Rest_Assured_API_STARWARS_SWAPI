package tests;

import base.BaseTest;
import endpoints.UserEndpoint;
import org.junit.jupiter.api.Test;
import utils.FilmsFactory;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class FilmsTest extends BaseTest {
    @Test
    public void listarTosdosFilmes() {
        given()
                .when()
                .get(UserEndpoint.TODOS_FILMES)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void validarPrimeiroFilme() {
        given()
                .when()
                .get(UserEndpoint.PRIMEIRO_FILME)
                .then()
                .body("title", equalTo("A New Hope"))
                .body("episode_id", notNullValue())
                .body("url", containsString("films/1"))
                .statusCode(200)
                .log().all();
    }

    @Test
    public void validarUltimoFilme() {
        given()
                .when()
                .get(UserEndpoint.ULTIMO_FILME)
                .then()
                .body("title", equalTo("Revenge of the Sith"))
                .body("episode_id", notNullValue())
                .body("url", containsString("films/6"))
                .statusCode(200)
                .log().all();
    }

    @Test
    public void validarBodyCompletoUltimoFilme() {
        String expectedBody = FilmsFactory.getExpectedBody();
        given()
                .when()
                .get(UserEndpoint.ULTIMO_FILME)
                .then()
                .statusCode(200)
                .body("", equalTo(io.restassured.path.json.JsonPath.from(expectedBody).getMap("")))
                .log().all();
    }
}