package ru.ifellow.struzhevsky.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ifellow.struzhevsky.hw3.pages.DashboardPage;
import ru.ifellow.struzhevsky.hw3.pages.LoginPage;
import ru.ifellow.struzhevsky.hw3.pages.ProjectPage;
import ru.ifellow.struzhevsky.hw3.pages.TaskPage;
import ru.ifellow.struzhevsky.hw3.utils.ServiceData;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Проверка статуса и версии задачи")
public class TaskTest extends BaseTest {
    private final LoginPage loginPage = new LoginPage();
    private final ProjectPage projectPage = new ProjectPage();
    private final DashboardPage dashboardPage = new DashboardPage();
    private final TaskPage taskPage = new TaskPage();
    private final Properties properties = ServiceData.getDataOnFile();

    @Test
    @DisplayName("Проверка статуса и версии в задаче проекта")
    public void checkStatusAndVersionTask() {
        loginPage.auth(BaseTest.username, BaseTest.password);
        dashboardPage.goToProjectTest();
        projectPage.clickMenuTask()
                .clickLinkAllTask();
        String oldNameTest = taskPage.getNameTest();
        taskPage.findTask(properties.getProperty("FIND_TASK"))
                .checkChangeName(oldNameTest);
        assertEquals(properties.getProperty("FIND_TASK"), taskPage.getNameTest());
        assertEquals(properties.getProperty("STATUS_TASK").toUpperCase(), taskPage.checkStatus());
        assertEquals(properties.getProperty("VERSION_TASK"), taskPage.checkVersion());
    }
}
