package ru.ifellow.struzhevsky.hw3;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ifellow.struzhevsky.hw3.pages.dashboard.DashboardPage;
import ru.ifellow.struzhevsky.hw3.pages.login.LoginPage;
import ru.ifellow.struzhevsky.hw3.pages.project.ProjectPage;
import ru.ifellow.struzhevsky.hw3.pages.task.FormTask;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TotalCountTaskTest extends BaseTest{
    private LoginPage loginPage = new LoginPage();
    private ProjectPage projectPage = new ProjectPage();
    private DashboardPage dashboardPage = new DashboardPage();
    private FormTask formTask = new FormTask();
    private String descriptionTask = "Test Task";
    private String typeBugIssue = "Задача";

    @Test
    @DisplayName("Проверка общего количества заведенных задач в проекте")
    public void checkCountTask() {
        loginPage.auth(BaseTest.username, BaseTest.password);
        dashboardPage.goToProjectTest();
        projectPage.clickMenuTask();
        int countTask = projectPage.parsCountTaskOnProject();
        projectPage.clickButtNewTask();
        formTask.selectTypeBug(typeBugIssue);
        formTask.setFieldTopicTask(descriptionTask);
        formTask.clickButtCreateNewIssue();
        Selenide.refresh();
        int updateCountTask = projectPage.parsCountTaskOnProject();
        assertTrue(updateCountTask > countTask,   "Ожидалось, что количество задач увеличится, но оно не увеличилось");
    }
}
