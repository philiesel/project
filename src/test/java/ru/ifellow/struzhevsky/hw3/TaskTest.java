package ru.ifellow.struzhevsky.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ifellow.struzhevsky.hw3.pages.DashboardPage;
import ru.ifellow.struzhevsky.hw3.pages.LoginPage;
import ru.ifellow.struzhevsky.hw3.pages.ProjectPage;
import ru.ifellow.struzhevsky.hw3.pages.TaskPage;
import ru.ifellow.struzhevsky.hw3.utils.TestData;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTest extends BaseTest {
    private LoginPage loginPage = new LoginPage();
    private ProjectPage projectPage = new ProjectPage();
    private DashboardPage dashboardPage = new DashboardPage();
    private TaskPage taskPage = new TaskPage();

    @Test
    @DisplayName("Проверка статуса и версии в задаче проекта")
    public void checkStatusAndVersionTask() {
        loginPage.auth(BaseTest.username, BaseTest.password);
        dashboardPage.goToProjectTest();
        projectPage.clickMenuTask();
        projectPage.clickLinkAllTask();
        String oldNameTest = taskPage.getNameTest();
        taskPage.findTask(TestData.FIND_TASK);
        taskPage.checkChangeName(oldNameTest);
        assertEquals(TestData.FIND_TASK, taskPage.getNameTest());
        assertEquals(TestData.STATUS_TASK.toUpperCase(), taskPage.checkStatus());
        assertEquals(TestData.VERSION_TASK, taskPage.checkVersion());
    }
}
