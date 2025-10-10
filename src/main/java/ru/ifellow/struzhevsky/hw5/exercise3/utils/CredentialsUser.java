package ru.ifellow.struzhevsky.hw5.exercise3.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static ru.ifellow.struzhevsky.hw5.exercise2.utils.Configuration.getProperty;

public class CredentialsUser {
    private final File file = new File(getProperty("pathCredentials"));
    private final ObjectMapper mapper = new ObjectMapper();

    private Map<String, String> changeCredentials(String username, String password) {
        Map<String, String> creds = new HashMap<>();
        try {
            creds = mapper.readValue(file, Map.class);
            if (username != null) creds.put("username", username);
            if (password != null) creds.put("password", password);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return creds;
    }

    public Map<String, String> changeLogin(String username) {
        return changeCredentials(username, null);
    }

    public Map<String, String> changePass(String password) {
        return changeCredentials(null, password
        );
    }

    public Map<String, String> getCredentials() {
        Map<String, String> data = new HashMap<>();
        try {
            data = mapper.readValue(file, Map.class);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return data;
    }
}
