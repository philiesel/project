package hw4.io.cucumber.stepDefinitions;

import hw4.io.cucumber.hooks.Hooks;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.То;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;
import ru.ifellow.struzhevsky.hw3.pages.DashboardPage;
import ru.ifellow.struzhevsky.hw3.pages.LoginPage;
import ru.ifellow.struzhevsky.hw3.pages.ProfilePage;
import ru.ifellow.struzhevsky.hw3.utils.TestData;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthStepDefinitions {
    private final LoginPage loginPage = new LoginPage();
    private final DashboardPage dashboard = new DashboardPage();
    private ProfilePage profile;
    protected static String username = Hooks.username;
    protected static String password = Hooks.password;

    @Когда("есть на странице авторизации заголовок {string}")
    public void checkAuthHeader(String header) {
        assertEquals(header, loginPage.getHeaderAuthorization());
    }

    @Тогда("я ввожу логин и пароль")
    public void setCredentials() {
        loginPage.auth(username, password);
    }

    @То("я успешно авторизуюсь и перехожу на главную страницу")
    public void goToDashboard() {
        assertEquals(TestData.HEADER_DASHBOARD, dashboard.getHeaderDashboard());
    }

    @Тогда("я перехожу в мой профиль")
    public void goToProfile() {
        profile = dashboard.goToProfile();
    }

    @И("в заголовоке профиля отображается {string}")
    public void getTitleProfile(String header) {
        assertEquals(header, profile.getProfileTitle());
    }

    @И("имя пользователя в профиле соответствует моему логину")
    public void checkNameProfile() {
        Assertions.assertEquals(username, profile.getProfileName());
    }
}
