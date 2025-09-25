package ru.ifellow.struzhevsky.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ifellow.struzhevsky.hw3.pages.dashboard.DashboardPage;
import ru.ifellow.struzhevsky.hw3.pages.login.LoginPage;
import ru.ifellow.struzhevsky.hw3.pages.project.ProjectPage;
import ru.ifellow.struzhevsky.hw3.pages.task.TaskPage;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTest extends BaseTest{
    private LoginPage loginPage = new LoginPage();
    private ProjectPage projectPage = new ProjectPage();
    private DashboardPage dashboardPage = new DashboardPage();
    private TaskPage taskPage = new TaskPage();
    private final String findTask = "TestSeleniumATHomework";
    private final String versionTask = "Version 2.0";
    private final String statusTask = "Сделать";

    @Test
    @DisplayName("Проверка статуса и версии в задаче проекта")
    public void checkStatusAndVersionTask() {
        loginPage.auth(BaseTest.username, BaseTest.password);
        dashboardPage.goToProjectTest();
        projectPage.clickLinkAllTask();
        taskPage.findTask(findTask);
        assertEquals(statusTask.toUpperCase(), taskPage.checkStatus());
        assertEquals(versionTask, taskPage.checkVersion());
    }
}
