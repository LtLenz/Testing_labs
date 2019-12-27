package by.bstu.unittesting.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage extends AbstractPage {

    private final Logger logger = LogManager.getLogger(IncorrectOrderPage.class);

    private static final String PAGE_URL = "https://7745.by/";

    @FindBy(xpath = "//*[@id=\"panel\"]/div[2]/div/div[2]/div[1]/div[2]/ul/li[4]/a")
    private WebElement paymentButton;

    @FindBy(xpath = "//*[@id=\"panel\"]/div[2]/div/div[2]/div[1]/div[3]/div[2]/p[3]")
    private WebElement paymentFieldLocator;

    public PaymentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public PaymentPage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Start page opened");
        return this;
    }

    public PaymentPage openPayment(){
        paymentButton.click();
        logger.info("Payment page was opened");
        return this;
    }

    public String getErrorText() {
        WebElement test = new WebDriverWait(driver, SECONDS_TO_LOAD)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"panel\"]/div[2]/div/div[2]/div[1]/div[3]/div[2]/p[3]")));

        return paymentFieldLocator.getText();
    }
}
