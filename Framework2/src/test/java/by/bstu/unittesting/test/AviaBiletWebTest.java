package by.bstu.unittesting.test;

import by.bstu.unittesting.model.*;


import by.bstu.unittesting.page.*;

import by.bstu.unittesting.service.*;

import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AviaBiletWebTest extends GeneralConfig {


    private static final String ALPHABET_PAGE_ERROR_TEXT = "Поле Номер заказа должно содержать только цифры.";
    private static final String PROMO_PAGE_ERROR_TEXT = "Такого промокода не существует";
    private static final String DELIVERY_COST = "Стоимость доставки";



    @Test
    public void testSales() {

        String errorText = new SalesPage(driver).openPage()
                .openSales()
                .getErrorText();

        assertThat(errorText, is(equalTo("Как купить товар дешевле?")));

    }

    @Test
    public void testInstallment() {

        String errorText = new InstallmentPage(driver).openPage()
                .openInstallment()
                .getErrorText();

        assertThat(errorText, is(equalTo("Смартфоны")));

    }

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
    public void testDeliveryCost() {

        String errorText = new DeliveryPage(driver).openPage()
                .openDelivery()
                .openManDelivery()
                .getErrorText();

        assertThat(errorText, is(equalTo(DELIVERY_COST)));

    }

    @Test
    public void testIncorrectPhone() {

        Phone testPhone = PhoneCreator.createPhoneWithWrongNumber();
        String errorText = new CallPhonePage(driver).openPage()
                .callPhoneClick()
                .setName(testPhone)
                .setPhone(testPhone)
                .setMessage(testPhone)
                .submitClick()
                .getErrorText();

        assertThat(errorText, is(equalTo("Поле Телефон заполнено неверно. Номер телефона должет состоять из 9 цифр, включая код оператора.")));

    }

    @Test
    public void testGraver() {

        Item item = ItemCreator.createViaSearch();
        String errorText = new SearchGraver(driver).openPage()
                .search(item)
                .searchClick()
                .GetItemOnPage(item)
                .getErrorText();


        assertThat(errorText, is(equalTo(item.getName())));
    }

    @Test
    public void testEnteringEmptyMessage() {

        Phone testPhone = PhoneCreator.createPhoneWithEmptyNumber();
        String errorText = new EmptyMessagePage(driver).openPage()
                .sendMessage()
                .typeOrigin()
                .getErrorText();

        assertThat(errorText, is(equalTo("Поле \"Сообщение\" обязательно для заполнения.\nДолжно быть указано хотя бы что-то одно: телефон и/или email.")));
    }

    @Test
    public void testRubbles() {

        String errorText = new PaymentPage(driver).openPage()
                .openPayment()
                .getErrorText();

        assertThat(errorText, is(equalTo("* Расчет за товар производится только в белорусских рублях.")));

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
