package ru.ifellow.struzhevsky.hw5.exercise3.steps;

import java.io.File;

import static io.restassured.RestAssured.given;
import static ru.ifellow.struzhevsky.hw5.exercise2.utils.Configuration.getProperty;
import static ru.ifellow.struzhevsky.hw5.exercise3.api.SpecifactionsReg.regSuccessResponseSpec;
import static ru.ifellow.struzhevsky.hw5.exercise3.api.SpecifactionsReg.regSucessRequestSpec;

public class Registration {
    private final File jsonFile = new File(getProperty("pathCredentials"));

    public AuthorizationUser successRegistration() {
        given()
                .spec(regSucessRequestSpec())
                .body(jsonFile)
                .when()
                .post("/register")
                .then()
                .spec(regSuccessResponseSpec());

        return new AuthorizationUser();
    }
}
