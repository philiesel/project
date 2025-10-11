package ru.ifellow.struzhevsky.hw5.exercise3.steps;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static ru.ifellow.struzhevsky.hw5.exercise2.utils.Configuration.getProperty;
import static ru.ifellow.struzhevsky.hw5.exercise3.api.SpecifactionsAuth.requestSpec;
import static ru.ifellow.struzhevsky.hw5.exercise3.api.SpecifactionsAuth.responseSpec;

public class UserLogout {
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

    public UserLogout logoutSuccessTest(String token) {
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
}
