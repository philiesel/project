package ru.ifellow.struzhevsky.hw3.pages.login;

import com.codeborne.selenide.SelenideElement;
import ru.ifellow.struzhevsky.hw3.pages.dashboard.DashboardPage;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;


public class LoginPage {
    private final SelenideElement usernameFieldLocator = $x("//input[@id='login-form-username']");
    private final SelenideElement passwordFieldLocator = $x("//input[@id='login-form-password']");
    private final SelenideElement loginButtonLocator = $x("//input[@name='login' and @value='Войти']");
    private final SelenideElement headerAuthorizationLocator  = $x("//h3[@id='gadget-0-title']");

    private void enterUsername(String username) {
        usernameFieldLocator.setValue(username);
    }

    private void enterPassword(String password) {
        passwordFieldLocator.setValue(password);
    }

    public DashboardPage auth(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        loginButtonLocator.click();
        return page(DashboardPage.class);
    }

    public String getHeaderAuthorization () {
        return headerAuthorizationLocator.text();
    }
}
