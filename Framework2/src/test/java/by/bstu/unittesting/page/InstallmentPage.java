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

public class InstallmentPage extends AbstractPage {

    private final Logger logger = LogManager.getLogger(InstallmentPage.class);

    private static final String PAGE_URL = "https://7745.by/";

    @FindBy(xpath = "//*[@id=\"panel\"]/div[2]/div/div[2]/div[1]/div[2]/ul/li[5]/a")
    private WebElement installmentButton;

    @FindBy(xpath = "//*[@id=\"panel\"]/div[2]/div/div[2]/div[1]/div[3]/div[2]/div[2]/div[1]/div[1]/a/span")
    private WebElement smartPhoneFieldLocator;


    public InstallmentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public InstallmentPage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Installment Page opened");
        return this;
    }

    public InstallmentPage openInstallment(){
        installmentButton.click();
        logger.info("Installment Page was opened");
        return this;
    }


    public String getErrorText() {
        return smartPhoneFieldLocator.getText();
    }

}
