package by.bstu.unittesting.page;

import by.bstu.unittesting.model.Order;
import by.bstu.unittesting.model.Promocode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IncorrectPromoPage extends AbstractPage{

    private final Logger logger = LogManager.getLogger(IncorrectOrderPage.class);

    private static final String PAGE_URL = "https://7745.by/product/graver-wortex-mg-3218-e";

    private final By cart = By.className("cart-link");

    @FindBy(className = "order-footer__input-promo")
    private WebElement promoInput;

    @FindBy(xpath = "//*[@id=\"panel\"]/div[2]/div/div[2]/div[1]/div[3]/div/div[6]/div/div/div")
    private WebElement errorFieldLocator;

    public IncorrectPromoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public IncorrectPromoPage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Promo page opened");
        return this;
    }

    public IncorrectPromoPage addToCart() {
        WebElement toCartButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div[2]/div[3]/div[2]/div/div[4]/div[2]/div/button"));
        toCartButton.click();
        logger.info("Added to Cart");
        return this;
    }

    public IncorrectPromoPage openCart() {
        WebElement cartButton = driver.findElement(cart);
        cartButton.click();
        logger.info("We clicked cart button");
        return this;
    }

    public IncorrectPromoPage fillInPromoNumber(Promocode promo) {
        promoInput.clear();
        promoInput.sendKeys(promo.getNumber());
        logger.info("Promo number filled");
        return this;
    }

    public IncorrectPromoPage applyPromo(){
        WebElement applyPromo = driver.findElement(By.xpath("//*[@id=\"panel\"]/div[2]/div/div[2]/div[1]/div[3]/div/div[3]/form/button"));
        applyPromo.click();
        logger.info("Ok button was clicked");
        return this;
    }

    public String getErrorText() {
        WebElement test = new WebDriverWait(driver, SECONDS_TO_LOAD)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"panel\"]/div[2]/div/div[2]/div[1]/div[3]/div/div[6]/div/div/div")));

        return errorFieldLocator.getText();
    }


}
