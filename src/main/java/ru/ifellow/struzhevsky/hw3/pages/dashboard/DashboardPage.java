package ru.ifellow.struzhevsky.hw3.pages.dashboard;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.ifellow.struzhevsky.hw3.pages.profile.ProfilePage;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class DashboardPage {
    private final SelenideElement buttonProfileLocator = $x("//a[@id='header-details-user-fullname']");
    private final SelenideElement linkProfileLocator = $x("//a[@id='view_profile']");

    public ProfilePage goToProfile() {
        buttonProfileLocator.click();
        linkProfileLocator.shouldBe(Condition.visible).click();
        return page(ProfilePage.class);
    }
}
