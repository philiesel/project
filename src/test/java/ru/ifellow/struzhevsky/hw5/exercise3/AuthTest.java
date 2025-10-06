package ru.ifellow.struzhevsky.hw5.exercise3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.not;

public class AuthTest extends BaseTest {
    @Test
    @DisplayName("Тест на Регистрацию + Авторизацию + Выход из учетки")
    public void AuthTest() {
        registration.successRegistration();
        authorization.unsuccessLoginAuth();
        authorization.unsuccessPassAuth();
        String token = authorization.successCredentialsAuth();
        assertThat(token, not(emptyString()));
        userLogout.logoutUnsuccessTest();
        userLogout.logoutSuccessTest(token);
    }
}
