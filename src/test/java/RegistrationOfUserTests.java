import PageObject.RegisterPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static PageObject.LoginPage.LOGIN_PAGE_URL;
import static PageObject.RegisterPage.REGISTER_PAGE_URL;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegistrationOfUserTests {

    @Test
    @DisplayName("Регистрация пользователя")
    public void UserRegistrationSuccess() {
        RegisterPage registerPage = open(REGISTER_PAGE_URL, RegisterPage.class);
        registerPage.registration(registerPage.NAME, registerPage.EMAIL, registerPage.PASSWORD);
        registerPage.waitAfterRegistration();
        assertEquals("The user is not registered" ,LOGIN_PAGE_URL, url());
    }

    @Test
    @DisplayName("Пароль меньше 6 символов")
    public void registrationWithPasswordLessThan6Characters() {
        RegisterPage registerPage = open(REGISTER_PAGE_URL, RegisterPage.class);
        registerPage.registration(registerPage.NAME, registerPage.EMAIL, "11111");
        assertTrue("Password less than 6 characters" ,registerPage.checkIncorrectPasswordSign());
    }
}

