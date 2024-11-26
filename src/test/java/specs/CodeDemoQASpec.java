package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.ALL;
import static io.restassured.http.ContentType.JSON;

public class CodeDemoQASpec {
    public final static RequestSpecification requestSpec = with()
            .filter(withCustomTemplates())
            .contentType(JSON)
            .log().all();
    public final static ResponseSpecification successfulResponse201Spec = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .log(ALL)
            .build();
    public final static ResponseSpecification successfulResponse204Spec = new ResponseSpecBuilder()
            .expectStatusCode(204)
            .log(ALL)
            .build();
    public final static ResponseSpecification successfulResponse200Spec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(ALL)
            .build();

}
