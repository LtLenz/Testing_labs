package by.bstu.unittesting.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmptyMessagePage extends AbstractPage {

    private static final String PAGE_URL = "https://7745.by/";

    private final Logger logger = LogManager.getLogger(EmptyMessagePage.class);

    private static final By SEND_MESSAGE = By.xpath("//*[@id=\"panel\"]/div[2]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]");
    private static final By SUBMIT_DATA = By.xpath("//*[@id=\"edit-submitter-1\"]");
    private static final By ERROR_FIELD_LOCATION = By.xpath("//*[@id=\"callback-message-form-messages\"]/div/div");

    public EmptyMessagePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public EmptyMessagePage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Start page opened");
        return this;
    }

    public EmptyMessagePage sendMessage() {
        driver.findElement(SEND_MESSAGE).click();
        logger.info("Message sended");
        return this;
    }

    public EmptyMessagePage typeOrigin() {
        driver.findElement(SUBMIT_DATA).click();
        logger.info("Button clicked");
        return this;
    }

    public String getErrorText() {
        WebElement test = new WebDriverWait(driver, SECONDS_TO_LOAD)
                .until(ExpectedConditions.visibilityOfElementLocated(ERROR_FIELD_LOCATION));

        return driver.findElement(ERROR_FIELD_LOCATION).getText();
    }
}
