import PageObject.LoginPage;
import PageObject.MainPage;
import PageObject.PersonalAccountPage;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static PageObject.LoginPage.LOGIN_PAGE_URL;
import static PageObject.MainPage.MAIN_PAGE_URL;
import static PageObject.PersonalAccountPage.PERSONAL_ACCOUNT_PAGE_URL;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertEquals;

public class PersonalAccountPageTests {

    @Before
    public void login() {
        MainPage main = open(MAIN_PAGE_URL, MainPage.class);
        main.clickAccountEntryButton();
        LoginPage login = page(LoginPage.class);
        login.entry(login.EMAIL, login.PASSWORD);
    }

    @After
    public void tearDown() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    @Test
    @DisplayName("переход по клику на «Личный кабинет")
    public void checkTheTransitionToThePersonalAccountPage() {
        MainPage main = page(MainPage.class);
        main.clickPersonalAccountButton();
        PersonalAccountPage personalAccountPage = page(PersonalAccountPage.class);
        personalAccountPage.waitAfterTransition();
        assertEquals(url(), PERSONAL_ACCOUNT_PAGE_URL);
    }

    @Test
    @DisplayName("Переход по клику на «Конструктор»")
    public void checkTheTransitionAfterClickConstructorButton() {
        MainPage main = page(MainPage.class);
        main.clickPersonalAccountButton();
        PersonalAccountPage personalAccountPage = page(PersonalAccountPage.class);
        personalAccountPage.waitAfterTransition();
        personalAccountPage.clickTheConstructorButton();
        assertEquals(url(), MAIN_PAGE_URL);
    }

    @Test
    @DisplayName("Переход по клику на логотип Stellar Burgers")
    public void checkTheTransitionAfterClickLogo() {
        MainPage main = page(MainPage.class);
        main.clickPersonalAccountButton();
        PersonalAccountPage personalAccountPage = page(PersonalAccountPage.class);
        personalAccountPage.waitAfterTransition();
        personalAccountPage.clickTheLogo();
        assertEquals(url(), MAIN_PAGE_URL);
    }

    @Test
    @DisplayName("выход по кнопке «Выйти» в личном кабинете")
    public void checkTheTransitionAfterLogOut() {
        MainPage main = page(MainPage.class);
        main.clickPersonalAccountButton();
        PersonalAccountPage personalAccountPage = page(PersonalAccountPage.class);
        personalAccountPage.waitAfterTransition();
        personalAccountPage.clickTheLogOutButton();
        personalAccountPage.waitAfterLogOut();
        assertEquals(url(), LOGIN_PAGE_URL);
    }

}
