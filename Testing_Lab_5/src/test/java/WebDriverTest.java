import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class WebDriverTest {

    @Test
    public void promoCodeTest() throws InterruptedException {
        String s = "H:\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", s);
        WebDriver driver = new ChromeDriver();

        TestUtils.testPromo(driver);

        List<WebElement> errorElement = driver.findElements(By.xpath("//*[@id=\"panel\"]/div[2]/div/div[2]/div[1]/div[3]/div/div[6]/div/div"));

        Assert.assertFalse(errorElement.isEmpty());
    }

    @Test
    public void inputNameTest() throws InterruptedException {

        String s = "H:\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", s);
        WebDriver driver = new ChromeDriver();

        TestUtils.testNameForm(driver);

        List<WebElement> resultsList = driver.findElements(By.className("form-control error"));

        Assert.assertFalse(resultsList.isEmpty());
    }
}