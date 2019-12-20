package by.bstu.unittesting.service;

import java.util.ResourceBundle;

public class TestDataReader {

    private final static ResourceBundle RESOURCE_BUNDLE
            = ResourceBundle.getBundle("test");
    public static String getTestData(String key) {
        return RESOURCE_BUNDLE.getString(key);
    }
}
