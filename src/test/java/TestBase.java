import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {
    @BeforeTest
    public void setup(){
        RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
        RestAssured.basePath = "booking";
        System.out.println("in setup");
    }

}
