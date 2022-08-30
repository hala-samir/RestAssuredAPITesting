import static  io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.http.ContentType;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SOAPXMLRequest {
    @Test
    public void validateSOAPxml() throws IOException {
        File file = new File("./Add.xml");
        FileInputStream ioFile= new FileInputStream(file);
        String requestBody = IOUtils.toString(ioFile,"UTF-8");
        baseURI= "http://www.dneonline.com/";

        given().
                contentType("text/xml").
                accept(ContentType.XML).
                body(requestBody).when().post("calculator.asmx").
        then().
                statusCode(200).log().all().
        and().
                body("//AddResult.text()", equalTo("2"));


    }
}
