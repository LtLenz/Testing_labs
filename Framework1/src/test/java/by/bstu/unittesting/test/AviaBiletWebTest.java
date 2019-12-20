package by.bstu.unittesting.test;

import by.bstu.unittesting.model.*;


import by.bstu.unittesting.page.OrderPage;

import by.bstu.unittesting.service.*;

import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AviaBiletWebTest extends GeneralConfig {


    private static final String ALPHABET_PAGE_ERROR_TEXT = "Поле Номер заказа должно содержать только цифры.";
    private static final String NUMBER_PAGE_ERROR_TEXT = "Возможно, Вы ошиблись в номере заказа?";

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

        String errorText = new OrderPage(driver).openPage()
                .selectOrderStatusButton()
                .fillInRouteInformation(testOrder)
                .okButton()
                .getErrorText();

        assertThat(errorText, is(equalTo("Заказ "+testOrder.getNumber()+" не найден. Возможно, Вы ошиблись в номере заказа?")));

    }


}
