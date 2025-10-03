package ru.ifellow.struzhevsky.hw3.pages;

import com.codeborne.selenide.SelenideElement;

public class BasePage {
    protected void clickAndSet(SelenideElement element, String value) {
        element.click();
        element.clear();
        element.sendKeys(value);
    }
}
