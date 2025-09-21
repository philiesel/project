package ru.ifellow.struzhevsky.hw3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.ifellow.struzhevsky.hw3.pages.dashboard.DashboardPage;
import ru.ifellow.struzhevsky.hw3.pages.login.LoginPage;
import ru.ifellow.struzhevsky.hw3.pages.project.ProjectPage;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkToProjectTest extends BaseTest {
    private final LoginPage loginPage = new LoginPage();
    private final DashboardPage dashboardPage = new DashboardPage();
    private final ProjectPage projectPage = new ProjectPage();

    @ParameterizedTest
    @ValueSource(strings = {"TEST"})
    public void goToProjectTest(String metaValue) {
        loginPage.auth(BaseTest.username, BaseTest.password);
        dashboardPage.goToProjectTest();
        projectPage.clickButtAvatar();
        assertEquals(metaValue, projectPage.getMetaValueProject());
    }
}
