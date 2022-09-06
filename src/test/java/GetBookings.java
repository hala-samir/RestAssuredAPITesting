import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetBookings extends TestBase  {
    @Test
    public void testBookings() {
         RestAssured
                .given()
                 .get()
                 .then()
                 .log()
                 .all();
    }
}
