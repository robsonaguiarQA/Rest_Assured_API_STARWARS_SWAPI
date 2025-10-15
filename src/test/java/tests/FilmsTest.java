package tests;

import base.BaseTest;
import endpoints.UserEndpoint;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class FilmsTest extends BaseTest {
    @Test
    public void listarTosdosFilmes(){
        given()
                .when()
                .get(UserEndpoint.TODOS_FILMES)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void listarPrimeiroFilmes(){
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
    public void listarUltimoFilmes(){
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

}