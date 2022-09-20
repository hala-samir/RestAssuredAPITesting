import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class JSONpath {
    @Test
    public void jsonPath(){
        String object = "{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Brown\"\n" +
                "}";
        JsonPath jpath = new JsonPath(object);
        String firstname = jpath.getString("firstname");
        System.out.println(firstname);
        String name = jpath.get("firstname");
        System.out.println(name);
        System.out.println((Object) jpath.get("$"));
        System.out.println(jpath.getString("$"));
        System.out.println((Object) jpath.get());
        System.out.println(jpath.getString(""));

    }
}
