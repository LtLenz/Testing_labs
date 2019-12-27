package by.bstu.unittesting.service;

import by.bstu.unittesting.model.Order;

public class OrderCreator {

    public static final String TESTDATA_ORDER_NUMBER = "testdata.order.number";
    public static final String TESTDATA_ORDER_NUMBER_WRONG = "testdata.order.number.wrong";

    public static Order createOrderWithAllFieldsFromProperty() {
        return new Order(TestDataReader.getTestData(TESTDATA_ORDER_NUMBER));
    }

    public static Order createOrderWithWrongNumber() {
        return new Order(TestDataReader.getTestData(TESTDATA_ORDER_NUMBER_WRONG));
    }
}
