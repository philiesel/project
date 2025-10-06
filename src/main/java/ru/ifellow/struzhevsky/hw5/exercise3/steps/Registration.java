package ru.ifellow.struzhevsky.hw5.exercise3.steps;

import io.restassured.response.Response;

import java.io.File;

import static io.restassured.RestAssured.given;
import static ru.ifellow.struzhevsky.hw5.exercise3.api.SpecifactionsReg.regSuccessResponseSpec;
import static ru.ifellow.struzhevsky.hw5.exercise3.api.SpecifactionsReg.regSucessRequestSpec;
import static ru.ifellow.struzhevsky.hw5.exercise3.utils.ConfigurationFile.getProperty;

public class Registration {
    private final File jsonFile = new File(getProperty("pathCredentials"));

    public Response successRegistration() {
        return given()
                .spec(regSucessRequestSpec())
                .body(jsonFile)
                .when()
                .post("/register")
                .then()
                .spec(regSuccessResponseSpec())
                .extract().response();
    }
}
