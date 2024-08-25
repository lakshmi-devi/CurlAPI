package Assertions;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import utility.StatusCodes;

public class ValidatePincodeAssertion {

    static JsonPath jsonPath;

    public static void ValidatePincodeAssertion(Response response) {
        jsonPath = response.jsonPath();
        int statusCode = jsonPath.get("successCode");
        String statusMsg = jsonPath.get("status");
        String pincode = jsonPath.get("data.get(0).pincode");
        String latitude = jsonPath.get("data.get(0).latitude");
        String longitude = jsonPath.get("data.get(0).longitude");
        String status = jsonPath.get("data.get(0).status");
        String city = jsonPath.get("data.get(0).city");
        String state = jsonPath.get("data.get(0).state");
        String responseDataType = jsonPath.get("responseDataType");
        boolean isReKycRequired = jsonPath.get("isReKycRequired");

        Assert.assertEquals(statusCode, StatusCodes.SUCCESS.code);
        Assert.assertEquals(statusMsg, "SUCCESS");
        Assert.assertEquals(pincode, "411030");
        Assert.assertEquals(latitude, "18.510216");
        Assert.assertEquals(longitude, "73.8467105");
        Assert.assertEquals(status, "VALID");
        Assert.assertEquals(city, "Pune");
        Assert.assertEquals(state, "Maharashtra");
        Assert.assertEquals(responseDataType, "CUSTOM");
        Assert.assertTrue(isReKycRequired, "true");
    }
}
