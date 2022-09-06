import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeTest;

public class TestBase {
    @BeforeTest
    public void setup(){
        RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
        RestAssured.basePath = "booking";
        System.out.println("in setup");
        RequestSpecification requestSpecification = RestAssured.given().log().all();
        ResponseSpecification responseSpecification = RestAssured.expect().statusCode(200);
    }
}
