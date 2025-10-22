package ru.ifellow.struzhevsky.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ifellow.struzhevsky.hw3.pages.DashboardPage;
import ru.ifellow.struzhevsky.hw3.pages.LoginPage;
import ru.ifellow.struzhevsky.hw3.pages.ProjectPage;
import ru.ifellow.struzhevsky.hw3.pages.TaskPage;
import ru.ifellow.struzhevsky.hw3.utils.TestData;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Проверка статуса и версии задачи")
public class TaskTest extends BaseTest {
    private final LoginPage loginPage = new LoginPage();
    private final ProjectPage projectPage = new ProjectPage();
    private final DashboardPage dashboardPage = new DashboardPage();
    private final TaskPage taskPage = new TaskPage();

    @Test
    @DisplayName("Проверка статуса и версии в задаче проекта")
    public void checkStatusAndVersionTask() {
        loginPage.auth(BaseTest.username, BaseTest.password);
        dashboardPage.goToProjectTest();
        projectPage.clickMenuTask()
                .clickLinkAllTask();
        String oldNameTest = taskPage.getNameTest();
        taskPage.findTask(TestData.FIND_TASK)
                .checkChangeName(oldNameTest);
        assertEquals(TestData.FIND_TASK, taskPage.getNameTest());
        assertEquals(TestData.STATUS_TASK.toUpperCase(), taskPage.checkStatus());
        assertEquals(TestData.VERSION_TASK, taskPage.checkVersion());
    }
}
