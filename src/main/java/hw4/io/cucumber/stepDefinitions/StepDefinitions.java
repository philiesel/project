package hw4.io.cucumber.stepDefinitions;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.То;
import ru.ifellow.struzhevsky.hw3.pages.FormTask;
import ru.ifellow.struzhevsky.hw3.pages.ProjectPage;
import ru.ifellow.struzhevsky.hw3.utils.TestData;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepDefinitions {
    private final ProjectPage projectPage = new ProjectPage();
    private final FormTask formTask = new FormTask();
    private int countTask;
    private int updateCountTask;

    @И("я сохраняю текущее количество задач")
    public void saveCurrentCountTask() {
        countTask = projectPage.parsCountTaskOnProject();
    }

    @Когда("я создаю новую задачу с типом {string} и темой {string}")
    public void createNewTask(String arg0, String arg1) {
        projectPage.clickButtNewTask();
        formTask.selectTypeBug(arg0)
                .setFieldTopicTask(arg1)
                .clickButtCreateNewIssue();
        updateCountTask = projectPage.parseUpdateCountTaskOnProject(countTask);
    }

    @То("количество задач должно увеличиться")
    public void checkCountTask() {
        assertTrue(updateCountTask > countTask, "Ожидалось, что количество задач увеличится, но оно не увеличилось");
    }

    @И("я создаю новый баг с описанием")
    public void createNewBugWithDescription() {
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
    }

    @То("задача с описанием должна быть успешно создана")
    public void checkCreateNewTask() {
        assertTrue(formTask.getStatusTask(), "Задача не была создана!");
    }
}
