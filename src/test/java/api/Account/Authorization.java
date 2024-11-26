package api.Account;

import api.models.LoginRequestModel;
import api.models.LoginResponseModel;

import static io.restassured.RestAssured.given;
import static specs.CodeDemoQASpec.requestSpec;
import static specs.CodeDemoQASpec.successfulResponse200Spec;

public class Authorization {
    public static LoginResponseModel userAuthorizationApi() {
        LoginRequestModel request = new LoginRequestModel(System.getProperty("logindemo"), System.getProperty("passworddemo"));
        return given(requestSpec)
                .body(request)
                .when()
                .post("/Account/v1/Login")
                .then()
                .spec(successfulResponse200Spec)
                .extract().as(LoginResponseModel.class);
    }
}
