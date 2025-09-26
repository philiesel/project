package ru.ifellow.struzhevsky.hw3.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

/**
 * {@code ProfilePage} – страница профиля пользователя.
 *
 * <p>Содержит элементы и методы для получения информации о профиле.</p>
 * <p>
 * Элементы:
 * - {@code profileLocator} – заголовок страницы профиля
 * - {@code profileNameLocator} – имя пользователя в профиле
 * <p>
 * Методы:
 * - {@link #getProfileTitle()} – получение текста заголовка страницы профиля
 * - {@link #getProfileName()} – получение имени пользователя из профиля
 */
public class ProfilePage {
    private final SelenideElement profileLocator = $x("//div[@class='aui-page-header-main']/h2").as("Заголовок профиля");
    private final SelenideElement profileNameLocator = $x("//dd[@id='up-d-username']").as("Имя профиля");

    /**
     * Получение заголовка страницы профиля.
     *
     * @return заголовок страницы профиля как {@code String}.
     */
    public String getProfileTitle() {
        return profileLocator.text();
    }

    /**
     * Получение имени пользователя в профиле.
     *
     * @return имя пользователя как {@code String}.
     */
    public String getProfileName() {
        return profileNameLocator.text();
    }
}
