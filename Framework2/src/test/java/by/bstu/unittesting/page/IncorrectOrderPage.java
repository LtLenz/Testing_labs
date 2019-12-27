package by.bstu.unittesting.page;

import by.bstu.unittesting.model.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class IncorrectOrderPage extends AbstractPage {

    private final Logger logger = LogManager.getLogger(IncorrectOrderPage.class);

    private static final String PAGE_URL = "https://7745.by/";

    private final By orderStatusButton = By.className("//*[@id=\"panel\"]/div[2]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]");

    @FindBy(xpath = "//*[@id=\"cart-order-status-form-messages\"]/div/div")
    private WebElement errorFieldLocator;


    @FindBy(xpath = "//*[@id=\"edit-order-number\"]")
    private WebElement originInput;

    private final By searchButtonLocator = By.className("search_button");

    public IncorrectOrderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public IncorrectOrderPage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Order page opened");
        return this;
    }

    public IncorrectOrderPage selectOrderStatusButton() {
        WebElement statusButton = driver.findElement(By.xpath("//*[@id=\"panel\"]/div[2]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]"));
        statusButton.click();
        logger.info("We clicked order button");
        return this;
    }

    public IncorrectOrderPage fillInRouteInformation(Order order) {
        originInput.clear();
        originInput.sendKeys(order.getNumber());
        logger.info("Order number filled with numbers");
        return this;
    }

    public IncorrectOrderPage okButton(){
        WebElement button = driver.findElement(By.xpath("//*[@id=\"edit-button-1\"]"));
        button.click();
        logger.info("Ok button was clicked");
        return this;
    }

    public String getErrorText() {
        WebElement test = new WebDriverWait(driver, SECONDS_TO_LOAD)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#cart-order-status-form-messages > div > div")));

        return errorFieldLocator.getText();
    }
}
