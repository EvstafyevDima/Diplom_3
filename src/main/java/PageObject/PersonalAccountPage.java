package PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PersonalAccountPage {

    public static final String PERSONAL_ACCOUNT_PAGE_URL = "https://stellarburgers.nomoreparties.site/account/profile";

    @FindBy(how = How.XPATH, using = ".//a[text()='История заказов']")
    private SelenideElement ordersHistoryButton;

    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    private SelenideElement logOutButton;

    @FindBy(how = How.XPATH, using = ".//p[text()='Конструктор']")
    private SelenideElement constructorButton;

    @FindBy(how = How.XPATH, using = ".//*[@id='root']/div/header/nav/div/a")
    private SelenideElement logoButton;

    @Step("Клик на кнопку входа")
    public void clickTheLogOutButton() {
        logOutButton.click();
    }

    @Step("Клики на кнопку Конструктор")
    public void clickTheConstructorButton() {
        constructorButton.click();
    }

    @Step("Клики на кнопку бургера")
    public void clickTheLogo() {
        logoButton.click();
    }

    @Step("Ожидание загрузки страницы")
    public void waitAfterTransition() {
        logOutButton.shouldBe(Condition.visible);
    }

    @Step("Ожидание выхода")
    public void waitAfterLogOut() {
        logOutButton.shouldBe(Condition.disappear);
    }
}