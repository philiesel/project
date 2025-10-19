package ru.ifellow.struzhevsky.hw5.exercise2.stepDefinitions;

import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import ru.ifellow.struzhevsky.hw5.exercise2.api.UserApiReqres;
import ru.ifellow.struzhevsky.hw5.exercise2.utils.ServiceJson;

import java.util.Map;

import static org.hamcrest.Matchers.equalTo;

public class ReqresStepDefinitions {
    private ValidatableResponse response;
    private Map<String, String> data;

    @Step("Создание JSON с данными")
    @Когда("я создал JSON с данными")
    public void prepareDataFromJson() {
        ServiceJson.writeJsonToFile();
    }

    @Step("Внесение изменений в JSON")
    @Затем("я изменил JSON")
    public void changeDataFromJson() {
        data = ServiceJson.changeJsonFile();
    }

    @Step("Запрос для создание пользования с JSON")
    @И("отправил запрос для создания пользователя с JSON файлом")
    public void sendPostRequest() {
        response = new UserApiReqres().createUserWithJson(data);
    }

    @Step("Проверка статуса и тела ответа")
    @Тогда("ответ должен иметь статус {int} и тело:")
    public void checkStatusAndBody(int statusCode, Map<String, String> expectedData) {
        response.statusCode(statusCode);
        expectedData.forEach((key, value) -> {
            response.body(key, equalTo(value));
        });
    }
}
