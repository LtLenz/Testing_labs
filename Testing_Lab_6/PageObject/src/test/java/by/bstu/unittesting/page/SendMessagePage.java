package by.bstu.unittesting.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SendMessagePage extends Page {

    private static final String PAGE_URL = "https://7745.by/";

    private static final By SEND_MESSAGE = By.xpath("//*[@id=\"panel\"]/div[2]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]");
    private static final By SUBMIT_DATA = By.xpath("//*[@id=\"edit-submitter-1\"]");
    private static final By ERROR_FIELD_LOCATION = By.xpath("//*[@id=\"callback-message-form-messages\"]/div/div");


    public SendMessagePage(WebDriver driver) {
        super(driver);
    }

    public SendMessagePage openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public SendMessagePage sendMessage() {
        waitUntilElementToBeClickable(SEND_MESSAGE).click();
        return this;
    }

    public SendMessagePage typeOrigin() {
        driver.findElement(SUBMIT_DATA).click();
        return this;
    }

    public String getErrorText() {
        return waitUntilPresenceOfElement(ERROR_FIELD_LOCATION).getText();
    }


}
