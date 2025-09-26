package ru.ifellow.struzhevsky.hw3.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class FormTask {
    private SelenideElement typeIssue = $x("//input[@id='issuetype-field']");
    private SelenideElement areaTopicTask = $x("//input[@id='summary']");
    private SelenideElement iframe = $x("//iframe[@id='mce_7_ifr']");
    private SelenideElement iframeEnvirmentLocator = $x("//iframe[@id='mce_6_ifr' and @class='tox-edit-area__iframe']");
    private SelenideElement textArea = $x("//body[@id='tinymce' and @contenteditable='true']");
    private ElementsCollection buttonVisual = $$x("//button[@type='button' and @class='aui-button' and text()='Визуальный']");
    private SelenideElement buttCreateTask = $x("//input[@id='create-issue-submit' and @value='Создать']");
    private SelenideElement priorityField = $x("//input[@id='priority-field']");
    private SelenideElement tagLocator = $x("//textarea[@id='labels-textarea']");
    private SelenideElement environmentLocator = $x("//textarea[@id='environment']").as("Окружение");
    private SelenideElement taskLocator = $x("//textarea[@id='issuelinks-issues-textarea']").as("Задача");
    private SelenideElement buttAssignToMeLocator = $x("//button[@id='assign-to-me-trigger']").as("Выбрать меня исполнителем");
    private SelenideElement LinkToEpicLocator = $x("//input[@id='customfield_10100-field']").as("Ссылка на эпик");
    private ElementsCollection affectedVersionsLocator = $$x("//select[@id='versions']//option");
    private ElementsCollection optionFixVersion = $$x("//select[@id='fixVersions']//option");
    private SelenideElement relatedTasksLocator = $x("//select[@id='issuelinks-linktype']");
    private SelenideElement seriousnessLocator = $x("//select[@id='customfield_10400']").as("Серьезность");
    private SelenideElement sprintOptionLocator = $x("//input[@id='customfield_10104-field']").as("Спринт");
    // private SelenideElement labelLocator = $x("//div[@class='field-group aui-field-versionspicker select-list-renderer']//label[@for='versions']").as("Затронуты версии");

    public void selectTypeBug(String typeBug) { // Тип задачи
        typeIssue.click();
        typeIssue.clear();
        typeIssue.setValue(typeBug);
        typeIssue.pressEnter();
    }

    public void setFieldTopicTask(String nameTopic) {  // название темы
        areaTopicTask.click();
        areaTopicTask.clear();
        areaTopicTask.setValue(nameTopic);
    }

    public void setDescriptionTask(String descriptionIssue) { // Описание бага
        iframe.shouldBe(Condition.visible);
        switchTo().frame(iframe.toWebElement()); // переключаемся на фрейм
        textArea.click();
        textArea.setValue(descriptionIssue);
        switchTo().defaultContent(); // Возвращаемся на основной контент страницы
    }

    public void selectVisualButtonOnDescriptionTask() { // нажать кнопки "Визуальный"
        for (SelenideElement button : buttonVisual) {
            button.click();
        }
    }

    public void setfixVersion(String version) {  // Исправить в версиях
        SelenideElement element = optionFixVersion.stream()
                .filter(x -> x.text().equals(version))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Нет такой версии"));
        element.click();
    }

    public void selectPriorityField(String priority) { // приоритет
        priorityField.click();
        priorityField.clear();
        priorityField.setValue(priority);
    }

    public void setEnvironmentDescription(String environmentDescription) {
        iframeEnvirmentLocator.shouldBe(Condition.visible);
        switchTo().frame(iframeEnvirmentLocator.toWebElement()); // переключаемся на фрейм
        environmentLocator.click();
        environmentLocator.setValue(environmentDescription);
        switchTo().defaultContent(); // Возвращаемся на основной контент страницы
    }

    public void setTag(String tag) { // метки
        tagLocator.click();
        tagLocator.clear();
        tagLocator.setValue(tag);
        taskLocator.pressTab();
        switchTo().defaultContent();
    }

    public void setAffectedVersions(String affectedVersion) { // Затронуты версии
        SelenideElement element = affectedVersionsLocator.stream()
                .filter(x -> x.text().equals(affectedVersion))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Нет такой версии"));
        element.scrollTo().click();

    }

    public void setRelatedTasksLocator() { // Связанные задачи
        relatedTasksLocator.selectOptionByValue("blocks");  // через switch переделать убрать харкод
    }

    public void setTask(String task) { // выбраит задачу
        taskLocator.click();
        taskLocator.clear();
        taskLocator.setValue(task);
        taskLocator.pressTab();
        switchTo().defaultContent();
    }

    public void clickButtAssignToMe() { // Исполнитель
        buttAssignToMeLocator.click();
    }

    public void setLinkToEpic(String linkEpic) {  // Ссылка на эпик
        LinkToEpicLocator.click();
        LinkToEpicLocator.clear();
        LinkToEpicLocator.setValue(linkEpic);
        LinkToEpicLocator.pressTab();
        switchTo().defaultContent();
    }

    public void setSprint(String sprint) { // ввести
        sprintOptionLocator.click();
        sprintOptionLocator.clear();
        sprintOptionLocator.setValue(sprint);
        sprintOptionLocator.pressTab();
    }

    public void setSeriousness(String seriousness) {  // через switch переделать убрать харкод
        seriousnessLocator.selectOptionByValue("1010");
        sprintOptionLocator.pressTab();
        switchTo().defaultContent();
    }

    public void clickButtCreateNewIssue() {
        buttCreateTask.click();
    }
}
