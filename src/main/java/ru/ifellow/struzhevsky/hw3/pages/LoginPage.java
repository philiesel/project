package ru.ifellow.struzhevsky.hw3.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage extends BasePage {
    private final SelenideElement usernameFieldLocator = $x("//input[@id='login-form-username']").as("Поле Username");
    private final SelenideElement passwordFieldLocator = $x("//input[@id='login-form-password']").as("Поле Password");
    private final SelenideElement loginButtonLocator = $x("//input[@name='login' and @value='Войти']").as("Кнопка войти");
    private final SelenideElement headerAuthorizationLocator = $x("//h3[@id='gadget-0-title']").as("Заголовок входа в систему");

    private LoginPage enterUsername(String username) {
        clickAndSet(usernameFieldLocator, username);
        return this;
    }

    private LoginPage enterPassword(String password) {
        clickAndSet(passwordFieldLocator, password);
        return this;
    }

    public DashboardPage auth(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        loginButtonLocator.click();
        return page(DashboardPage.class);
    }

    public String getHeaderAuthorization() {
        return headerAuthorizationLocator.text();
    }
}
