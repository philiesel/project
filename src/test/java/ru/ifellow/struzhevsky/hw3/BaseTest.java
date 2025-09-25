package ru.ifellow.struzhevsky.hw3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {  // сделать абстрактным
    private static Properties properties = new Properties();
    private static FileInputStream fileInputStream;
    public static String username;
    public static String password;
    public static String url;
    private static final String pathConfig = "src/test/resources/config.properties";

    @BeforeAll
    public static void setLoginAndPass() {
        try {
            fileInputStream = new FileInputStream(pathConfig);   //вынести в отдельный класс
            properties.load(fileInputStream);
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {  // убрать finally
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
