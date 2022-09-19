import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class GetBookingsUsingTestBase extends TestBase  {
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
