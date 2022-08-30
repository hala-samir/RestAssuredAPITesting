import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestOne {
    @Test
    public void test_1() {
        Response r;
        baseURI = "https://reqres.in/api";
        r = get("users?page=2");
        System.out.println(r.statusCode());
        System.out.println(r.getTime());
        System.out.println(r.getBody().asString());
        Assert.assertEquals(r.getStatusCode(), 200);
    }

    @Test
    public void test_2() {
        baseURI = "https://reqres.in/api";
        given().
                get("users?page=2").
        then(). 
                statusCode(200).
                body("data.id[1]", equalTo(8));
    }
}