package ru.ifellow.struzhevsky.hw3.pages.dashboard;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.ifellow.struzhevsky.hw3.pages.profile.ProfilePage;
import ru.ifellow.struzhevsky.hw3.pages.project.ProjectPage;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;


public class DashboardPage {
    private final SelenideElement buttonProfileLocator = $x("//a[@id='header-details-user-fullname']");
    private final SelenideElement linkProfileLocator = $x("//a[@id='view_profile']");
    private final SelenideElement menuProject = $x("//a[@id='browse_link']");
    private final SelenideElement linkProjectTest = $x("//a[@id='admin_main_proj_link_lnk']");

    public ProfilePage goToProfile() {
        buttonProfileLocator.click();
        linkProfileLocator.shouldBe(Condition.visible).click();
        return page(ProfilePage.class);
    }

    public ProjectPage goToProjectTest() {
        menuProject.shouldBe(Condition.visible).click();
        linkProjectTest.click();
        return page(ProjectPage.class);
    }
}
