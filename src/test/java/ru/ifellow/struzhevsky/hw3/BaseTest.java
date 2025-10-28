package ru.ifellow.struzhevsky.hw3;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.ifellow.struzhevsky.hw3.utils.ServiceData;

import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;

public abstract class BaseTest {
    private static Properties properties;
    public static String username;
    public static String password;
    public static String url;
    private static WebDriver driver;


    @BeforeAll
    public static void setLoginAndPass() {
        properties = ServiceData.getDataOnFile();
        username = properties.getProperty("username");
        password = properties.getProperty("password");
        url = properties.getProperty("url");

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        driver = new ChromeDriver(options);

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false)
        );
    }

    @BeforeEach
    public void setUp() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.headless = true;
        open(url);
    }

    @AfterEach
    public void reset() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        if (driver != null) {
            driver.quit();
        }
    }
}
