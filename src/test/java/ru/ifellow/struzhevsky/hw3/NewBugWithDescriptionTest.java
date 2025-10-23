package ru.ifellow.struzhevsky.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ifellow.struzhevsky.hw3.helper.FixVersion;
import ru.ifellow.struzhevsky.hw3.helper.Priority;
import ru.ifellow.struzhevsky.hw3.helper.RelatedTask;
import ru.ifellow.struzhevsky.hw3.helper.TypeTask;
import ru.ifellow.struzhevsky.hw3.pages.DashboardPage;
import ru.ifellow.struzhevsky.hw3.pages.FormTask;
import ru.ifellow.struzhevsky.hw3.pages.LoginPage;
import ru.ifellow.struzhevsky.hw3.pages.ProjectPage;
import ru.ifellow.struzhevsky.hw3.utils.ServiceData;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Создание нового бага")
public class NewBugWithDescriptionTest extends BaseTest {
    private final LoginPage loginPage = new LoginPage();
    private final ProjectPage projectPage = new ProjectPage();
    private final DashboardPage dashboardPage = new DashboardPage();
    private final FormTask formTask = new FormTask();
    private final Properties properties = ServiceData.getDataOnFile();

    @Test
    @DisplayName("Проверка заведения нового бага с описанием")
    public void createNewBugWithDescription() {
        loginPage.auth(BaseTest.username, BaseTest.password);
        dashboardPage.goToProjectTest();
        projectPage.clickMenuTask()
                .clickButtNewTask();
        formTask.selectVisualButtonOnDescriptionTask()
                .selectTypeTask(TypeTask.TYPE_ERROR.getTask())
                .setFieldTopicTask(properties.getProperty("TOPIC_BUG"))
                .setDescriptionTask(properties.getProperty("DESCRIPTION_TASK"))
                .setFixVersion(FixVersion.VER_UNKNOWN.getVersion())
                .selectPriorityField(Priority.PRIORITY_MEDIUM.getPriority())
                .setTag(properties.getProperty("TAG"))
                .setEnvironmentDescription(properties.getProperty("ENVIRONMENT_DESCRIPTION"))
                .setAffectedVersions(properties.getProperty("AFFECTED_VERSION"))
                .setRelatedTasksLocator(RelatedTask.RELATED_BLOCK.getRelated())
                .setTask(properties.getProperty("TASK"))
                .clickButtAssignToMe()
                .setSprint(properties.getProperty("SPRINT"))
                .setSeriousness(properties.getProperty("SERIOUSNESS"))
                .clickButtCreateNewIssue();
        assertTrue(formTask.getStatusTask(), "Задача не была создана!");
    }
}
