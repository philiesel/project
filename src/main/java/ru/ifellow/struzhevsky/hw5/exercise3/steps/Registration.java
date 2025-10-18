package ru.ifellow.struzhevsky.hw5.exercise3.steps;

import io.cucumber.java.ru.Когда;

import java.io.File;

import static io.restassured.RestAssured.given;
import static ru.ifellow.struzhevsky.hw5.exercise2.utils.Configuration.getProperty;
import static ru.ifellow.struzhevsky.hw5.exercise3.api.SpecifactionsAuth.requestSpec;
import static ru.ifellow.struzhevsky.hw5.exercise3.api.SpecifactionsAuth.responseSpec;

public class Registration {
    private final File jsonFile = new File(getProperty("pathCredentials"));

    @Когда("зарегистрировал нового пользователя")
    public AuthorizationUser successRegistration() {
        given()
                .spec(requestSpec())
                .body(jsonFile)
                .when()
                .post("/register")
                .then()
                .spec(responseSpec(200));
        return new AuthorizationUser();
    }
}
