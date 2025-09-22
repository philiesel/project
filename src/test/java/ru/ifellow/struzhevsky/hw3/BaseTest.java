package ru.ifellow.struzhevsky.hw3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {
    private static Properties properties = new Properties();
    private static FileInputStream fileInputStream = null;
    public static String username = null;
    public static String password = null;
    public static String url = null;
    private static final String pathConfig = "src/test/resources/config.properties";

    @BeforeAll
    public static void setLoginAndPass() {
        try {
            fileInputStream = new FileInputStream(pathConfig);
            properties.load(fileInputStream);
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    System.out.println("Нет такого файла");
                }
            }
        }
    }

    @BeforeEach
    public void setUp() {
        open(url);
        getWebDriver().manage().window().maximize();     // TODO исправить сделать в пропертис селенида
    }
}
