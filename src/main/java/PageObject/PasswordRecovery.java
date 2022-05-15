package PageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PasswordRecovery {

    public static final String FORGOT_PASSWORD_URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    private SelenideElement entryButton;

    @Description("Нажать кнопку Войти")
    public void clickTheEntryButton() {
        entryButton.scrollTo().click();
    }

}
