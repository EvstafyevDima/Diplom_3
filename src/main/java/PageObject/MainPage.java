package PageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {

    public static final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";

    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement enterButton;

    @FindBy(how = How.XPATH, using = ".//p[text()='Личный Кабинет']")
    private SelenideElement personalAccountButton;

    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']")
    private SelenideElement bunsButton;

    @FindBy(how = How.XPATH, using = ".//h2[text()='Булки']")
    private SelenideElement bunsSign;

    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']")
    private SelenideElement saucesButton;

    @FindBy(how = How.XPATH, using = ".//h2[text()='Соусы']")
    private SelenideElement saucesSign;

    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']")
    private SelenideElement fillingsButton;

    @FindBy(how = How.XPATH, using = ".//h2[text()='Начинки']")
    private SelenideElement fillingsSign;

    @FindBy(how = How.XPATH, using = "//p[text()='Сыр с астероидной плесенью']")
    private SelenideElement lastIngredient;

    @FindBy(how = How.CLASS_NAME, using = "BurgerConstructor_basket__list__l9dp_")
    private SelenideElement orderBasket;

    @FindBy(how = How.XPATH, using = ".//p[text()='Флюоресцентная булка R2-D3']")
    private SelenideElement bunForDrop;

    @FindBy(how = How.XPATH, using = ".//span[text()='Флюоресцентная булка R2-D3 (верх)']")
    private SelenideElement bunInBasket;

    @FindBy(how = How.XPATH, using = ".//p[text()='Соус Spicy-X']")
    private SelenideElement sauceForDrop;

    @FindBy(how = How.XPATH, using = ".//span[text()='Соус Spicy-X']")
    private SelenideElement sauceInBasket;

    @FindBy(how = How.XPATH, using = ".//p[text()='Хрустящие минеральные кольца']")
    private SelenideElement fillingForDrop;

    @FindBy(how = How.XPATH, using = ".//span[text()='Хрустящие минеральные кольца']")
    private SelenideElement fillingInBasket;

    @Step("Нажать на кнопку войти в аккаунт")
    public void clickAccountEntryButton() {
        enterButton.click();
    }

    @Step("Нажать на кнопку личный кабинет")
    public void clickPersonalAccountButton() {
        personalAccountButton.click();
    }

    @Step("Нажать кнопку Начинки, переместить в корзину и проверить отображение в корзине")
    public boolean сlickFillingMoveAndCheckDisplayInTheBasket() {
        fillingsButton.click();
        fillingForDrop.dragAndDropTo(orderBasket);
        return fillingInBasket.isDisplayed();
    }

    @Step("Листаем список и жмем на Соусы, переместить в корзину и проверить отображение в корзине")
    public boolean сlickSaucesMoveAndCheckDisplayInTheBasket() {
        lastIngredient.scrollIntoView(true);
        saucesButton.click();
        sauceForDrop.dragAndDropTo(orderBasket);
        return sauceInBasket.isDisplayed();
    }

    @Step("Листаем список и жмем на Булки, переместить в корзину и проверить отображение в корзине")
    public boolean сlickRollsMoveAndCheckDisplayInTheBasket() {
        lastIngredient.scrollIntoView(true);
        bunsButton.click();
        bunForDrop.dragAndDropTo(orderBasket);
        return bunInBasket.isDisplayed();
    }

}
