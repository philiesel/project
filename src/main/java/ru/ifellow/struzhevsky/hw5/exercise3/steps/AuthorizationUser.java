package ru.ifellow.struzhevsky.hw5.exercise3.steps;

import io.restassured.response.Response;
import ru.ifellow.struzhevsky.hw5.exercise3.utils.CredentialsUser;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static ru.ifellow.struzhevsky.hw5.exercise2.utils.Configuration.getProperty;
import static ru.ifellow.struzhevsky.hw5.exercise3.api.SpecifactionsAuth.authRequestSpec;
import static ru.ifellow.struzhevsky.hw5.exercise3.api.SpecifactionsAuth.authResponseSpec;

public class AuthorizationUser {
    private CredentialsUser credentialsUser = new CredentialsUser();

    public AuthorizationUser unsuccessLoginAuth() {
        Map<String, String> data = credentialsUser.changeLogin(getProperty("fakeName"));
        given()
                .spec(authRequestSpec())
                .body(data)
                .when()
                .post("/login")
                .then()
                .spec(authResponseSpec(401))
                .body(containsString("not found"));
        return this;
    }

    public AuthorizationUser unsuccessPassAuth() {
        Map<String, String> data = credentialsUser.changePass(getProperty("fakePass"));
        given()
                .spec(authRequestSpec())
                .body(data)
                .when()
                .post("/login")
                .then()
                .spec(authResponseSpec(401))
                .body(containsString("not right pass"));
        return this;
    }

    public String successCredentialsAuth() {
        Map<String, String> data = credentialsUser.getCredentials();
        Response response = given()
                .spec(authRequestSpec())
                .body(data)
                .when()
                .post("/login")
                .then()
                .spec(authResponseSpec(200))
                .body(containsString("token :"))
                .log().body()
                .extract().response();

        String responseBody = response.getBody().asString();
        return responseBody.split("token : ")[1].trim();
    }
}

