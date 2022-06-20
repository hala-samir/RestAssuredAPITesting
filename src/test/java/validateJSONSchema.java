import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class validateJSONSchema {
    @Test
    public void getTest() {
        baseURI = "https://reqres.in/api/";
        given().
                get("/users?page=2").
        then().
                statusCode(200).
                assertThat().
                body(matchesJsonSchemaInClasspath("schema.json")).
                body("data[2].first_name", equalTo("Tobias")).
                body("data.first_name", hasItems("Lindsay", "Michael"));
    }
}