package ru.ifellow.struzhevsky.hw3.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.attributeMatching;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class FormTask extends BasePage {
    private SelenideElement typeIssue = $x("//input[@id='issuetype-field']").as("Тип задачи");
    private SelenideElement areaTopicTask = $x("//input[@id='summary']").as("Поле \"Тема\"");
    private SelenideElement textArea = $x("//body[@id='tinymce']").as("Текстовое поле");
    private ElementsCollection buttonVisual = $$x("//button[@type='button' and @class='aui-button' and text()='Визуальный']").as("Кнопка \"Визуальный\"");
    private SelenideElement buttCreateTask = $x("//input[@id='create-issue-submit' and @value='Создать']").as("Кнопка \"Создать\"");
    private SelenideElement priorityField = $x("//input[@id='priority-field']").as("Приоритет");
    private SelenideElement tagLocator = $x("//textarea[@id='labels-textarea']").as("Метки");
    private SelenideElement taskLocator = $x("//textarea[@id='issuelinks-issues-textarea']").as("Задача");
    private SelenideElement buttAssignToMeLocator = $x("//button[@id='assign-to-me-trigger']").as("Выбрать меня исполнителем");
    private SelenideElement affectedVersionsLocator = $x("//select[@id='versions']").as("Затронутые версии");
    private SelenideElement optionFixVersion = $x("//select[@id='fixVersions']").as("Исправить в версиях");
    private SelenideElement relatedTasksLocator = $x("//select[@id='issuelinks-linktype']").as("Связанные задачи");
    private SelenideElement seriousnessLocator = $x("//select[@id='customfield_10400']").as("Серьезность");
    private SelenideElement sprintOptionLocator = $x("//input[@id='customfield_10104-field']").as("Спринт");
    private SelenideElement successTaskCreate = $x("//div[@class='aui-message closeable aui-message-success aui-will-close']").as("Тест создан");
    private ElementsCollection collectionIrames = $$("iframe").as("Коллекция фреймов");

    @Step("Выбор типа задачи: {typeBag}")
    public FormTask selectTypeBug(String typeBag) {
        typeIssue.click();
        typeIssue.clear();
        typeIssue.click();
        typeIssue.sendKeys(typeBag);
        return this;
    }

    @Step("Выбор приоритета задачи: {priority}")
    public FormTask selectPriorityField(String priority) {
        clickAndSet(priorityField, priority);
        return this;
    }

    @Step("Установка тега: {tag}")
    public FormTask setTag(String tag) {
        clickAndSet(tagLocator, tag);
        tagLocator.shouldBe(visible).sendKeys(Keys.DOWN);
        tagLocator.pressEnter();
        switchTo().defaultContent();
        return this;
    }

    @Step("Выбор задачи: {task}")
    public FormTask setTask(String task) {
        clickAndSet(taskLocator, task);
        taskLocator.shouldHave(attributeMatching("aria-activedescendant", "test-.*"))
                .pressEnter();
        return this;
    }

    @Step("Выбор спринта: {sprint}")
    public FormTask setSprint(String sprint) {
        clickAndSet(sprintOptionLocator, sprint);
        sprintOptionLocator.shouldBe(visible).sendKeys(Keys.DOWN);
        sprintOptionLocator.pressTab();
        return this;
    }

    @Step("Заполнение темы задачи: {nameTopic}")
    public FormTask setFieldTopicTask(String nameTopic) {
        clickAndSet(areaTopicTask, nameTopic);
        return this;
    }

    @Step("Активация кнопок \"Визуальный\" описания задачи")
    public FormTask selectVisualButtonOnDescriptionTask() {
        for (SelenideElement button : buttonVisual) {
            button.click();
        }
        return this;
    }

    @Step("Установка версии исправления: {version}")
    public FormTask setfixVersion(String version) {
        optionFixVersion.selectOptionContainingText(version);
        return this;
    }

    @Step("Установка затронутой версии: {affectedVersion}")
    public FormTask setAffectedVersions(String affectedVersion) {
        affectedVersionsLocator.selectOptionContainingText(affectedVersion);
        return this;
    }

    @Step("Ввод описания задачи")
    public FormTask setDescriptionTask(String descriptionIssue) {
        SelenideElement iframeEnv = collectionIrames.get(0);
        iframeEnv.scrollTo();
        switchTo().frame(iframeEnv);
        textArea.click();
        textArea.setValue(descriptionIssue);
        switchTo().defaultContent();
        return this;
    }

    @Step("Ввод описания окружения")
    public FormTask setEnvironmentDescription(String environmentDescription) {
        SelenideElement iframeEnv = collectionIrames.get(1);
        iframeEnv.scrollTo();
        switchTo().frame(iframeEnv);
        textArea.click();
        textArea.setValue(environmentDescription);
        switchTo().defaultContent();
        return this;
    }

    @Step("Указание связанных задач: {related}")
    public FormTask setRelatedTasksLocator(String related) {
        relatedTasksLocator.selectOptionContainingText(related);
        return this;
    }

    @Step("Назначить задачу на себя")
    public FormTask clickButtAssignToMe() {
        buttAssignToMeLocator.click();
        return this;
    }

    @Step("Установка степени серьёзности: {seriousness}")
    public FormTask setSeriousness(String seriousness) {
        seriousnessLocator.selectOption(seriousness);
        seriousnessLocator.pressTab();
        return this;
    }

    @Step("Нажать кнопку 'Создать задачу'")
    public FormTask clickButtCreateNewIssue() {
        buttCreateTask.click();
        return this;
    }

    @Step("Проверка статуса создания задачи")
    public boolean getStatusTask() {
        return successTaskCreate.shouldBe(visible, Duration.ofSeconds(6)).getText().contains("успешно создан");
    }
}
