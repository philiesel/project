package ru.ifellow.struzhevsky.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ifellow.struzhevsky.hw3.pages.DashboardPage;
import ru.ifellow.struzhevsky.hw3.pages.LoginPage;
import ru.ifellow.struzhevsky.hw3.pages.ProfilePage;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthTest extends BaseTest {
    private final LoginPage loginPage = new LoginPage();
    private final String headerAuth = "Вход в систему";
    private final String profileTitle = "Сводка";

    @Test
    @DisplayName("Пользователь может авторизоваться")
    public void authTest() {
        assertEquals(headerAuth, loginPage.getHeaderAuthorization());
        DashboardPage dashboard = loginPage.auth(BaseTest.username, BaseTest.password);   //  DashboardPage dashboard вынести в класс
        ProfilePage profile = dashboard.goToProfile();
        assertEquals(profileTitle, profile.getProfileTitle());
        assertEquals(BaseTest.username, profile.getProfileName());
    }
}
