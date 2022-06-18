import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetPostTest {
    @Test
    public void getTest(){
        baseURI = "https://reqres.in/api/";
        given().
                get("/users?page=2").
        then().
                statusCode(200).
                body("data[2].first_name",equalTo("Tobias")).
                body("data.first_name",hasItems("Lindsay","Michael"));

    }
    @Test
    public void postTest(){
        baseURI = "https://reqres.in/api/";
        //post request data using a map
//        Map<String,Object>map=new HashMap<String,Object>();
//        map.put("name","morpheus");
//        map.put("job","leader");
//        System.out.println(map);
//        JSONObject request= new JSONObject(map);
        JSONObject request= new JSONObject();
        request.put("name","morpheus");
        request.put("job","leader");
        System.out.println(request.toJSONString());
        given().
                body(request.toJSONString()).
        when().
                post("/api/users").
        then().
                statusCode(201);
    }
}
