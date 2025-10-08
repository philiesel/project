package hw4.io.cucumber.steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.То;
import io.cucumber.java.ru.Тогда;
import ru.ifellow.struzhevsky.hw3.pages.DashboardPage;
import ru.ifellow.struzhevsky.hw3.pages.ProjectPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkToProjectStepDefinitions {
    private final ProjectPage projectPage = new ProjectPage();
    private final DashboardPage dashboardPage = new DashboardPage();

    @Тогда("я перехожу на страницу проекта")
    public void goToProjectTest() {
        dashboardPage.goToProjectTest();
    }

    @И("я кликаю на аватар")
    public void clickAvatar() {
        projectPage.clickButtAvatar();
    }

    @То("значение мета-данных проекта должно быть {string}")
    public void checkMetaData(String nameProject) {
        assertEquals(nameProject, projectPage.getMetaValueProject());
    }
}
