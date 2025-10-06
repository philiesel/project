package ru.ifellow.struzhevsky.hw5.exercise3.steps;

import io.restassured.response.Response;
import ru.ifellow.struzhevsky.hw5.exercise3.utils.CredentialsUser;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static ru.ifellow.struzhevsky.hw5.exercise3.api.SpecifactionsAuth.*;
import static ru.ifellow.struzhevsky.hw5.exercise3.utils.ConfigurationFile.getProperty;

public class AuthorizationUser {
    private CredentialsUser credentialsUser = new CredentialsUser();

    public Response unsuccessLoginAuth() {
        Map<String, String> data = credentialsUser.changeLogin(getProperty("fakeName"));
        return given()
                .spec(authRequestSpec())
                .body(data)
                .when()
                .post("/login")
                .then()
                .spec(authUnsuccessResponseSpec())
                .body(containsString("not found"))
                .extract().response();
    }

    public Response unsuccessPassAuth() {
        Map<String, String> data = credentialsUser.changePass(getProperty("fakePass"));
        return given()
                .spec(authRequestSpec())
                .body(data)
                .when()
                .post("/login")
                .then()
                .spec(authUnsuccessResponseSpec())
                .body(containsString("not right pass"))
                .extract().response();
    }

    public String successCredentialsAuth() {
        Map<String, String> data = credentialsUser.getCredentials();
        Response response = given()
                .spec(authRequestSpec())
                .body(data)
                .when()
                .post("/login")
                .then()
                .spec(authSuccessResponseSpec())
                .body(containsString("token :"))
                .log().body()
                .extract().response();

        String responseBody = response.getBody().asString();
        return responseBody.split("token : ")[1].trim();
    }
}

