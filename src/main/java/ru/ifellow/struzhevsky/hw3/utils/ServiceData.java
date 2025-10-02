package ru.ifellow.struzhevsky.hw3.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ServiceData {
    private static final String pathConfig = "src/test/resources/config.properties";
    private static FileInputStream fileInputStream;

    public static Properties getDataOnFile() {
        Properties properties = new Properties();
        try {
            fileInputStream = new FileInputStream(pathConfig);   //вынести в отдельный класс
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
        return properties;
    }
}
