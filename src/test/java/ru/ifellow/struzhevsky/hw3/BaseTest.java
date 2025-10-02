package ru.ifellow.struzhevsky.hw3;

import com.codeborne.selenide.Selenide;
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
        url = properties.getProperty("url");
    }

    @BeforeEach
    public void setUp() {
        Selenide.clearBrowserCookies();
        open(url);
        getWebDriver().manage().window().maximize();
    }
}
