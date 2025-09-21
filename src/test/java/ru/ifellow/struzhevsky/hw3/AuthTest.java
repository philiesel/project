package ru.ifellow.struzhevsky.hw3;

import org.junit.jupiter.api.Test;
import ru.ifellow.struzhevsky.hw3.pages.dashboard.DashboardPage;
import ru.ifellow.struzhevsky.hw3.pages.login.LoginPage;
import ru.ifellow.struzhevsky.hw3.pages.profile.ProfilePage;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthTest extends BaseTest {
    private final LoginPage loginPage = new LoginPage();

    @Test
    public void authTest() {
        assertEquals("Вход в систему", loginPage.getHeaderAuthorization());
        DashboardPage dashboard = loginPage.auth(BaseTest.username, BaseTest.password);
        ProfilePage profile = dashboard.goToProfile();
        assertEquals("Сводка", profile.getProfileTitle());
        assertEquals(BaseTest.username, profile.getProfileName());
    }
}
