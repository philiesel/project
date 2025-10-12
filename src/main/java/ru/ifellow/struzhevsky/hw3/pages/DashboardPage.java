package ru.ifellow.struzhevsky.hw3.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;


public class DashboardPage {
    private final SelenideElement buttonProfileLocator = $x("//a[@id='header-details-user-fullname']").as("Пользовательский профиль");
    private final SelenideElement linkProfileLocator = $x("//a[@id='view_profile']").as("Меню \"Профиль\"");
    private final SelenideElement menuProject = $x("//a[@id='browse_link']").as("Меню \"Проекты\"");
    private final SelenideElement linkProjectTest = $x("//a[@id='admin_main_proj_link_lnk']").as("Меню проект \"Test\"");

    @Step("Перейти в раздел \"Профиль\"")
    public ProfilePage goToProfile() {
        buttonProfileLocator.click();
        linkProfileLocator.shouldBe(Condition.visible).click();
        return page(ProfilePage.class);
    }

    @Step("Перейти в проект")
    public ProjectPage goToProjectTest() {
        menuProject.shouldBe(Condition.visible).click();
        linkProjectTest.click();
        return page(ProjectPage.class);
    }
}
