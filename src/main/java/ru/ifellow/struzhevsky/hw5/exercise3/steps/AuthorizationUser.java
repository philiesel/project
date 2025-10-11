package ru.ifellow.struzhevsky.hw5.exercise3.steps;

import io.restassured.response.Response;
import ru.ifellow.struzhevsky.hw5.exercise3.utils.CredentialsUser;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static ru.ifellow.struzhevsky.hw5.exercise2.utils.Configuration.getProperty;
import static ru.ifellow.struzhevsky.hw5.exercise3.api.SpecifactionsAuth.requestSpec;
import static ru.ifellow.struzhevsky.hw5.exercise3.api.SpecifactionsAuth.responseSpec;

public class AuthorizationUser {
    private CredentialsUser credentialsUser = new CredentialsUser();

    private AuthorizationUser unsuccessAuth(String field, String expectedErrorMessage) {
        Map<String, String> data;
        if ("fakeName".equals(field)) {
            data = credentialsUser.changeLogin(getProperty(field));
        } else {
            data = credentialsUser.changePass(getProperty("fakePass"));
        }
        given()
                .spec(requestSpec())
                .body(data)
                .when()
                .post("/login")
                .then()
                .spec(responseSpec(401))
                .body(containsString(expectedErrorMessage));
        return this;
    }

    public AuthorizationUser unsuccessLoginAuth() {
        return unsuccessAuth("fakeName", "not found");
    }

    public AuthorizationUser unsuccessPassAuth() {
        return unsuccessAuth("fakePass", "not right pass");
    }

    public String successCredentialsAuth() {
        Map<String, String> data = credentialsUser.getCredentials();
        Response response = given()
                .spec(requestSpec())
                .body(data)
                .when()
                .post("/login")
                .then()
                .spec(responseSpec(200))
                .body(containsString("token :"))
                .log().body()
                .extract().response();

        String responseBody = response.getBody().asString();
        return responseBody.split("token : ")[1].trim();
    }
}

