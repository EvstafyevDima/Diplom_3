import PageObject.MainPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static PageObject.MainPage.MAIN_PAGE_URL;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;


public class ConstructorTests {

    @Test
    @DisplayName("После перехода в раздел \"Булки\" можно добавить элемент из этого раздела в корзину")
    public void checkTransitionOfBunsButton() {
        MainPage main = open(MAIN_PAGE_URL, MainPage.class);
        assertTrue(main.сlickRollsMoveAndCheckDisplayInTheBasket());
    }

    @Test
    @DisplayName("После перехода в раздел \"Соусы\" можно добавить элемент из этого раздела в корзину")
    public void checkTransitionOfSaucesButton() {
        MainPage main = open(MAIN_PAGE_URL, MainPage.class);
        assertTrue(main.сlickSaucesMoveAndCheckDisplayInTheBasket());
    }

    @Test
    @DisplayName("После перехода в раздел \"Начинки\" можно добавить элемент из этого раздела в корзину")
    public void checkTransitionOfFillingButton() {
        MainPage main = open(MAIN_PAGE_URL, MainPage.class);
        assertTrue(main.сlickFillingMoveAndCheckDisplayInTheBasket());
    }

}
