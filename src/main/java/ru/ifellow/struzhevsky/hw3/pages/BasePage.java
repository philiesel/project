package ru.ifellow.struzhevsky.hw3.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.switchTo;

public class BasePage {
    protected void clickAndSet(SelenideElement element, String value) {
        element.click();
        element.clear();
        element.sendKeys(value);
    }

    protected void setValToFrameArea(SelenideElement frames, SelenideElement area, String value) {
        frames.scrollTo();
        frames.shouldBe(Condition.visible);
        switchTo().frame(frames);
        area.click();
        area.setValue(value);
        switchTo().defaultContent();
    }
}
