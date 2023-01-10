package PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage {

    public static final String REGISTER_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";
    public final String NAME = RandomStringUtils.randomAlphabetic(347);
    public final String EMAIL = RandomStringUtils.randomAlphabetic(347) + "@mail.ru";
    public final String PASSWORD = "123456";

    @FindBy(how = How.XPATH, using = ".//input[@class='text input__textfield text_type_main-default']")
    public ElementsCollection nameEmailPasswordFields;

    @FindBy(how = How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    private SelenideElement registryButton;

    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    private SelenideElement entryButton;

    @FindBy(how = How.XPATH, using = ".//p[text()='Некорректный пароль']")
    private SelenideElement incorrectPasswordSign;

    @Step("Вод имени")
    public void setName(String name) {
        nameEmailPasswordFields.get(0).setValue(name);
    }

    @Step("Ввод почты")
    public void setEmail(String email) {
        nameEmailPasswordFields.get(1).setValue(email);
    }

    @Step("Вод пароля")
    public void setPassword(String password) {
        nameEmailPasswordFields.get(2).setValue(password);
    }

    @Step("Клик по кнопке регистрация")
    public void clickRegistrationButton() {
        registryButton.click();
    }

    @Step("Регистрация")
    public void registration(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
        clickRegistrationButton();
    }

    @Step("Проверка текста, при некорретном пароле")
    public boolean checkIncorrectPasswordSign() {
        return incorrectPasswordSign.isDisplayed();
    }

    @Step("Ожидание пока кнопка регистрации пропадет, после регистрации")
    public void waitAfterRegistration() {
        registryButton.shouldBe(Condition.hidden);
    }

    @Step("Нажать кнопку войти")
    public void clickTheEntryButton() {
        entryButton.scrollTo().click();
    }
}

