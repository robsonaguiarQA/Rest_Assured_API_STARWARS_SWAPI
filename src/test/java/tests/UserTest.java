package tests;
import base.BaseTest;
import endpoints.UserEndpoint;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UserTest extends BaseTest {
    @Test
    public void listaTodosOsUsuarios() {
        given()
                .when()
                .get(UserEndpoint.TODOS_USUARIOS)
                .then()
                .statusCode(200)
                .log().all();
    }
    @Test
    public void validarPrimeiroUsuario() {
        given()
                .when()
                .get(UserEndpoint.PRIMEIRO_USUARIO)
                .then()
                .statusCode(200)
                .body("name", equalTo("Luke Skywalker"))
                .body("height", notNullValue())
                .body("url", containsString("people/1"))
                .log().all();
    }
    @Test
    public void validarUltimoUsuario() {
        given()
                .when()
                .get(UserEndpoint.ULTIMO_USUARIO)
                .then()
                .statusCode(200)
                .body("name", equalTo("Tion Medon"))
                .body("height", notNullValue())
                .body("url", containsString("people/83/"))
                .log().all();
    }
}