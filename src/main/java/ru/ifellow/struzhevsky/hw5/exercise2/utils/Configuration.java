package ru.ifellow.struzhevsky.hw5.exercise2.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
    private static final String CONFIGURATION_FILE = "src/test/resources/test.properties";
    private static final Properties properties;

    static {
        properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(CONFIGURATION_FILE)) {
            properties.load(fileInputStream);
        } catch (IOException ex) {
            ex.getStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}