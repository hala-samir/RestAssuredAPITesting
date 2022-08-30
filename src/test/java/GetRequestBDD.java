import io.restassured.RestAssured;
import org.hamcrest.Matchers;

public class GetRequestBDD {
    public static void main(String[] args){
        //example 1
//        RestAssured.given()
//                .baseUri("https://simple-books-api.glitch.me/")
//                .when()
//                .get("books/2")
//                .then().statusCode(200).and().contentType("application/json; charset=utf-8");

        RestAssured.given()
                .baseUri("https://reqres.in")
                .basePath("/api/")
                .queryParam("page",2 )
                .when()
                .get("users")
                .then().statusCode(200).and().body("page", Matchers.equalTo(2))
                .body("data.id", Matchers.hasSize(6));
    }
}
