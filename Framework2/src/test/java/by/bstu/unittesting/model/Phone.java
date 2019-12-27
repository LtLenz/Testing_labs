package by.bstu.unittesting.model;
import java.util.Objects;

public class Phone {

    private String number;
    private String message;

    public Phone(String testData, String testDataM) {
        this.number = testData;
        this.message = testDataM;
    }

    public void Phone(String number){
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public String getMessage() {
        return message;
    }
}
