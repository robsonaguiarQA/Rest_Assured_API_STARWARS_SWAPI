package base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.*;


public class BaseTest {

    protected static RequestSpecification requestSpec;

    @BeforeAll
    public static void setup() {
        baseURI = "https://jsonplaceholder.typicode.com"; // API fake test
        basePath = "/";

        requestSpec = new RequestSpecBuilder()
                .setContentType("application/json")
                .build();
    }
}
