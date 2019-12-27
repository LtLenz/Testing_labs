package by.bstu.unittesting.service;


import by.bstu.unittesting.model.Item;

public class ItemCreator {

    public static final String TESTDATA_SEARCH_NAME = "testdata.item.search";

    public static Item createViaSearch() {
        return new Item(TestDataReader.getTestData(TESTDATA_SEARCH_NAME));
    }

}
