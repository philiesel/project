package ru.ifellow.struzhevsky.hw5.exercise3.steps;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static ru.ifellow.struzhevsky.hw5.exercise3.api.SpecifactionsAuth.*;
import static ru.ifellow.struzhevsky.hw5.exercise3.utils.ConfigurationFile.getProperty;

public class UserLogout {
    public Response logoutUnsuccessTest() {
        return given()
                .spec(authRequestSpec())
                .header("Authorization", getProperty("fakeToken"))
                .when()
                .get("/logout")
                .then()
                .spec(authUnsuccessResponseSpec())
                .body(equalTo("not found"))
                .extract().response();
    }

    public Response logoutSuccessTest(String token) {
        return given()
                .spec(authRequestSpec())
                .header("Authorization", token)
                .when()
                .get("/logout")
                .then()
                .spec(authSuccessResponseSpec())
                .body(equalTo("success logout"))
                .extract().response();
    }
}
