package za.co.commandquality.AssetManagement.controllerTests;

import java.util.ArrayList;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.*;
import io.restassured.http.Method;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import io.restassured.response.ResponseBody;
import static org.junit.jupiter.api.Assertions.*;
import za.co.commandquality.AssetManagement.models.user.User;
import static org.assertj.core.api.Assertions.assertThat;
import io.restassured.specification.RequestSpecification;


//@ExtendWith( MockitoExtension.class )
public class UserControllerTest {
    private static Response response;
    private static String baseurl;
    private static int statusCode;
    private static String responseContentType;
    private static ResponseBody responseBody;
    private static RequestSpecification httpRequestObject;
//    @Mock
//    private static UserDao userDao;
//    @InjectMocks
//    private static UserService userService;
//    @Autowired
//    private static UserController userController;
    private static ArrayList < User > userArrayList;
    String id;

    @BeforeAll
    static void setup() {
        baseurl = (baseURI = "http://127.0.0.1:9090/");
        httpRequestObject = given();
        response = httpRequestObject.request( Method.GET, "api" );
        responseContentType = response.getContentType();
        statusCode = response.getStatusCode();
        response = ( Response ) response.getBody();
    }

    @AfterAll
    static void tearDown() {
//        userService = null;
//        userController = null;
//        userDao = null;
        baseurl = null;
        httpRequestObject = null;
        response = null;
        responseContentType = null;
        statusCode = 0;
        responseBody = null;
    }

    @Test
    void create() {

        httpRequestObject.given();
        JSONObject requestParams =new JSONObject();
        requestParams.put( "name","MOkoolo" );
        requestParams.put( "lastname","Moloto" );

        //specifying content type for post request as json
        httpRequestObject.header( "Content-Type","application/json" );

        //adding the request params to the http post request body
        httpRequestObject.body( requestParams.toJSONString() );
        response=httpRequestObject.request(Method.POST,"api/");
        responseBody=response.getBody();
        statusCode=response.getStatusCode();
        String statusLine=response.statusLine();
        assertEquals(responseBody.asString(),"1");
        assertEquals(statusCode,200);
        assertThat(statusLine);
        response.then().assertThat().contentType("application/json"  );
    }

    @Test
    void read() throws IOException {
        httpRequestObject=given();
        response=httpRequestObject.request(Method.GET,"api");
        userArrayList= response.body().as( new ArrayList<>().getClass() );

        //using assertj dependency 'static method'
        assertThat( (response.body().as( ArrayList.class ).stream().toList().get( 0 )) );
        assertEquals(response.statusCode(),200);
        assertThat(response.statusLine()=="HTTP/1.1 200");
        assertThat( userArrayList.size()>=10 );
    }

    @Test
    void displayTableInDescendingOrder() {
        httpRequestObject=given();
        response=httpRequestObject.request(Method.GET,"api/descending") ;
        statusCode=response.getStatusCode() ;
        String statusLine=response.statusLine();

        response.then().contentType( "application/json" ).assertThat();
        assertEquals(response.statusCode(),200);
        assertThat(  response.getStatusLine().matches("HTTP/1.1 200"));
    }

    @Test
    void displayTableInAscendingOrder() {
        httpRequestObject=given();
        httpRequestObject.request(Method.GET,"api/ascending").then().assertThat().statusCode( 200 );
        response=httpRequestObject.request(Method.GET,"api/ascending");
        response.then().contentType( "application/json" ).assertThat();
        assertEquals(response.statusCode(),200);
        assertThat(response.statusLine());
    }

    @Test
    void readById() {
        String userID="7c861e60-6832-4d89-b0e1-6ee27f55eba4";
        String userById_E_P= String.valueOf( baseurl.concat( "api" )+"/"+userID);
        assertThat(httpRequestObject.request( Method.GET, userById_E_P ).then().assertThat().statusCode( 200 ));
        response=httpRequestObject.request( Method.GET, userById_E_P );
    }

    @Test
    void update() {

    }

    @Test
    void deleteById() {
        httpRequestObject.given();

        JSONObject jsonObject=new JSONObject();

        httpRequestObject.header( "Content-Type","application/json" );
        response=httpRequestObject.request(Method.DELETE,"api/0accbae8-3554-4c7a-91fc-8b2d46f4ef83");
        System.out.println(response.getBody().asString());
        //adding the request params to the http post request body
//        httpRequestObject.body( jsonObject.toJSONString() );
    }

    @Test
    void deleteAll() {
    }
}