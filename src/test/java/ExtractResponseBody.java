import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ExtractResponseBody {
    public static void main(String[] args) {
        String response =
        RestAssured
                .given()
                     .baseUri("https://reqres.in/api/")
                    .basePath("users/2")
                    .log()
                    .all()
                    .contentType(ContentType.JSON)
                .when()
                    .get()
                .then()
                    .extract()
                    .body()
                    .asPrettyString();
        System.out.println(response);
    }
}
