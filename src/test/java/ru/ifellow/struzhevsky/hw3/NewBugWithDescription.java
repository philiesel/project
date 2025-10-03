package ru.ifellow.struzhevsky.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ifellow.struzhevsky.hw3.pages.DashboardPage;
import ru.ifellow.struzhevsky.hw3.pages.FormTask;
import ru.ifellow.struzhevsky.hw3.pages.LoginPage;
import ru.ifellow.struzhevsky.hw3.pages.ProjectPage;
import ru.ifellow.struzhevsky.hw3.utils.TestData;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NewBugWithDescription extends BaseTest {
    private LoginPage loginPage = new LoginPage();
    private ProjectPage projectPage = new ProjectPage();
    private DashboardPage dashboardPage = new DashboardPage();
    private FormTask formTask = new FormTask();

    @Test
    @DisplayName("Проверка заведения нового бага с описанием")
    public void createNewBugWithDescription() {
        loginPage.auth(BaseTest.username, BaseTest.password);
        dashboardPage.goToProjectTest();
        projectPage.clickMenuTask();
        projectPage.clickButtNewTask();
        formTask.selectVisualButtonOnDescriptionTask();
        formTask.selectTypeBug(TestData.TYPE_BUG);
        formTask.setFieldTopicTask(TestData.TOPIC_BUG);
        formTask.setDescriptionTask(TestData.DESCRIPTION_TASK);
        formTask.setfixVersion(TestData.FIX_VERSION);
        formTask.selectPriorityField(TestData.PRIORITY);
        formTask.setTag(TestData.TAG);
        formTask.setEnvironmentDescription(TestData.ENVIRONMENT_DESCRIPTION);
        formTask.setAffectedVersions(TestData.AFFECTED_VERSION);
        formTask.setRelatedTasksLocator(TestData.RELATED_TASK);
        formTask.setTask(TestData.TASK);
        formTask.clickButtAssignToMe();
        formTask.setSprint(TestData.SPRINT);
        formTask.setSeriousness(TestData.SERIOUSNESS);
        formTask.clickButtCreateNewIssue();
        assertTrue(formTask.getStatusTask(), "Задача не была создана!");
    }
}
