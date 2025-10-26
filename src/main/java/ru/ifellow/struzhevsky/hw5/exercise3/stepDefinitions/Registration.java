package ru.ifellow.struzhevsky.hw5.exercise3.stepDefinitions;

import io.cucumber.java.ru.Когда;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;

import java.io.File;

import static io.restassured.RestAssured.given;
import static ru.ifellow.struzhevsky.hw5.exercise2.utils.Configuration.getProperty;
import static ru.ifellow.struzhevsky.hw5.exercise3.api.SpecifactionsAuth.requestSpec;
import static ru.ifellow.struzhevsky.hw5.exercise3.api.SpecifactionsAuth.responseSpec;

@DisplayName("Регистрация пользователя")
@Tag("Registration_User-001")
public class Registration {
    private final File jsonFile = new File(getProperty("pathCredentials"));

    @Step("Регистрация нового пользователя")
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
