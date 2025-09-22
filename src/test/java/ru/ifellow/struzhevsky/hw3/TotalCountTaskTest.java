package ru.ifellow.struzhevsky.hw3;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import ru.ifellow.struzhevsky.hw3.pages.dashboard.DashboardPage;
import ru.ifellow.struzhevsky.hw3.pages.login.LoginPage;
import ru.ifellow.struzhevsky.hw3.pages.project.ProjectPage;
import ru.ifellow.struzhevsky.hw3.pages.task.FormTask;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TotalCountTaskTest extends BaseTest{
    private LoginPage loginPage = new LoginPage();
    private ProjectPage projectPage = new ProjectPage();
    private DashboardPage dashboardPage = new DashboardPage(); //Возможно стоит убрать
    private FormTask formTask = new FormTask();
    private String descriptionTask = "Test Task";
    private String typeBugIssue = "Задача";

    @Test
    public void checkCountTask() {
        loginPage.auth(BaseTest.username, BaseTest.password);
        dashboardPage.goToProjectTest();
        projectPage.clickMenuTask();
        int countTask = projectPage.parsCountTaskOnProject();
        projectPage.clickButtNewTask();
        formTask.selectTypeBug(typeBugIssue);
        formTask.fillFieldTopicTask(descriptionTask);
        formTask.clickButtCreateNewIssue();
        Selenide.refresh();
        int updateCountTask = projectPage.parsCountTaskOnProject();
        assertEquals(countTask+1, updateCountTask);
    }
}
