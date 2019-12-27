package by.bstu.unittesting.service;


import by.bstu.unittesting.model.Promocode;

public class PromoCreator {

    public static final String TESTDATA_PROMO_NUMBER = "testdata.promo.number";

    public static Promocode createPromoWithWrongNumber() {
        return new Promocode(TestDataReader.getTestData(TESTDATA_PROMO_NUMBER));
    }

}
