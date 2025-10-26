package ru.ifellow.struzhevsky.hw3;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.ifellow.struzhevsky.hw3.utils.ServiceData;

import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public abstract class BaseTest {
    private static Properties properties;
    public static String username;
    public static String password;
    public static String url;

    @BeforeAll
    public static void setLoginAndPass() {
        properties = ServiceData.getDataOnFile();
        username = properties.getProperty("username");
        password = properties.getProperty("password");
        boolean screenshots = Boolean.parseBoolean(properties.getProperty("allure.selenide.screenshots"));
        boolean allureReportPath = Boolean.parseBoolean(properties.getProperty("allure.selenide.savePageSource"));
        boolean includeSelenideSteps = Boolean.parseBoolean(properties.getProperty("allure.selenide.includeSelenideSteps"));
        url = properties.getProperty("url");
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(screenshots)
                .savePageSource(allureReportPath)
                .includeSelenideSteps(includeSelenideSteps)
        );
    }

    @BeforeEach
    public void setUp() {
        Allure.step("Веб-сайт открыт");
        open(url);
        getWebDriver().manage().window().maximize();
        Configuration.pageLoadStrategy = "eager";
    }

    @AfterEach
    public void reset() {
        Allure.step("Веб-сайт закрыт");
        SelenideLogger.removeListener("AllureSelenide");
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWebDriver();
    }
}
