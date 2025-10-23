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
    private final SelenideElement typeIssue = $x("//input[@id='issuetype-field']")
            .as("Тип задачи");
    private final SelenideElement areaTopicTask = $x("//input[@id='summary']")
            .as("Поле \"Тема\"");
    private final SelenideElement textArea = $x("//body[@id='tinymce']")
            .as("Текстовое поле");
    private final ElementsCollection buttonVisual = $$x("//button[@type='button' and @class='aui-button' and text()='Визуальный']")
            .as("Кнопка \"Визуальный\"");
    private final SelenideElement buttCreateTask = $x("//input[@id='create-issue-submit' and @value='Создать']")
            .as("Кнопка \"Создать\"");
    private final SelenideElement priorityField = $x("//input[@id='priority-field']")
            .as("Приоритет");
    private final SelenideElement tagLocator = $x("//textarea[@id='labels-textarea']")
            .as("Метки");
    private final SelenideElement taskLocator = $x("//textarea[@id='issuelinks-issues-textarea']")
            .as("Задача");
    private final SelenideElement buttAssignToMeLocator = $x("//button[@id='assign-to-me-trigger']")
            .as("Выбрать меня исполнителем");
    private final SelenideElement affectedVersionsLocator = $x("//select[@id='versions']")
            .as("Затронутые версии");
    private final SelenideElement optionFixVersion = $x("//select[@id='fixVersions']")
            .as("Исправить в версиях");
    private final SelenideElement relatedTasksLocator = $x("//select[@id='issuelinks-linktype']")
            .as("Связанные задачи");
    private final SelenideElement seriousnessLocator = $x("//select[@id='customfield_10400']")
            .as("Серьезность");
    private final SelenideElement sprintOptionLocator = $x("//input[@id='customfield_10104-field']")
            .as("Спринт");
    private final SelenideElement successTaskCreate = $x("//div[@class='aui-message closeable aui-message-success aui-will-close']")
            .as("Тест создан");
    private final ElementsCollection collectionFrames = $$("iframe")
            .as("Коллекция фреймов");

    @Step("Выбор типа задачи: {typeTask}")
    public FormTask selectTypeTask(String typeTask) {
        typeIssue.click();
        typeIssue.clear();
        typeIssue.click();
        typeIssue.sendKeys(typeTask);
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
        tagLocator.shouldBe(visible).sendKeys(Keys.DOWN, Keys.ENTER);
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
        sprintOptionLocator.shouldBe(visible).sendKeys(Keys.DOWN, Keys.TAB);
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
    public FormTask setFixVersion(String version) {
        optionFixVersion.selectOptionContainingText(version);
        return this;
    }

    @Step("Установка затронутой версии: {affectedVersion}")
    public FormTask setAffectedVersions(String affectedVersion) {
        affectedVersionsLocator.selectOptionContainingText(affectedVersion);
        return this;
    }

    private FormTask switchToFrameSetText(int frameIndex, String text) {
        SelenideElement iframe = collectionFrames.get(frameIndex);
        iframe.scrollTo();
        switchTo().frame(iframe);
        textArea.shouldBe(visible).setValue(text);
        switchTo().defaultContent();
        return this;
    }

    @Step("Ввод описания задачи")
    public FormTask setDescriptionTask(String descriptionIssue) {
        return switchToFrameSetText(0, descriptionIssue);
    }

    @Step("Ввод описания окружения")
    public FormTask setEnvironmentDescription(String environmentDescription) {
        return switchToFrameSetText(1, environmentDescription);
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
