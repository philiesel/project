package ru.ifellow.struzhevsky.hw3;

import org.junit.jupiter.api.Test;
import ru.ifellow.struzhevsky.hw3.pages.dashboard.DashboardPage;
import ru.ifellow.struzhevsky.hw3.pages.login.LoginPage;
import ru.ifellow.struzhevsky.hw3.pages.project.ProjectPage;
import ru.ifellow.struzhevsky.hw3.pages.task.FormTask;

public class NewBugWithDescription extends BaseTest {
    private LoginPage loginPage = new LoginPage();
    private ProjectPage projectPage = new ProjectPage();
    private DashboardPage dashboardPage = new DashboardPage();
    private FormTask formTask = new FormTask();

    private String typeBug = "Ошибка";
    private String topicBug = "Баг тест";
    private String descriptionTask = "Баг описание";
    private String fixVersion = "Неизвестный";
    private String priority = "Medium";
    private String tag = "test";
    private String affectedVersion = "Неизвестный";
    private String environmentDescription = "Описание окружения";
    private String task = "task";
    private String epic = "Epic";
    private String sprint = "Доска Спринт 1";
    private String seriousness = "S0 Тривиальный/Trivial";

    @Test
    public void createNewBugWithDescription() {
        loginPage.auth(BaseTest.username, BaseTest.password);
        dashboardPage.goToProjectTest();
        projectPage.clickMenuTask();
        projectPage.clickButtNewTask();

        formTask.selectVisualButtonOnDescriptionTask(); //  необходимо убедиться (если не так, то прожать кнопку), что в полях «Описание» и «Окружение»   выбрано «Визуальный»
        formTask.selectTypeBug(typeBug);
        formTask.setFieldTopicTask(topicBug);
        formTask.setDescriptionTask(descriptionTask);
        formTask.setfixVersion(fixVersion);
        formTask.selectPriorityField(priority);
        formTask.setTag(tag);
        //formTask.setEnvironmentDescription(environmentDescription);
        formTask.setAffectedVersions(affectedVersion);
        formTask.setRelatedTasksLocator();
        formTask.setTask(task);
        formTask.clickButtAssignToMe();
        formTask.setLinkToEpic(epic);
        formTask.setSprint(sprint);
        formTask.setSeriousness(seriousness);
        formTask.clickButtCreateNewIssue();
    }
}
