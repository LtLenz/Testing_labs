import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.WatchEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TestUtils {

    @FindBy(xpath = "//*[@id=\"search\"]")
    private static WebElement searchField;

    @FindBy(xpath = "//button[@class='btn btn-search']")
    private static  WebElement searchButton;

    @FindBy(xpath = "//*[@class=\"item-block_name item-block_name--tile\" and text()=\"Гравер WORTEX MG 3218 E \"]")
    private static WebElement item;

    @FindBy(xpath = "//button[@class=\"btn btn-orange btn-buy\"]")
    private static List<WebElement> toCartButton;

    @FindBy(xpath = "//*[@id=\"cart-link\"]")
    private static WebElement cartButton;

    @FindBy(xpath = "//*[@class=\"btn btn-dark-grey w--110px js-bind-promo_submit\"]")
    private static WebElement sumbitButton;

    @FindBy(xpath = "//*[@name=\"promo_code\"]")
    private static WebElement inputPromo;

    @FindBy(xpath = "//button[@class=\"btn w--110px js-bind-promo_submit btn-orange\"]")
    private static WebElement submitPromo;

    private static By submitPromoBy = By.xpath("//button[@class=\"btn w--110px js-bind-promo_submit btn-orange\"]");
    public static void testPromo(WebDriver driver) throws InterruptedException {

        driver.get(Constants.URL);
        searchField.sendKeys(Constants.ITEM);
        searchButton.click();
        item.click();
        toCartButton.get(0).click();
        cartButton.click();
        sumbitButton.click();
    }

    public static void testNameForm(WebDriver driver) throws InterruptedException {

        driver.get(Constants.URL);

        searchField.sendKeys(Constants.ITEM);
        searchButton.click();
        item.click();
        toCartButton.get(0).click();
        cartButton.click();
        inputPromo.sendKeys(Constants.PROMO);
        WebElement submitButton = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(submitPromoBy));
        submitButton.click();

    }
}
