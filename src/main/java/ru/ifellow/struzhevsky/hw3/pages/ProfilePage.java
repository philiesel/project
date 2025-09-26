package ru.ifellow.struzhevsky.hw3.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;


public class ProfilePage {
    private final SelenideElement profileLocator = $x("//div[@class='aui-page-header-main']/h2").as("Заголовок профиля");
    private final SelenideElement profileNameLocator = $x("//dd[@id='up-d-username']").as("Имя профиля");

    public String getProfileTitle() {
        return profileLocator.text();
    }

    public String getProfileName() {
        return profileNameLocator.text();
    }
}
