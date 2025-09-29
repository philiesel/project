package ru.ifellow.struzhevsky.hw5.exercise2.api;

import io.restassured.response.ValidatableResponse;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static ru.ifellow.struzhevsky.hw5.exercise2.utils.Configuration.getProperty;
import static org.hamcrest.Matchers.equalTo;

public class UserApiReqres {
    public ValidatableResponse createUserWithJson(Map<String, String> data) {
        System.out.println();
        return given()
                .spec(SpecifactionsReqres.getRequestSpec(getProperty("baseUriReqres")))
                .body(data)
                .when()
                .post("/create")
                .then()
                .spec(SpecifactionsReqres.getResponseSpec())
                .body("name", equalTo("Tomato"))
                .body("job", equalTo("Eat maket"));
    }
}
