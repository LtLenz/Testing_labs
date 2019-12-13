package by.bstu.unittesting.test;

import by.bstu.unittesting.page.SendMessagePage;
import by.bstu.unittesting.page.CallPhonePahe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

public class WebShopTest {

    private static final String NEXT_DAY_OF_MONTH
            = Integer.toString(Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + 1);

    private WebDriver driver;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver",
                "H:/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testIncorrectPhone() {

        CallPhonePahe callPhonePahe = new CallPhonePahe(driver).openPage()
                .callPhoneClick()
                .setName("Анна Ковшик")
                .setPhone("Я не хочу вводить цифры")
                .setMessage("Я хочу вводить буквы")
                .submitClick();

        assertTrue(callPhonePahe.getErrorText().contains("Поле Телефон заполнено неверно."));
    }
    @Test
    public void testEnteringEmptyMessage() {

        SendMessagePage sendMessagePage = new SendMessagePage(driver).openPage()
                .sendMessage()
                .typeOrigin();

        assertTrue(sendMessagePage.getErrorText().contains("обязательно для заполнения."));
    }

    @After
    public void after() {
        driver.close();
    }
}
