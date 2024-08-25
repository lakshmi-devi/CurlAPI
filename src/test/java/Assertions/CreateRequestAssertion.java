package Assertions;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import utility.StatusCodes;

public class CreateRequestAssertion {
    static JsonPath jsonPath;

    public static void createRequestAssertion(Response response) {
        jsonPath = response.jsonPath();
        int statusCode = jsonPath.get("successCode");
        String statusMsg = jsonPath.get("status");
        boolean majorHealthExpenses = jsonPath.get("data.needs.majorHealthExpenses");
        boolean requireMaternityVal = jsonPath.get("data.requireMaternity");
        boolean maternity = jsonPath.get("data.needs.maternity");
        boolean seniorCitizen = jsonPath.get("data.needs.seniorCitizen");
        boolean changeInsurer = jsonPath.get("data.needs.changeInsurer");
        boolean diseaseCover = jsonPath.get("data.needs.diseaseCover");
        boolean upgradeCover = jsonPath.get("data.needs.upgradeCover");
        boolean saveCompleteRequest = jsonPath.get("data.saveCompleteRequest");
        boolean preExistingDisease = jsonPath.get("data.preExistingDisease");
        boolean isReKycRequired = jsonPath.get("isReKycRequired");
        String responseDataType = jsonPath.get("responseDataType");
        String flowType = jsonPath.get("data.flowType");
        Assert.assertEquals(statusCode, StatusCodes.SUCCESS.code);
        Assert.assertEquals(statusMsg, "SUCCESS");
        Assert.assertTrue(majorHealthExpenses, "true");
        Assert.assertFalse(requireMaternityVal, "false");
        Assert.assertFalse(maternity, "false");
        Assert.assertFalse(seniorCitizen, "false");
        Assert.assertFalse(changeInsurer, "false");
        Assert.assertFalse(diseaseCover, "false");
        Assert.assertFalse(upgradeCover, "false");
        Assert.assertFalse(saveCompleteRequest, "false");
        Assert.assertFalse(preExistingDisease, "false");
        Assert.assertTrue(isReKycRequired, "true");
        Assert.assertEquals(responseDataType, "CUSTOM");
        Assert.assertEquals(flowType, "RESULT");
        System.out.println("CREATE REQUEST " + "========================" + "  " + response.getBody().asString());

    }
}
