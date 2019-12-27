package by.bstu.unittesting.page;
import by.bstu.unittesting.model.Phone;
import by.bstu.unittesting.page.AbstractPage;
import by.bstu.unittesting.page.IncorrectOrderPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CallPhonePage extends AbstractPage {

    private final Logger logger = LogManager.getLogger(IncorrectOrderPage.class);

    private static final String PAGE_URL = "https://7745.by/";



    private static final By CALL_PHONE = By.xpath("//*[@id=\"panel\"]/div[2]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]");
    private static final By NAME_INPUT = By.xpath("//*[@id=\"edit-name-1\"]");
    private static final By PHONE_INPUT = By.xpath("//*[@id=\"edit-phone\"]");
    private static final By MESSAGE_INPUT = By.xpath("//*[@id=\"edit-subject\"]");
    private static final By SUBMIT_DATA = By.xpath("//*[@id=\"edit-submitter\"]");
    private static final By ERROR_FIELD_LOCATION = By.xpath("//*[@id=\"callback-callback-form-messages\"]/div/div");

    public CallPhonePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public CallPhonePage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Start page opened");
        return this;
    }


    public CallPhonePage callPhoneClick() {
        WebElement call = driver.findElement(CALL_PHONE);
        call.click();
        return this;
    }

    public CallPhonePage setName(Phone phone){
        driver.findElement(NAME_INPUT).sendKeys(phone.getMessage());
        return this;
    }

    public CallPhonePage setPhone(Phone phone){
        driver.findElement(PHONE_INPUT).sendKeys(phone.getNumber());
        return this;
    }

    public CallPhonePage setMessage(Phone phone){
        driver.findElement(MESSAGE_INPUT).sendKeys(phone.getMessage());
        return this;
    }

    public CallPhonePage submitClick(){
        driver.findElement(SUBMIT_DATA).click();
        return this;
    }

    public String getErrorText() {
        return driver.findElement(ERROR_FIELD_LOCATION).getText();
    }

}