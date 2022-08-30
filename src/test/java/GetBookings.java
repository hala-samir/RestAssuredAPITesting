import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetBookings {
    public static void main(String[] args) {
        Response response = RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com/booking").get();
        response.then().log().all();
    }
}
