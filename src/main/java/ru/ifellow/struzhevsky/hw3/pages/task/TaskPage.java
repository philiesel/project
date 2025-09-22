package ru.ifellow.struzhevsky.hw3.pages.task;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class TaskPage {
    private final SelenideElement areaFindTask = $x("//input[@id='searcher-query']");
    private final SelenideElement buttonFind = $x("//button[@class='aui-button aui-button-primary search-button']");
    private final SelenideElement statusTask = $x("//span[@id='status-val']").as("Статус");
    private final SelenideElement statusVersion = $x("//span[@id='fixVersions-field']").as("Версия");

    public void findTask(String nameTask) {
        areaFindTask.click();
        areaFindTask.clear();
        areaFindTask.setValue(nameTask);
        buttonFind.click();
    }

    public String checkStatus() {
        return statusTask.getText();
    }

    public String checkVersion() {
        return  statusVersion.getText();
    }
}
