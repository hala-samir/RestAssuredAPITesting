import io.restassured.RestAssured;
import io.restassured.config.HeaderConfig;
import io.restassured.config.RestAssuredConfig;
import org.testng.annotations.Test;

public class Headers {
    @Test
    public void headersTest(){
        RestAssured
                .given()
                .header("header1","value1","value2")
                .log()
                .all()
                .when()
                .get();
    }
    @Test
    public void overwriteHeaderValues(){
        RestAssured
                .given()
                .config(RestAssuredConfig.config()
                        .headerConfig(HeaderConfig
                                .headerConfig()
                                .overwriteHeadersWithName("header1", "header2")))
                .header("header1", "value1")
                .header("header1","value2")
                .header("header2","header21")
                .log()
                .all()
                .when()
                .get();
    }
}
