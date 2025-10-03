package ru.ifellow.struzhevsky.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ifellow.struzhevsky.hw3.pages.DashboardPage;
import ru.ifellow.struzhevsky.hw3.pages.FormTask;
import ru.ifellow.struzhevsky.hw3.pages.LoginPage;
import ru.ifellow.struzhevsky.hw3.pages.ProjectPage;
import ru.ifellow.struzhevsky.hw3.utils.TestData;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TotalCountTaskTest extends BaseTest {
    private LoginPage loginPage = new LoginPage();
    private ProjectPage projectPage = new ProjectPage();
    private DashboardPage dashboardPage = new DashboardPage();
    private FormTask formTask = new FormTask();

    @Test
    @DisplayName("Проверка общего количества заведенных задач в проекте")
    public void checkCountTask() {
        loginPage.auth(BaseTest.username, BaseTest.password);
        dashboardPage.goToProjectTest();
        projectPage.clickMenuTask();
        int countTask = projectPage.parsCountTaskOnProject();
        projectPage.clickButtNewTask();
        formTask.selectTypeBug(TestData.TYPE_BUG_ISSUE)
                .setFieldTopicTask(TestData.DESCRIPTION_TASK)
                .clickButtCreateNewIssue();
        int updateCountTask = projectPage.parseUpdateCountTaskOnProject(countTask);
        assertTrue(updateCountTask > countTask, "Ожидалось, что количество задач увеличится, но оно не увеличилось");
    }
}
