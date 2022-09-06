import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetBookings extends TestBase  {
//    @BeforeTest
//    public void setup(){
//        RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
//        RestAssured.basePath = "booking";
//        System.out.println("in setup");
//    }
    @Test
    public void testBookings() {
        Response response = RestAssured
                .given().get();
        response.then().log().all();
    }
}
