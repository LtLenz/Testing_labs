import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.nio.file.WatchEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestUtils {
    private static String ITEM = "Гравер";

    public static void testPromo(WebDriver driver) throws InterruptedException {

        driver.get("https://7745.by/");

        WebElement search = driver.findElement(By.xpath("//*[@id=\"search\"]"));
        search.sendKeys(ITEM);
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"panel\"]/div[2]/div/div[2]/div[1]/div[3]/div[2]/div/div[1]/form/button"));
        searchButton.click();
        WebElement item = driver.findElement(By.xpath("//*[@id=\"panel\"]/div[2]/div/div[2]/div[1]/div[3]/div[2]/div[5]/div[1]/div[1]/div/div[1]/div[2]/a"));
        item.click();
        WebElement toCartButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div[2]/div[3]/div[2]/div/div[4]/div[2]/div/button"));
        toCartButton.click();
        WebElement cartButton = driver.findElement(By.xpath("//*[@id=\"cart-link\"]"));
        cartButton.click();
        WebElement sumbitButton = driver.findElement(By.xpath("//*[@id=\"panel\"]/div[2]/div/div[2]/div[1]/div[3]/div/div[3]/form/button"));
        sumbitButton.click();


    }

    public static void testNameForm(WebDriver driver) throws InterruptedException {

        driver.get("https://7745.by/");

        WebElement search = driver.findElement(By.xpath("//*[@id=\"search\"]"));
        search.sendKeys(ITEM);
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"panel\"]/div[2]/div/div[2]/div[1]/div[3]/div[2]/div/div[1]/form/button"));
        searchButton.click();
        WebElement item = driver.findElement(By.xpath("//*[@id=\"panel\"]/div[2]/div/div[2]/div[1]/div[3]/div[2]/div[5]/div[1]/div[1]/div/div[1]/div[2]/a"));
        item.click();
        WebElement toCartButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div[2]/div[3]/div[2]/div/div[4]/div[2]/div/button"));
        toCartButton.click();
        WebElement cartButton = driver.findElement(By.xpath("//*[@id=\"panel\"]/div[2]/div/div[2]/div[1]/div[4]/div/div[3]/form/button"));
        cartButton.click();
        WebElement submitOrder = driver.findElement(By.xpath("//*[@id=\"cart-info\"]/div[5]/button"));
        submitOrder.click();


    }
}
