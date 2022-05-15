import PageObject.PasswordRecovery;
import PageObject.LoginPage;
import PageObject.MainPage;
import PageObject.RegisterPage;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;

import static PageObject.PasswordRecovery.FORGOT_PASSWORD_URL;
import static PageObject.MainPage.MAIN_PAGE_URL;
import static PageObject.RegisterPage.REGISTER_PAGE_URL;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertEquals;

public class LoginOfUserTests {

    @After
    public void tearDown() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    @Test
    @DisplayName("вход по кнопке «Войти в аккаунт» на главной")
    public void checkLoginFromMainPageViaEntryButton() {
        MainPage main = open(MAIN_PAGE_URL, MainPage.class);
        main.clickAccountEntryButton();
        LoginPage login = page(LoginPage.class);
        login.entry(login.EMAIL, login.PASSWORD);
        login.waitAfterEntry();
        assertEquals(url(), MAIN_PAGE_URL);
    }

    @Test
    @DisplayName("вход через кнопку «Личный кабинет")
    public void checkLoginFromMainPageViaPersonalAccountButton() {
        MainPage main = open(MAIN_PAGE_URL, MainPage.class);
        main.clickPersonalAccountButton();
        LoginPage login = page(LoginPage.class);
        login.entry(login.EMAIL, login.PASSWORD);
        login.waitAfterEntry();
        assertEquals(url(), MAIN_PAGE_URL);
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void checkLoginFromRegistrationPageViaPersonalAccountButton() {
        RegisterPage register = open(REGISTER_PAGE_URL, RegisterPage.class);
        register.clickTheEntryButton();
        LoginPage login = page(LoginPage.class);
        login.entry(login.EMAIL, login.PASSWORD);
        login.waitAfterEntry();
        assertEquals(url(), MAIN_PAGE_URL);
    }

    @Test
    @DisplayName("вход через кнопку в форме восстановления пароля")
    public void checkLoginFromForgotPasswordPageViaEntryButton() {
        PasswordRecovery forgotPasswordPage = open(FORGOT_PASSWORD_URL, PasswordRecovery.class);
        forgotPasswordPage.clickTheEntryButton();
        LoginPage login = page(LoginPage.class);
        login.entry(login.EMAIL, login.PASSWORD);
        login.waitAfterEntry();
        assertEquals(url(), MAIN_PAGE_URL);
    }

}

