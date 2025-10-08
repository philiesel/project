package hw4.io.cucumber.hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import ru.ifellow.struzhevsky.hw3.utils.ServiceData;

import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Hooks {
    public static Properties properties;
    public static String username;
    public static String password;
    public static String url;

    @BeforeAll
    public static void tup() {
        properties = ServiceData.getDataOnFile();
        username = properties.getProperty("username");
        password = properties.getProperty("password");
        url = properties.getProperty("url");
    }

    @Before("@tag")
    public void setUp() {
        open(url);
        getWebDriver().manage().window().maximize();
        Configuration.pageLoadStrategy = "eager";
    }

    @After("@tag")
    public void reset() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWebDriver();
    }
}
