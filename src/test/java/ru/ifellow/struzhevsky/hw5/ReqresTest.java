package ru.ifellow.struzhevsky.hw5;

import ru.ifellow.struzhevsky.hw5.exercise2.api.UserApiReqres;
import ru.ifellow.struzhevsky.hw5.exercise2.utils.ServiceJson;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class ReqresTest {
    private final UserApiReqres userApi = new UserApiReqres();

    @Test
    public void createUserTest() {
        ServiceJson.writeJsonToFile();
        Map<String, String> data = ServiceJson.changeJsonFile();
        userApi.createUserWithJson(data);
    }
}
