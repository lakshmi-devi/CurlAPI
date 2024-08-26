package com.turtlemint;

import Assertions.CreateRequestAssertion;
import base.EndPoints;
import base.HeadersList;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.Needs;
import pojo.PostRequestBody;
import base.BaseClass;
import resource.ExtentReportManager;
import utility.PropertyReader;
import utility.StatusCodes;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class CreateRequest extends BaseClass {
    RequestSpecification requestSpec;
    HeadersList headersListObj = new HeadersList();

    @Test
    public void createRequest() {
        Needs need = new Needs();
        need.setMajorHealthExpenses(true);
        PostRequestBody requestBody = new PostRequestBody();
        requestBody.setNeeds(need);
        requestSpec = getRequestParams(headersListObj.headerList("6d5925b49ac1fb94"));
              Response response=  given()
                      .spec(requestSpec)
                        .when()
                        .body(requestBody)
                        .post(EndPoints.createRequest);
        CreateRequestAssertion.createRequestAssertion(response);
//        System.out.println("CREATE REQUEST " + "========================" + "  " + response.getBody().asString());
        printResponseLogInReport(response);
    }


    public  RequestSpecification getRequestParams(Map<String,String> headerVal){
        String baseUri = PropertyReader.propertyReader("config.properties", "baseUri");
        String basePath = PropertyReader.propertyReader("config.properties", "basePath");
        requestSpec =  new RequestSpecBuilder()
                .setBaseUri(baseUri)
                .setBasePath(basePath)
                .addHeaders(headerVal)
                .build();
        return requestSpec;
    }

    public static void printResponseLogInReport(Response response){
        ExtentReportManager.logInfoDetails("Response status is" + " " + response.getStatusCode());
        ExtentReportManager.logInfoDetails("Response headers are" );
        ExtentReportManager.logHeaders(response.getHeaders().asList());
        ExtentReportManager.logInfoDetails("Response body is" );
        ExtentReportManager.logJson(response.getBody().prettyPrint());
    }


}
