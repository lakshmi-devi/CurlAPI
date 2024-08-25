package com.turtlemint;

import Assertions.ValidatePincodeAssertion;
import base.HeadersList;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.PostRequestBody;
import utility.StatusCodes;

import java.util.ArrayList;
import java.util.List;

import static com.turtlemint.CreateRequest.printResponseLogInReport;
import static io.restassured.RestAssured.given;

public class ValidatepinCode {

    RequestSpecification requestSpec;
    CreateRequest createRequest = new CreateRequest();
    JsonPath jsonPath;
    HeadersList headersListObj = new HeadersList();

    @Test
    public void validatePinCode() {

        PostRequestBody requestBody = new PostRequestBody();
        List<String> pinCodes = new ArrayList<>();
        pinCodes.add("411030");
        requestBody.setPincodes(pinCodes);
        requestSpec = createRequest.getRequestParams(headersListObj.headerList("35dc52c1abc970c7"));
        Response response =  given()
                .spec(requestSpec)
                .when()
                .body(requestBody)
                .post("/validatepincode");
        ValidatePincodeAssertion.ValidatePincodeAssertion(response);

        System.out.println("validatepincode response" + " ======="  +response.getBody().asString());
        printResponseLogInReport(response);

    }

}
