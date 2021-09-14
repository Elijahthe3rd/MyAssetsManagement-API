package za.co.commandquality.NewTests;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static io.restassured.RestAssured.*;

import static org.assertj.core.api.Assertions.assertThat;

public class Testings {


    private static Response response;
    private static String baseurl;
    private static int statusCode;
    private static String responseContentType;
    private static ResponseBody < Response > responseBody;
    private static RequestSpecification httpRequestObject;

    @BeforeClass
    void setup() {
        baseurl = (baseURI = "http://127.0.0.1:9090/");
        httpRequestObject = given();
        response = httpRequestObject.request( Method.GET,"api" );
        responseContentType = response.getContentType();
        statusCode = response.getStatusCode();
        responseBody = response.getBody();
    }

    @Test
    void contextLoads() {
        assertThat( response != null );
    }

    @Test
    void statusCodeTest() {
        if (!(statusCode < 200)) {
            Assertions.assertEquals( statusCode, 200 );

        }
    }

    @Test
    void ResponseBodyTest() {
        assertThat( responseBody );
        assertThat( response instanceof Response );
    }

    @Test
    void SwaggerApiDocResponseStatusCodeTest() {
        String swaggerApiDocEndPoint = baseurl.concat( "v2/api-docs" );
        httpRequestObject.get( swaggerApiDocEndPoint ).then().statusCode( 200 );
    }

    @Test
    void Swagger_ui_response_test() {
        String swagger_UI_Html_Url = baseurl.concat( "swagger-ui.html#/" );
        httpRequestObject.request( Method.GET, swagger_UI_Html_Url ).then().statusCode( 200 );

        /*
         *
         * other way to send a GET request
         *httpRequestObject.get(new String(swagger_UI_Html_Url)).then().statusCode( 200 );
         *
         */
    }

    @Test
    void getAllUserListTest() {
        String allUserUrl = baseurl.concat( "api" );
        response = httpRequestObject.request( Method.GET, allUserUrl );
        assertThat(httpRequestObject.request( Method.GET, allUserUrl ).then().assertThat().statusCode( 200 ));
        String responseBody = response.getBody()
                .asString()
                .replaceAll( "[\\[|\\]]", "" );

    }

    @Test
    void getUserByIdTest(){
        String userID="7c861e60-6832-4d89-b0e1-6ee27f55eba4";
        String userById_E_P= String.valueOf( baseurl.concat( "api" )+"/"+userID);
        assertThat(httpRequestObject.request( Method.GET, userById_E_P ).then().assertThat().statusCode( 200 ));
       response=httpRequestObject.request( Method.GET, userById_E_P );
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
    }

}
