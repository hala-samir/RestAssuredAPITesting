import io.restassured.RestAssured;

public class GetBooking {
    public static void main(String[] args) {
        RestAssured.given().log().all()
               // .baseUri("https://restful-booker.herokuapp.com/")
               // .basePath("booking/{id}")
                //.pathParam("id", 10)
                .get("https://restful-booker.herokuapp.com/{booking}/{id}", "booking", 50)
                .then()
                .statusCode(200)
                .log().all();
    }

}
