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
        projectPage.clickMenuTask()
                .clickButtNewTask();
        formTask.selectVisualButtonOnDescriptionTask()
                .selectTypeBug(TestData.TYPE_BUG)
                .setFieldTopicTask(TestData.TOPIC_BUG)
                .setDescriptionTask(TestData.DESCRIPTION_TASK)
                .setfixVersion(TestData.FIX_VERSION)
                .selectPriorityField(TestData.PRIORITY)
                .setTag(TestData.TAG)
                .setEnvironmentDescription(TestData.ENVIRONMENT_DESCRIPTION)
                .setAffectedVersions(TestData.AFFECTED_VERSION)
                .setRelatedTasksLocator(TestData.RELATED_TASK)
                .setTask(TestData.TASK)
                .clickButtAssignToMe()
                .setSprint(TestData.SPRINT)
                .setSeriousness(TestData.SERIOUSNESS)
                .clickButtCreateNewIssue();
        assertTrue(formTask.getStatusTask(), "Задача не была создана!");
    }
}
