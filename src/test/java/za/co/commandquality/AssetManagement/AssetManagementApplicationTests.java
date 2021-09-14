package za.co.commandquality.AssetManagement;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;


class AssetManagementApplicationTests {
    private static String responseContentType;
    private static Response response;
    private static ResponseBody < Response > responseBody;


    private static String url="127.0.0.1:9090/api";
    private static int statusCode;


    void setup() {
        response = get( url );
        responseContentType =  response.getContentType() ;
        statusCode = response.getStatusCode();
        responseBody = response.getBody();
    }

    void contextLoads() {
        assertThat( response!=null );
    }

    void statusCodeTest() {
        if (!(statusCode < 200)) {
            Assertions.assertEquals( statusCode, 200 );

        }
    }

    void ResponseBodyTest() {
        assertThat( responseBody);
        assertThat(response instanceof Response );

    }

}
