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

public class DeliveryPage extends AbstractPage {

    private final Logger logger = LogManager.getLogger(IncorrectOrderPage.class);

    private static final String PAGE_URL = "https://7745.by/";

    @FindBy(xpath = "//*[@id=\"panel\"]/div[2]/div/div[2]/div[1]/div[3]/div[2]/h2[2]")
    private WebElement deliveryFieldLocator;

    public DeliveryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public DeliveryPage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Start page opened");
        return this;
    }

    public DeliveryPage openDelivery() {
        WebElement deliveryButton = driver.findElement(By.xpath("//*[@id=\"panel\"]/div[2]/div/div[2]/div[1]/div[2]/ul/li[3]/a"));
        deliveryButton.click();
        logger.info("Delivery opened");
        return this;
    }

    public DeliveryPage openManDelivery() {
        WebElement openManDeliveryButton = driver.findElement(By.xpath("//*[@id=\"panel\"]/div[2]/div/div[2]/div[1]/div[3]/div[2]/div[2]/ol/li[2]/a"));
        openManDeliveryButton.click();
        logger.info("Delivery by courier opened");
        return this;
    }

    public String getErrorText() {
        WebElement test = new WebDriverWait(driver, SECONDS_TO_LOAD)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"panel\"]/div[2]/div/div[2]/div[1]/div[3]/div[2]/h2[2]")));

        return deliveryFieldLocator.getText();
    }

}
