package hw4.io.cucumber.steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import ru.ifellow.struzhevsky.hw3.pages.ProjectPage;
import ru.ifellow.struzhevsky.hw3.pages.TaskPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InfoProjectStepDefinitions {
    private final TaskPage taskPage = new TaskPage();
    private final ProjectPage projectPage = new ProjectPage();

    @И("я перехожу в раздел задач")
    public void clickAllTask() {
        projectPage.clickMenuTask()
                .clickLinkAllTask();
    }

    @И("я нахожу задачу с названием {string}")
    public void findTask(String arg0) {
        String oldNameTest = taskPage.getNameTest();
        taskPage.findTask(arg0)
                .checkChangeName(oldNameTest);
    }

    @Тогда("название задачи должно быть равно {string}")
    public void checNameTask(String arg0) {
        assertEquals(arg0, taskPage.getNameTest());
    }

    @И("статус задачи должен быть {string}")
    public void checkStatus(String arg0) {
        assertEquals(arg0.toUpperCase(), taskPage.checkStatus());
    }

    @И("версия задачи должна быть {string}")
    public void checkVersionTask(String arg0) {
        assertEquals(arg0, taskPage.checkVersion());
    }
}
