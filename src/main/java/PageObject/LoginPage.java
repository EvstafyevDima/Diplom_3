package PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    public static final String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";
    public final String EMAIL = "Drema.xxx@mil.ru";
    public final String PASSWORD = "67306730";

    @FindBy(how = How.XPATH, using = ".//input[@name='name']")
    public SelenideElement emailField;

    @FindBy(how = How.XPATH, using = ".//input[@name='Пароль']")
    public SelenideElement passwordField;

    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    private SelenideElement entryButton;

    @Step("Ввод почты")
    public void setEmail(String email) {
        emailField.setValue(email);
    }

    @Step("Ввод пароля")
    public void setPassword(String password) {
        passwordField.setValue(password);
    }

    @Step("Клик на кнопку входа")
    public void clickEntryButton() {
        entryButton.click();
    }

    @Step("Вход")
    public void entry(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickEntryButton();
    }

    @Step("Ожидание после входа")
    public void waitAfterEntry() {
        entryButton.shouldBe(Condition.hidden);
    }
}
