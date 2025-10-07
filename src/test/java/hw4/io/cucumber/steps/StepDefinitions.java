package hw4.io.cucumber.steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.То;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import ru.ifellow.struzhevsky.hw3.pages.*;
import ru.ifellow.struzhevsky.hw3.utils.ServiceData;
import ru.ifellow.struzhevsky.hw3.utils.TestData;

import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepDefinitions {
    private final LoginPage loginPage = new LoginPage();
    private DashboardPage dashboard = new DashboardPage();
    private ProfilePage profile = new ProfilePage();
    private final DashboardPage dashboardPage = new DashboardPage();
    private final ProjectPage projectPage = new ProjectPage();
    private TaskPage taskPage = new TaskPage();
    private FormTask formTask = new FormTask();
    private int countTask;
    private int updateCountTask;
    protected static Properties properties;
    protected static String username;
    protected static String password;
    protected static String url;

    @BeforeAll
    public static void beforeAllTests() {
        properties = ServiceData.getDataOnFile();
        username = properties.getProperty("username");
        password = properties.getProperty("password");
        url = properties.getProperty("url");
    }

    @Before
    public void setUp() {
        open(url);
        getWebDriver().manage().window().maximize();
        Configuration.pageLoadStrategy = "eager";
    }


    @Когда("есть на странице авторизации заголовок {string}")
    public void checkAuthHeader(String header) {
        assertEquals(header, loginPage.getHeaderAuthorization());
    }

    @Тогда("я ввожу логин и пароль")
    public void яВвожуЛогинИПароль() {
        loginPage.auth(username, password);
    }

    @То("я успешно авторизуюсь и перехожу на главную страницу")
    public void яУспешноАвторизуюсьИПерехожуНаГлавнуюСтраницу() {
        assertEquals(TestData.HEADER_DASHBOARD, dashboard.getHeaderDashboard());
    }

    @Тогда("я перехожу в мой профиль")
    public void яПерехожуВМойПрофиль() {
        profile = dashboard.goToProfile();
    }

    @И("в заголовоке профиля отображается {string}")
    public void вЗаголовокеПрофиляОтображается(String header) {
        assertEquals(header, profile.getProfileTitle());
    }

    @И("имя пользователя в профиле соответствует моему логину")
    public void имяПользователяВПрофилеСоответствуетМоемуЛогину() {
        Assertions.assertEquals(username, profile.getProfileName());
    }

    @Тогда("я перехожу на страницу проекта")
    public void яПерехожуНаСтраницуПроекта() {
        dashboardPage.goToProjectTest();
    }

    @И("я кликаю на аватар")
    public void яКликаюНаАватар() {
        projectPage.clickButtAvatar();
    }

    @То("значение мета-данных проекта должно быть {string}")
    public void значениеМетаДанныхПроектаДолжноБыть(String nameProject) {
        assertEquals(nameProject, projectPage.getMetaValueProject());
    }

    @И("я перехожу в раздел задач")
    public void яПерехожуВРазделЗадач() {
        projectPage.clickMenuTask()
                .clickLinkAllTask();
    }

    @И("я нахожу задачу с названием {string}")
    public void яНахожуЗадачуСНазванием(String arg0) {
        String oldNameTest = taskPage.getNameTest();
        taskPage.findTask(arg0)
                .checkChangeName(oldNameTest);
    }

    @Тогда("название задачи должно быть равно {string}")
    public void названиеЗадачиДолжноБытьРавно(String arg0) {
        assertEquals(TestData.FIND_TASK, taskPage.getNameTest());
    }

    @И("статус задачи должен быть {string}")
    public void статусЗадачиДолженБыть(String arg0) {
        assertEquals(arg0.toUpperCase(), taskPage.checkStatus());
    }

    @И("версия задачи должна быть {string}")
    public void версияЗадачиДолжнаБыть(String arg0) {
        assertEquals(arg0, taskPage.checkVersion());
    }

    @И("я сохраняю текущее количество задач")
    public void яСохраняюТекущееКоличествоЗадач() {
        countTask = projectPage.parsCountTaskOnProject();
    }

    @Когда("я создаю новую задачу с типом {string} и темой {string}")
    public void яСоздаюНовуюЗадачуСТипомИТемой(String arg0, String arg1) {
        projectPage.clickButtNewTask();
        formTask.selectTypeBug(arg0)
                .setFieldTopicTask(arg1)
                .clickButtCreateNewIssue();
        updateCountTask = projectPage.parseUpdateCountTaskOnProject(countTask);
    }

    @То("количество задач должно увеличиться")
    public void количествоЗадачДолжноУвеличитьсяНа() {
        assertTrue(updateCountTask > countTask, "Ожидалось, что количество задач увеличится, но оно не увеличилось");
    }

    @AfterEach
    public void close() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWebDriver();
    }


    @И("я создаю новый баг с описанием")
    public void яСоздаюНовыйБагСОписанием() {
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
    public void задачаСОписаниемДолжнаБытьУспешноСоздана() {
        assertTrue(formTask.getStatusTask(), "Задача не была создана!");
    }
}
