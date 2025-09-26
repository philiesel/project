package ru.ifellow.struzhevsky.hw3.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

/**
 * LoginPage – страница авторизации в JIRA.
 *
 * <p>Содержит элементы формы логина и методы для авторизации.</p>
 * <p>
 * Элементы:
 * - {@code usernameFieldLocator} – поле ввода имени пользователя
 * - {@code passwordFieldLocator} – поле ввода пароля
 * - {@code loginButtonLocator}   – кнопка входа в систему
 * - {@code headerAuthorizationLocator} – заголовок страницы "Вход в систему"
 * <p>
 * Методы:
 * - {@link #auth(String, String)} – авторизация с переходом на DashboardPage
 * - {@link #getHeaderAuthorization()} – получение текста заголовка для валидации
 */
public class LoginPage {
    private final SelenideElement usernameFieldLocator = $x("//input[@id='login-form-username']").as("Поле Username");
    private final SelenideElement passwordFieldLocator = $x("//input[@id='login-form-password']").as("Поле Password");
    private final SelenideElement loginButtonLocator = $x("//input[@name='login' and @value='Войти']").as("Кнопка войти");
    private final SelenideElement headerAuthorizationLocator = $x("//h3[@id='gadget-0-title']").as("Заголовок входа в систему");

    /**
     * Ввод имени пользователя.
     *
     * @param username имя пользователя (логин)
     */
    private void enterUsername(String username) {
        usernameFieldLocator.clear();
        usernameFieldLocator.setValue(username);
    }

    /**
     * Ввод пароля пользователя.
     *
     * @param password пароль пользователя
     */
    private void enterPassword(String password) {
        passwordFieldLocator.clear();
        passwordFieldLocator.setValue(password);
    }

    /**
     * Авторизация в системе.
     *
     * @param username имя пользователя
     * @param password пароль
     * @return объект {@link DashboardPage} после успешного входа
     */
    public DashboardPage auth(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        loginButtonLocator.click();
        return page(DashboardPage.class);
    }

    /**
     * Получение текста заголовка.
     *
     * @return текст заголовка
     */
    public String getHeaderAuthorization() {
        return headerAuthorizationLocator.text();
    }
}
