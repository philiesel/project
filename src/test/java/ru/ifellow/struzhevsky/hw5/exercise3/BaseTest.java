package ru.ifellow.struzhevsky.hw5.exercise3;

import org.junit.jupiter.api.BeforeEach;
import ru.ifellow.struzhevsky.hw5.exercise3.steps.AuthorizationUser;
import ru.ifellow.struzhevsky.hw5.exercise3.steps.Registration;
import ru.ifellow.struzhevsky.hw5.exercise3.steps.UserLogout;

public class BaseTest {
    protected Registration registration;
    protected AuthorizationUser authorization;
    protected UserLogout userLogout;

    @BeforeEach
    public void setup() {
        registration = new Registration();
        authorization = new AuthorizationUser();
        userLogout = new UserLogout();
    }
}
