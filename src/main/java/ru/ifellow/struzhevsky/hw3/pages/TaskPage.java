package ru.ifellow.struzhevsky.hw3.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class TaskPage {
    private final SelenideElement areaFindTask = $x("//input[@id='searcher-query']").as("Строка поиска");
    private final SelenideElement buttonFind = $x("//button[@class='aui-button aui-button-primary search-button']").as("Кнопка \"Поиска\"");
    private final SelenideElement statusTask = $x("//span[@id='status-val']").as("Статус задачи");
    private final SelenideElement statusVersion = $x("//span[@id='fixVersions-field']").as("Версия задачи");
    private final SelenideElement nameFindTask = $x("//h1[@id='summary-val']").as("Название задачи");

    public TaskPage findTask(String nameTask) {
        areaFindTask.click();
        areaFindTask.clear();
        areaFindTask.setValue(nameTask);
        buttonFind.click();
        return this;
    }

    public String checkChangeName(String oldTask) {
        return nameFindTask.should(Condition.visible)
                .should(Condition.not(Condition.text(String.valueOf(oldTask))), Duration.ofSeconds(3)).text();

    }

    public String checkStatus() {
        return statusTask.getText();
    }

    public String checkVersion() {
        return statusVersion.getText();
    }

    public String getNameTest() {
        return nameFindTask.shouldBe(Condition.visible).getText();
    }

}
