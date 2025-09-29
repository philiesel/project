package ru.ifellow.struzhevsky.hw5.exercise1.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import ru.ifellow.struzhevsky.hw5.exercise1.utils.Configuration;

import static io.restassured.filter.log.LogDetail.BODY;

public class SpecifactionsRickAndMorty {
    private static final String BASE_URI = Configuration.getProperty("baseUriRickAndMorty");
    private static String сharacterResources = "/character/";

    public static RequestSpecification getCharacterReqestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(сharacterResources)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification getResponseSpec() {
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .log(BODY)
                .build();
    }
}
