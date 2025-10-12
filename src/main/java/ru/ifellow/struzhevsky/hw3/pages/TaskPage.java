package ru.ifellow.struzhevsky.hw3.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class TaskPage {
    private final SelenideElement areaFindTask = $x("//input[@id='searcher-query']").as("Строка поиска");
    private final SelenideElement buttonFind = $x("//button[@class='aui-button aui-button-primary search-button']").as("Кнопка \"Поиска\"");
    private final SelenideElement statusTask = $x("//span[@id='status-val']").as("Статус задачи");
    private final SelenideElement statusVersion = $x("//span[@id='fixVersions-field']").as("Версия задачи");
    private final SelenideElement nameFindTask = $x("//h1[@id='summary-val']").as("Название задачи");

    @Step("Поиск задачи по имени: {nameTask}")
    public TaskPage findTask(String nameTask) {
        areaFindTask.click();
        areaFindTask.clear();
        areaFindTask.setValue(nameTask);
        buttonFind.click();
        return this;
    }

    @Step("Проверка изменения названия задачи {oldTask} - старое значение")
    public String checkChangeName(String oldTask) {
        return nameFindTask.should(Condition.visible)
                .should(Condition.not(Condition.text(String.valueOf(oldTask))), Duration.ofSeconds(3)).text();
    }

    @Step("Получение статуса задачи")
    public String checkStatus() {
        return statusTask.getText();
    }

    @Step("Получение версии задачи")
    public String checkVersion() {
        return statusVersion.getText();
    }

    @Step("Получение имени задачи")
    public String getNameTest() {
        return nameFindTask.shouldBe(Condition.visible).getText();
    }
}
