package by.bstu.unittesting.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CallPhonePahe extends Page {

    private static final String PAGE_URL = "https://7745.by/";

    private static final By CALL_PHONE = By.xpath("//*[@id=\"panel\"]/div[2]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]");
    private static final By NAME_INPUT = By.xpath("//*[@id=\"edit-name-1\"]");
    private static final By PHONE_INPUT = By.xpath("//*[@id=\"edit-phone\"]");
    private static final By MESSAGE_INPUT = By.xpath("//*[@id=\"edit-subject\"]");
    private static final By SUBMIT_DATA = By.xpath("//*[@id=\"edit-submitter\"]");
    private static final By ERROR_FIELD_LOCATION = By.xpath("//*[@id=\"callback-callback-form-messages\"]/div/div");

    public CallPhonePahe(WebDriver driver) {
        super(driver);
    }

    public CallPhonePahe openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public CallPhonePahe callPhoneClick() {
        waitUntilElementToBeClickable(CALL_PHONE).click();
        return this;
    }

    public CallPhonePahe setName(String name){
        driver.findElement(NAME_INPUT).sendKeys(name);
        return this;
    }

    public CallPhonePahe setPhone(String phone){
        driver.findElement(PHONE_INPUT).sendKeys(phone);
        return this;
    }

    public CallPhonePahe setMessage(String message){
        driver.findElement(MESSAGE_INPUT).sendKeys(message);
        return this;
    }

    public CallPhonePahe submitClick(){
        waitUntilElementToBeClickable(SUBMIT_DATA).click();
        return this;
    }

    public String getErrorText() {
        return waitUntilPresenceOfElement(ERROR_FIELD_LOCATION).getText();
    }

}
