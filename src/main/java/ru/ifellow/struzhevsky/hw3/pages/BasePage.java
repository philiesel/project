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

    protected void setValToFrameArea(SelenideElement frame, SelenideElement area, String value) {
        frame.scrollTo();
        frame.shouldBe(Condition.visible);
        switchTo().frame(frame.toWebElement());
        area.click();
        area.setValue(value);
        switchTo().defaultContent();
    }
}
