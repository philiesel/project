package ru.ifellow.struzhevsky.hw5.exercise2.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.filter.log.LogDetail.BODY;

public class SpecifactionsReqres {
    public static RequestSpecification getRequestSpec(String url) {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .addHeader("x-api-key", "reqres-free-v1")
                .setContentType(ContentType.JSON)
                .log(BODY)
                .build();
    }

    public static ResponseSpecification getResponseSpec() {
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .log(BODY)
                .expectStatusCode(201)
                .build();
    }
}
