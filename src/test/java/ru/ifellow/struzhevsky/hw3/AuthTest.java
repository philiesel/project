package ru.ifellow.struzhevsky.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ifellow.struzhevsky.hw3.pages.DashboardPage;
import ru.ifellow.struzhevsky.hw3.pages.LoginPage;
import ru.ifellow.struzhevsky.hw3.pages.ProfilePage;
import ru.ifellow.struzhevsky.hw3.utils.TestData;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthTest extends BaseTest {
    private final LoginPage loginPage = new LoginPage();
    private DashboardPage dashboard = new DashboardPage();
    private ProfilePage profile = new ProfilePage();

    @Test
    @DisplayName("Пользователь может авторизоваться")
    public void authTest() {
        assertEquals(TestData.HEADER_AUTH, loginPage.getHeaderAuthorization());
        dashboard = loginPage.auth(BaseTest.username, BaseTest.password);
        profile = dashboard.goToProfile();
        assertEquals(TestData.PROFILE_TITLE, profile.getProfileTitle());
        assertEquals(BaseTest.username, profile.getProfileName());
    }
}
