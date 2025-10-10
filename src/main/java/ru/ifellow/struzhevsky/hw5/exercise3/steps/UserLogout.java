package ru.ifellow.struzhevsky.hw5.exercise3.steps;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static ru.ifellow.struzhevsky.hw5.exercise2.utils.Configuration.getProperty;
import static ru.ifellow.struzhevsky.hw5.exercise3.api.SpecifactionsAuth.*;

public class UserLogout {
    public UserLogout logoutUnsuccessTest() {
        given()
                .spec(authRequestSpec())
                .header("Authorization", getProperty("fakeToken"))
                .when()
                .get("/logout")
                .then()
                .spec(authResponseSpec(401))
                .body(equalTo("not found"));
        return this;
    }

    public UserLogout logoutSuccessTest(String token) {
        given()
                .spec(authRequestSpec())
                .header("Authorization", token)
                .when()
                .get("/logout")
                .then()
                .spec(authResponseSpec(200))
                .body(equalTo("success logout"));
        return this;
    }
}
