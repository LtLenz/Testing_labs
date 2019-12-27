package by.bstu.unittesting.test;

import by.bstu.unittesting.model.*;


import by.bstu.unittesting.page.IncorrectOrderPage;
import by.bstu.unittesting.page.IncorrectPromoPage;
import by.bstu.unittesting.page.OrderPage;

import by.bstu.unittesting.service.*;

import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AviaBiletWebTest extends GeneralConfig {


    private static final String ALPHABET_PAGE_ERROR_TEXT = "Поле Номер заказа должно содержать только цифры.";
    private static final String NUMBER_PAGE_ERROR_TEXT = "Возможно, Вы ошиблись в номере заказа?";
    private static final String PROMO_PAGE_ERROR_TEXT = "Такого промокода не существует";


    @Test
    public void testWrongPromo() {


        Promocode testPromo = PromoCreator.createPromoWithWrongNumber();
        String errorText = new IncorrectPromoPage(driver).openPage()
                .addToCart()
                .openCart()
                .fillInPromoNumber(testPromo)
                .applyPromo()
                .getErrorText();

        assertThat(errorText, is(equalTo(PROMO_PAGE_ERROR_TEXT)));

    }

    @Test
    public void testAlphabetInNumberField() {


        Order testOrder = OrderCreator.createOrderWithAllFieldsFromProperty();

        String errorText = new OrderPage(driver).openPage()
                .selectOrderStatusButton()
                .fillInRouteInformation(testOrder)
                .okButton()
                .getErrorText();

        assertThat(errorText, is(equalTo(ALPHABET_PAGE_ERROR_TEXT)));

    }

    @Test
    public void testIncorrectOrder() {


        Order testOrder = OrderCreator.createOrderWithWrongNumber();

        String errorText = new IncorrectOrderPage(driver).openPage()
                .selectOrderStatusButton()
                .fillInRouteInformation(testOrder)
                .okButton()
                .getErrorText();

        assertThat(errorText, is(equalTo("Заказ "+testOrder.getNumber()+" не найден. Возможно, Вы ошиблись в номере заказа?")));

    }


}
