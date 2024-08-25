package base;

import io.restassured.RestAssured;
import io.restassured.http.Cookies;
import org.testng.annotations.BeforeTest;

public class BaseClass {

    @BeforeTest
    public String getCookies() {
        Cookies cookies;

        RestAssured.baseURI = "https://pro.turtlemint.com";
        RestAssured.basePath = "api/health";
        cookies = RestAssured.given()
                .when()
                .body("{\"needs\":{\"majorHealthExpenses\":true}}")
                .post("/createrequest")
                .then()
                .extract()
                .response()
                .getDetailedCookies();
//        System.out.println("cookies" + cookies);
        return cookies.toString();
    }
}
