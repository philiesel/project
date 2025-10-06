package ru.ifellow.struzhevsky.hw5.exercise3;

import org.junit.jupiter.api.Test;
import ru.ifellow.struzhevsky.hw5.exercise3.steps.Authorization;
import ru.ifellow.struzhevsky.hw5.exercise3.steps.Registration;

public class AuthTest {
    private final Registration registration = new Registration();
    private final Authorization authorization = new Authorization();

    @Test
    public void AuthTest() {
        registration.successRegistration();
        authorization.unsuccessLoginAuth("Serjio");
//        unsuccessAuthPass();
//        authWithValidCredentials();
//        unsuccessUserLogout();
//        successUserLogout();
    }
}
