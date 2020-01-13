
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class WebDriverTest {

    private static By errorField = By.xpath("//div[@class=\"modal-layout-body\"][1]");

    @Test
    public void promoCodeTest() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", Constants.DRIVER_LOCATION);
        WebDriver driver = new ChromeDriver();

        TestUtils.testPromo(driver);

        List<WebElement> errorElement = driver.findElements(errorField);

        Assert.assertFalse(errorElement.isEmpty());
    }

    @Test
    public void inputNameTest() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", Constants.DRIVER_LOCATION);
        WebDriver driver = new ChromeDriver();

        TestUtils.testNameForm(driver);

        List<WebElement> errorElement = driver.findElements(errorField);

        Assert.assertFalse(errorElement.isEmpty());
    }
}
 