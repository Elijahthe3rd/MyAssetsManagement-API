package za.co.commandquality.AssetManagement.controllerTests;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import za.co.commandquality.AssetManagement.AssetManagementApplication;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

@ExtendWith( SpringExtension.class )
public class RestApiRunnerTest {
    @Autowired
    AssetManagementApplication assetManagementApplication;
    private static String url;


    @BeforeSuite
    void Setup(){
        assetManagementApplication=new AssetManagementApplication();
    }

    @Test(priority = 2)
     void ObjectsTests(){
        Assertions.assertNotNull( assetManagementApplication );
    }





}
