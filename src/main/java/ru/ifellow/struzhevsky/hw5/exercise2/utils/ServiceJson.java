package ru.ifellow.struzhevsky.hw5.exercise2.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static ru.ifellow.struzhevsky.hw5.exercise2.utils.Configuration.getProperty;

public class ServiceJson {
    public static void writeJsonToFile() {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> value = new HashMap<>();
        value.put("name", "Potato");
        try {
            mapper.writeValue(new File(getProperty("pathSaveJson")), value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, String> changeJsonFile() {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> data = new HashMap<>();
        try {
            File file = new File(getProperty("pathSaveJson"));
            data = mapper.readValue(file, Map.class);
            data.put("name", "Tomato");
            data.put("job", "Eat maket");
        } catch (IOException exception) {
            exception.getStackTrace();
        }
        return data;
    }
}
