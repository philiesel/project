package ru.ifellow.struzhevsky.hw5.exercise3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ifellow.struzhevsky.hw5.exercise3.steps.Registration;
import ru.ifellow.struzhevsky.hw5.exercise3.steps.UserLogout;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.not;

public class AuthTest {
    @Test
    @DisplayName("Тест на Регистрацию + Авторизацию + Выход из учетки")
    public void AuthTest() {
        String token = new Registration()
                .successRegistration()
                .unsuccessLoginAuth()
                .unsuccessPassAuth()
                .successCredentialsAuth();
        assertThat(token, not(emptyString()));
        new UserLogout()
                .logoutUnsuccessTest()
                .logoutSuccessTest(token);
    }
}
