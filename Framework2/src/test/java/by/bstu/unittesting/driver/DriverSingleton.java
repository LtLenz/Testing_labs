package by.bstu.unittesting.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {

    private static WebDriver driver;
    private static String DRIVER_TYPE = "chrome";

    private DriverSingleton() {
    }

    public static WebDriver getDriver() {
        if (null == driver) {
            if (DRIVER_TYPE.equals(System.getProperty("browser"))) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            if (DRIVER_TYPE.equals(System.getProperty("browser"))) {
                WebDriverManager.edgedriver().setup();
                driver = new ChromeDriver();
            }
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
