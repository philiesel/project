package ru.ifellow.struzhevsky.hw5.exercise1.api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;

public class BaseApi {
    public Response getCharacterByName(String characterName) {
        return given()
                .spec(SpecifactionsRickAndMorty.getCharacterReqestSpec())
                .queryParam("name", characterName)
                .when()
                .get()
                .then()
                .spec(SpecifactionsRickAndMorty.getResponseSpec())
                .body("results.size()", greaterThan(0))
                .extract().response();
    }

    public Response getCharacters(String lastEpisodeUrl) {
        return given()
                .spec(SpecifactionsRickAndMorty.getCharacterReqestSpec())
                .get(lastEpisodeUrl)
                .then()
                .spec(SpecifactionsRickAndMorty.getResponseSpec())
                .extract().response();
    }

}
