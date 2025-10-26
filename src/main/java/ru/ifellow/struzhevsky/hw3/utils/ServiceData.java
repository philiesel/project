package ru.ifellow.struzhevsky.hw3.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class ServiceData {
    private static final String CONFIG_PATH = "src/test/resources/config.properties";
    private static final String TEST_DATA_PATH = "src/test/resources/testData.properties";
    private static final String ALLURE_PROPERTIES_PATH = "src/test/resources/allure.properties";

    public static Properties getDataOnFile() {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(CONFIG_PATH)) {
            properties.load(fileInputStream);
        } catch (IOException exception) {
            exception.getStackTrace();
        }
        try (InputStreamReader reader = new InputStreamReader(
                new FileInputStream(ALLURE_PROPERTIES_PATH))) {
            properties.load(reader);
        } catch (IOException exception) {
            exception.getStackTrace();
        }
        try (InputStreamReader reader = new InputStreamReader(
                new FileInputStream(TEST_DATA_PATH), StandardCharsets.UTF_8)) {
            properties.load(reader);
        } catch (IOException exception) {
            exception.getStackTrace();
        }
        return properties;
    }
}
