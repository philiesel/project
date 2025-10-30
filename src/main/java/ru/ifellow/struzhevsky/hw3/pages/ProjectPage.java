package ru.ifellow.struzhevsky.hw3.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class ProjectPage {
    private final SelenideElement countTaskOnProject = $x("//div[@class='showing']/span").as("Надпись кол-во задач");
    private final SelenideElement linkAllTask = $x("//a[text()='Посмотреть все задачи и фильтры']").as("Все задачи и фильтры");
    private final SelenideElement buttonCreateTask = $x("//a[@id='create_link']").as("Создать новую задачу");
    private final SelenideElement metaValueProject = $x("//dd[@class='project-meta-value' and text()='TEST']").as("Тег проекта");
    private final SelenideElement buttonTask = $x("//a[.//span[@class='aui-nav-item-label' and @title='Задачи']]").as("Кнопка \"Задачи\"");
    private final SelenideElement buttonAvatar = $x("//a[@title='Test' and contains(@class, 'jira-project-avatar')]").as("Аватарка");

    @Step("Получить количество задач в проекте")
    public int parsCountTaskOnProject() {
        String taskText = countTaskOnProject.shouldBe(Condition.visible, Duration.ofSeconds(5)).text();
        String countTask = taskText.split(" из ")[1];
        return Integer.parseInt(countTask);
    }

    @Step("Обновить и получить обновлённое количество задач (предыдущее: {oldCountTask})")
    public int parseUpdateCountTaskOnProject(int oldCountTask) {
        Selenide.refresh();
        Selenide.sleep(5);
        String taskText = countTaskOnProject.should(Condition.visible)
                .should(Condition.not(Condition.text(String.valueOf(oldCountTask))), Duration.ofSeconds(10)).text();
        String countTask = taskText.split(" из ")[1];
        return Integer.parseInt(countTask);
    }

    @Step("Открыть меню 'Задачи'")
    public ProjectPage clickMenuTask() {
        buttonTask.shouldBe(Condition.visible).click();
        return this;
    }

    @Step("Перейти по ссылке 'Посмотреть все задачи и фильтры'")
    public void clickLinkAllTask() {
        linkAllTask.click();
    }

    @Step("Нажать кнопку 'Создать новую задачу'")
    public void clickButtNewTask() {
        buttonCreateTask.click();
    }

    @Step("Получить тег проекта")
    public String getMetaValueProject() {
        return metaValueProject.text();
    }

    @Step("Нажать на аватар проекта")
    public void clickButtAvatar() {
        buttonAvatar.click();
    }
}
