package ru.ifellow.struzhevsky.hw3.pages.project;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProjectPage {
    private SelenideElement countTaskOnProject = $x("//div[@class='showing']/span");
    private SelenideElement linkAllTask = $x("//a[text()='Посмотреть все задачи и фильтры']");
    private SelenideElement buttonCreateTask = $x("//a[@id='create_link']");  // заменить
    private SelenideElement metaValueProject = $x("//dd[@class='project-meta-value' and text()='TEST']");
    private SelenideElement buttonTask = $x("//a[.//span[@class='aui-nav-item-label' and @title='Задачи']]");
    private SelenideElement buttonAvatar = $x("//a[@title='Test' and contains(@class, 'jira-project-avatar')]");

    public int parsCountTaskOnProject() {
        String taskText = countTaskOnProject.shouldBe(Condition.visible).text();
        String countTask = taskText.split(" из ")[1];
        return Integer.parseInt(countTask);
    }

    public void clickMenuTask(){
        buttonTask.shouldBe(Condition.visible).click();
    }

    public void clickLinkAllTask() {
        linkAllTask.click();
    }

    public void clickButtNewTask() {
        buttonCreateTask.click();
    }

    public String getMetaValueProject(){
        return metaValueProject.text();
    }

    public void clickButtAvatar() {
        buttonAvatar.click();
    }
}
