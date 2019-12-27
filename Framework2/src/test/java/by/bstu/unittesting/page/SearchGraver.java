package by.bstu.unittesting.page;

import by.bstu.unittesting.model.Item;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchGraver extends AbstractPage {

    private final Logger logger = LogManager.getLogger(IncorrectOrderPage.class);

    private static final String PAGE_URL = "https://7745.by/";

    @FindBy(xpath = "//*[@id=\"search\"]")
    private WebElement search;

    @FindBy(xpath = "//*[@id=\"content\"]/div[4]/h1")
    private WebElement itemFieldLocator;


    public SearchGraver(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public SearchGraver openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Start page opened");
        return this;
    }

    public SearchGraver search(Item item) {
        search.sendKeys(item.getSearch());
        logger.info("Added in searchField");
        return this;
    }

    public SearchGraver searchClick() {
        WebElement search = driver.findElement(By.xpath("//*[@id=\"panel\"]/div[2]/div/div[2]/div[2]/div[2]/div/div[1]/form/button"));
        search.click();
        logger.info("Start search");
        return this;
    }

    public SearchGraver GetItemOnPage(Item item) {
        WebElement foundedItem = driver.findElement(By.xpath("//*[@id=\"panel\"]/div[2]/div/div[2]/div[1]/div[3]/div[2]/div[5]/div[1]/div[1]/div"));
        item.setName(driver.findElement(By.xpath("//*[@id=\"panel\"]/div[2]/div/div[2]/div[1]/div[3]/div[2]/div[5]/div[1]/div[1]/div/div[2]/div[1]/div/a")).getText());
        foundedItem.click();
        logger.info("item was clicked");
        return this;
    }

    public String getErrorText() {
        WebElement test = new WebDriverWait(driver, SECONDS_TO_LOAD)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/div[4]/h1")));

        return itemFieldLocator.getText();
    }

}
