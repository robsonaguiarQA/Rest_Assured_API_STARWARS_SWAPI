package tests;
import base.BaseTest;
import endpoints.UserEndpoint;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class SpeciesTest extends BaseTest {
    @Test
    public void listarTodasEspecies(){
        given()
                .when()
                .get(UserEndpoint.TODAS_ESPECIES)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void listarPrimeiraEspecie(){
        given()
                .when()
                .get(UserEndpoint.PRIMEIRA_ESPECIE)
                .then()
                .body("name", equalTo("Human"))
                .body("classification", equalTo("mammal"))
                .body("url", containsString("species/1"))
                .statusCode(200)
                .log().all();
    }

    @Test
    public void listarUltimaEspecie(){
        given()
                .when()
                .get(UserEndpoint.ULTIMA_ESPECIE)
                .then()
                .body("name", equalTo("Sullustan"))
                .body("classification", equalTo("mammal"))
                .body("url", containsString("species/10"))
                .statusCode(200)
                .log().all();
    }
}