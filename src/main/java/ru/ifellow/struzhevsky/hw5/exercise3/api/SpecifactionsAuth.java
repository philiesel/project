package ru.ifellow.struzhevsky.hw5.exercise3.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.filter.log.LogDetail.BODY;
import static ru.ifellow.struzhevsky.hw5.exercise2.utils.Configuration.getProperty;

public class SpecifactionsAuth {
    public static RequestSpecification authRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(getProperty("baseLocalSpringUrl"))
                .setContentType(ContentType.JSON)
                .log(BODY)
                .build();
    }

    public static ResponseSpecification authResponseSpec(int statusCode) {
        return new ResponseSpecBuilder()
                .log(BODY)
                .expectStatusCode(statusCode)
                .build();
    }
}
