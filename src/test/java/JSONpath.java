import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class JSONpath {
    @Test
    public void jsonPath(){
//        String object = "{\n" +
//                "    \"firstname\" : \"James\",\n" +
//                "    \"lastname\" : \"Brown\"\n" +
//                "}";
        String object = "{\n" +
                "  \"data\":{\n" +
                "    \"fname\":\"name1\",\n" +
                "    \"lname\": \"name2\",\n" +
                "    \"salary\": 10.5,\n" +
                "    \"married\": false\n" +
                "  }\n" +
                "}";
        JsonPath jpath = new JsonPath(object);
        String firstname = jpath.getString("data.fname");
        System.out.println(firstname);
        String name = jpath.get("data.fname");
        System.out.println(name);
        System.out.println((Object) jpath.get("$"));
        System.out.println(jpath.getString("$"));
        System.out.println((Object) jpath.get());
        System.out.println(jpath.getString(""));
        System.out.println((Object)jpath.get("data.fname"));
        float salary = jpath.getFloat("data.salary");
        System.out.println(salary);
        boolean married = jpath.getBoolean("data.married");
        System.out.println(married);

    }
}
