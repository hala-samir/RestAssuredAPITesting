import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequestNonBDD {
    public static void main(String []args){
        /*
        RestAssured.baseURI="https://simple-books-api.glitch.me/books/2";
        RequestSpecification req = RestAssured.given();
        Response res = req.get();
        JsonPath path = res.jsonPath();
        System.out.println(path.prettify());
        */
        RestAssured.baseURI = "https://reqres.in/api/users";
        RequestSpecification req = RestAssured.given();
        req.queryParam("page", 2);
        Response res = req.get();


    }
}
