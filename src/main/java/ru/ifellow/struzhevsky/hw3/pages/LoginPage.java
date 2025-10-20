package ru.ifellow.struzhevsky.hw3.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Param;
import io.qameta.allure.Step;
import io.qameta.allure.model.Parameter;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;
import static io.qameta.allure.model.Parameter.Mode.MASKED;

public class LoginPage extends BasePage {
    private final SelenideElement usernameFieldLocator = $x("//input[@id='login-form-username']").as("Поле Username");
    private final SelenideElement passwordFieldLocator = $x("//input[@id='login-form-password']").as("Поле Password");
    private final SelenideElement loginButtonLocator = $x("//input[@name='login' and @value='Войти']").as("Кнопка войти");
    private final SelenideElement headerAuthorizationLocator = $x("//h3[@id='gadget-0-title']").as("Заголовок входа в систему");

    @Step("Ввод логина: {username}")
    private LoginPage enterUsername(String username) {
        clickAndSet(usernameFieldLocator, username);
        return this;
    }

    @Step("Ввод пароля: ")
    private LoginPage enterPassword(@Param(mode = MASKED) String password) {
        clickAndSet(passwordFieldLocator, password);
        return this;
    }

    @Step("Авторизация пользователем: {username}")
    public DashboardPage auth(String username, @Param(mode = MASKED) String password) {
        Allure.parameter("password", password, Parameter.Mode.MASKED);
        enterUsername(username);
        enterPassword(password);
        loginButtonLocator.click();
        return page(DashboardPage.class);
    }

    @Step("Получение заголовка авторизации")
    public String getHeaderAuthorization() {
        return headerAuthorizationLocator.text();
    }
}
