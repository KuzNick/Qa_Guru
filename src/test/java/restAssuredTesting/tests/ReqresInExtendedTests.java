package restAssuredTesting.tests;

import org.junit.jupiter.api.Test;
import restAssuredTesting.model.LoginBodyModel;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.assertj.core.api.BDDAssumptions.given;
import static org.openqa.selenium.devtools.v133.audits.model.MixedContentResourceType.JSON;

public class ReqresInExtendedTests {
    LoginBodyModel bodyModel = new LoginBodyModel();
    bodyModel.


     @Test
     void loginTest() {
         given()
                 .log().uri()
                 .contentType(JSON)
                 .body(logopas)
                 .when()
                 .post("https://reqres.in/api/login")
                 .then()
                 .log().status()
                 .log().body()
                 .statusCode(200)
                 .body("token", is("QpwL5tke4Pnpja7X4"));

     }


    @Test
    void negativeLoginTest() {
        given()
                .log().uri()
                //.contentType(JSON)
                .body("1234")
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(400)
                .body("error", is("Missing email or username"));
    }
}
