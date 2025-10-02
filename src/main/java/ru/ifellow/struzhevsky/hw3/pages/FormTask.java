package ru.ifellow.struzhevsky.hw3.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class FormTask extends BasePage {
    private SelenideElement typeIssue = $x("//input[@id='issuetype-field']").as("Тип задачи");
    private SelenideElement areaTopicTask = $x("//input[@id='summary']").as("Поле \"Тема\"");
    private SelenideElement iframe = $x("//iframe[@id='mce_7_ifr']").as("Фрейм \"Описание\"");
    private SelenideElement iframeEnvirmentLocator = $x("//iframe[@id='mce_8_ifr']").as("Фрейм \"Окружение\"");
    private SelenideElement textArea = $x("//body[@id='tinymce']").as("Текстовое поле");
    private ElementsCollection buttonVisual = $$x("//button[@type='button' and @class='aui-button' and text()='Визуальный']").as("Кнопка \"Визуальный\"");
    private SelenideElement buttCreateTask = $x("//input[@id='create-issue-submit' and @value='Создать']").as("Кнопка \"Создать\"");
    private SelenideElement priorityField = $x("//input[@id='priority-field']").as("Приоритет");
    private SelenideElement tagLocator = $x("//textarea[@id='labels-textarea']").as("Метки");
    private SelenideElement taskLocator = $x("//textarea[@id='issuelinks-issues-textarea']").as("Задача");
    private SelenideElement buttAssignToMeLocator = $x("//button[@id='assign-to-me-trigger']").as("Выбрать меня исполнителем");
    private SelenideElement linkToEpicLocator = $x("//input[@id='customfield_10100-field']").as("Ссылка на эпик");
    private SelenideElement affectedVersionsLocator = $x("//select[@id='versions']").as("Затронутые версии");
    private SelenideElement optionFixVersion = $x("//select[@id='fixVersions']").as("Исправить в версиях");
    private SelenideElement relatedTasksLocator = $x("//select[@id='issuelinks-linktype']").as("Связанные задачи");
    private SelenideElement seriousnessLocator = $x("//select[@id='customfield_10400']").as("Серьезность");
    private SelenideElement sprintOptionLocator = $x("//input[@id='customfield_10104-field']").as("Спринт");
    private SelenideElement successTaskCreate = $x("//div[@class='aui-message closeable aui-message-success aui-will-close']").as("Тест создан");

    public FormTask selectTypeBug(String typeBag) {
        clickAndSet(typeIssue, typeBag);
        return this;
    }

    public FormTask selectPriorityField(String priority) {
        clickAndSet(priorityField, priority);
        return this;
    }

    public FormTask setTag(String tag) {
        clickAndSet(tagLocator, tag);
        return this;
    }

    public FormTask setTask(String task) {
        clickAndSet(taskLocator, task);
        taskLocator.shouldHave(Condition.attributeMatching("aria-activedescendant", "test-.*"))
                .pressEnter();
        return this;
    }

    public FormTask setSprint(String sprint) {
        clickAndSet(sprintOptionLocator, sprint);
        sprintOptionLocator.shouldBe(Condition.visible).sendKeys(Keys.DOWN);
        sprintOptionLocator.pressTab();
        return this;
    }

    public FormTask setLinkToEpic(String linkEpic) {
        linkToEpicLocator.click();
        linkToEpicLocator.sendKeys(linkEpic);
        linkToEpicLocator.shouldBe(Condition.visible).sendKeys(Keys.DOWN);
        linkToEpicLocator.pressEnter();
        linkToEpicLocator.pressTab();
        return this;
    }

    public FormTask setFieldTopicTask(String nameTopic) {
        clickAndSet(areaTopicTask, nameTopic);
        return this;
    }


    public FormTask selectVisualButtonOnDescriptionTask() {
        for (SelenideElement button : buttonVisual) {
            button.click();
        }
        return this;
    }

    public FormTask setfixVersion(String version) {
        optionFixVersion.selectOptionContainingText(version);
        return this;
    }

    public FormTask setAffectedVersions(String affectedVersion) {
        affectedVersionsLocator.selectOptionContainingText(affectedVersion);
        return this;
    }

    public FormTask setDescriptionTask(String descriptionIssue) {
        setValToFrameArea(iframe, textArea, descriptionIssue);
        return this;
    }

    public FormTask setEnvironmentDescription(String environmentDescription) {
        setValToFrameArea(iframeEnvirmentLocator, textArea, environmentDescription);
        return this;
    }

    public FormTask setRelatedTasksLocator(String related) {
        relatedTasksLocator.selectOptionContainingText(related);
        return this;
    }

    public FormTask clickButtAssignToMe() {
        buttAssignToMeLocator.click();
        return this;
    }

    public FormTask setSeriousness(String seriousness) {
        seriousnessLocator.selectOption(seriousness);
        seriousnessLocator.pressTab();
        return this;
    }

    public FormTask clickButtCreateNewIssue() {
        buttCreateTask.click();
        buttCreateTask.pressEnter();
        return this;
    }

    public boolean getStatusTask() {
        return successTaskCreate.shouldBe(Condition.visible, Duration.ofSeconds(3)).getText().contains("успешно создан");
    }
}
