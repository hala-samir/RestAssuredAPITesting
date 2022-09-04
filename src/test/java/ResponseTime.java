import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ResponseTime {
    @Test
    public void checkResponseTime(){
        Response response = RestAssured
                .given()
                .log()
                .all()
                .baseUri("https://restful-booker.herokuapp.com/")
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
                .post();
        System.out.println("response time in millieseconds = "+response.time());
        System.out.println("response time in  millieseconds "+ response.getTime());
        System.out.println("response time in seconds = "+ response.timeIn(TimeUnit.SECONDS) );
        System.out.println("response time in seconds = "+ response.getTimeIn(TimeUnit.SECONDS) );
        response.then().time(Matchers.lessThan(8000L));
        response.then().time(Matchers.greaterThan(1000L));
        response.then()
                .time(Matchers
                        .both(Matchers.lessThan(4000L))
                        .and(Matchers.greaterThan(1000L))
                );
    }
}
