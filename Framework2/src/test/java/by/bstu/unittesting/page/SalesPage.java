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

import java.util.List;

public class SalesPage extends AbstractPage {

    private final Logger logger = LogManager.getLogger(IncorrectOrderPage.class);

    private static final String PAGE_URL = "https://7745.by/";

    @FindBy(xpath = "//*[@id=\"panel\"]/div[2]/div/div[2]/div[1]/div[2]/ul/li[7]/a")
    private WebElement salesButton;

    @FindBy(css = "#panel > div.wrapper > div > div.container.container--main.js-old-browsers-msg-parent > div:nth-child(1) > div.content.clearfix.padding-container > div.clearfix.body.sales-pp > div.category-seo-block > h2")
    private WebElement salesFieldLocator;


    public SalesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public SalesPage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Start page opened");
        return this;
    }

    public SalesPage openSales(){
        salesButton.click();
        logger.info("Sales page was opened");
        return this;
    }


    public String getErrorText() {
        return salesFieldLocator.getText();
    }

}
