package hw4.io.cucumber.steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.То;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;
import ru.ifellow.struzhevsky.hw3.pages.DashboardPage;
import ru.ifellow.struzhevsky.hw3.pages.LoginPage;
import ru.ifellow.struzhevsky.hw3.pages.ProfilePage;
import ru.ifellow.struzhevsky.hw3.utils.ServiceData;
import ru.ifellow.struzhevsky.hw3.utils.TestData;

import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {
    private final LoginPage loginPage = new LoginPage();
    private DashboardPage dashboard = new DashboardPage();
    private ProfilePage profile = new ProfilePage();

    protected static Properties properties;
    protected static String username;
    protected static String password;
    protected static String url;

    @Before
    public void setUp() {
        properties = ServiceData.getDataOnFile();
        username = properties.getProperty("username");
        password = properties.getProperty("password");
        url = properties.getProperty("url");
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

    @After
    public void reset() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWebDriver();
    }
}
