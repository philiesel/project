package ru.ifellow.struzhevsky.hw5.exercise3.stepDefinitions;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Param;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;

import static io.qameta.allure.model.Parameter.Mode.MASKED;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static ru.ifellow.struzhevsky.hw5.exercise2.utils.Configuration.getProperty;
import static ru.ifellow.struzhevsky.hw5.exercise3.api.SpecifactionsAuth.requestSpec;
import static ru.ifellow.struzhevsky.hw5.exercise3.api.SpecifactionsAuth.responseSpec;

@DisplayName("Выход из учетной записи")
@Tag("UserLogout-001")
public class UserLogout {
    private AuthorizationUser authorizationUser = new AuthorizationUser();

    @Step("Выйти из учетной записи без токена")
    @Тогда("пытаюсь выйти из учетной записи без токена")
    public UserLogout logoutUnsuccessTest() {
        given()
                .spec(requestSpec())
                .header("Authorization", getProperty("fakeToken"))
                .when()
                .get("/logout")
                .then()
                .spec(responseSpec(401))
                .body(equalTo("not found"));
        return this;
    }

    private UserLogout logoutSuccessTest(@Param(mode = MASKED) String token) {
        given()
                .spec(requestSpec())
                .header("Authorization", token)
                .when()
                .get("/logout")
                .then()
                .spec(responseSpec(200))
                .body(equalTo("success logout"));
        return this;
    }

    @Step("Выйти из учетной записи с токеном")
    @И("успешно выхожу из учетной записи с токеном")
    public void logouSuccess() {
        logoutSuccessTest(authorizationUser.successCredentialsAuth());
    }
}
