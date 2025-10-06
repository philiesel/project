package ru.ifellow.struzhevsky.hw5.exercise3.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationFile {
    private static final String CONFIGURATION_FILE = "src/test/resources/test.properties";
    private static final Properties properties;
    private static FileInputStream stream;

    static {
        properties = new Properties();
        try {
            stream = new FileInputStream(CONFIGURATION_FILE);
            properties.load(stream);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (stream != null) {
                try {
                    stream.close();
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