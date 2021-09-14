package za.co.commandquality.AssetManagement;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;


public class RestControllerTest {
    @Autowired
    AssetManagementApplication assetManagementApplication;
    private static String url="http://127.0.0.1:9090/api";


    @BeforeSuite
    void Setup(){
        assetManagementApplication=new AssetManagementApplication();
    }

    @Test(priority = 2)
     void ObjectsTests(){
        Assertions.assertNotNull( assetManagementApplication );
    }





}
