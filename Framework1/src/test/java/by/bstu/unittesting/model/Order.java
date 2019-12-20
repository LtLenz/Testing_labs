package by.bstu.unittesting.model;
import java.util.Objects;

public class Order {

    private String number;

    public Order(String testData) {
        this.number = testData;
    }

    public void Order(String number){
        this.number = number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}
