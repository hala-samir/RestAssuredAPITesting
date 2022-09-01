import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BookingRequests{
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    @BeforeClass
    public void setupRequestSpecification(){
        requestSpecification = RestAssured.given();
        requestSpecification
                .log()
                .all()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("booking")
                .contentType(ContentType.JSON);

        responseSpecification = RestAssured.expect();
        responseSpecification.statusCode(200);
        responseSpecification.contentType(ContentType.JSON);
        responseSpecification.log().all();
        responseSpecification.time(Matchers.lessThan(3000L));
    }

    @Test
    public void createBooking(){
        RestAssured
                .given()
                    .spec(requestSpecification)
                    .basePath("booking")
                    .contentType(ContentType.JSON)
                    .body("{\n" +
                        "    \"firstname\" : \"Jim\",\n" +
                        "    \"lastname\" : \"Brown\",\n" +
                        "    \"totalprice\" : 111,\n" +
                        "    \"depositpaid\" : true,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"2018-01-01\",\n" +
                        "        \"checkout\" : \"2019-01-01\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\n" +
                        "}")
                .when()
                    .post()
                .then()
                   .spec(responseSpecification);
    }
    @Test
    public void updateBooking(){
        RestAssured.given()
                .spec(requestSpecification)
                .basePath("booking/108")
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .body("{\n" +
                        "    \"firstname\" : \"James\",\n" +
                        "    \"lastname\" : \"Brown\",\n" +
                        "    \"totalprice\" : 111,\n" +
                        "    \"depositpaid\" : true,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"2018-01-01\",\n" +
                        "        \"checkout\" : \"2019-01-01\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\n" +
                        "}")
                .when()
                    .put()
                .then()
                    .log()
                    .all()
                    .spec(responseSpecification);
    }
}
