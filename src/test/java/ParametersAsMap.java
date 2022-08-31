import io.restassured.RestAssured;

import java.util.HashMap;
import java.util.Map;

public class ParametersAsMap {
    public static void main(String[] args) {
        Map<String, Object>parametersMap = new HashMap<>();
        parametersMap.put("basePath","booking");
        parametersMap.put("id",10);
        RestAssured.given()
                .get("https://restful-booker.herokuapp.com/{basePath}/{id}",parametersMap)
                .then().log().all();
    }
}
