package ru.ifellow.struzhevsky.hw5.exercise1.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
    private static final String CONFIGURATION_FILE = "src/test/resources/test.properties";
    private static final Properties properties;
    private static FileInputStream fileInputStream;

    static {
        properties = new Properties();
        try {
            fileInputStream = new FileInputStream(CONFIGURATION_FILE);
            properties.load(fileInputStream);
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

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}