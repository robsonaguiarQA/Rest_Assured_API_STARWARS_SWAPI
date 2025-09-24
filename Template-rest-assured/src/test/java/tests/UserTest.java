package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;

import endpoints.UserEndpoint;

import static org.hamcrest.Matchers.*;

public class UserTest extends BaseTest {
    @Test
    public void validarUsuarioExistente() {
        UserEndpoint
                .getUser(1)
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("name", notNullValue());
    }
}
