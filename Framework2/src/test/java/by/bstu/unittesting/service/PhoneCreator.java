package by.bstu.unittesting.service;


import by.bstu.unittesting.model.Phone;

public class PhoneCreator {

    public static final String TESTDATA_PHONE_NUMBER = "testdata.phone.number";
    public static final String TESTDATA_PHONE_MESSAGE = "testdata.phone.message";

    public static Phone createPhoneWithWrongNumber() {
        return new Phone(TestDataReader.getTestData(TESTDATA_PHONE_NUMBER), TestDataReader.getTestData(TESTDATA_PHONE_MESSAGE));
    }

    public static Phone createPhoneWithEmptyNumber() {
        return new Phone(TestDataReader.getTestData(TESTDATA_PHONE_NUMBER), null);
    }

}
