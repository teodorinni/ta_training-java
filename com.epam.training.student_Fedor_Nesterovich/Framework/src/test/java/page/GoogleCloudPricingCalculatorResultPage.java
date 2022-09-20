package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class GoogleCloudPricingCalculatorResultPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();
    private final static String EMAIL_BUTTON_XPATH = "//button[@aria-label='Email']";
    private final static String EMAIL_INPUT_XPATH = "//input[@type='email']";
    private final static String SEND_EMAIL_BUTTON_XPATH = "//button[@aria-label='Send Email']";
    private final static String ESTIMATED_COST_XPATH = "//*[contains(text(), 'Estimated Component Cost')]";

    @FindBy(xpath = EMAIL_BUTTON_XPATH)
    private WebElement emailButton;

    @FindBy(xpath = EMAIL_INPUT_XPATH)
    private WebElement emailInput;

    @FindBy(xpath = SEND_EMAIL_BUTTON_XPATH)
    private WebElement sendEmailButton;

    @FindBy(xpath = ESTIMATED_COST_XPATH)
    private WebElement estimatedCost;

    public GoogleCloudPricingCalculatorResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getEstimatedCost() {
        new WebDriverWait(driver,
                Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(ESTIMATED_COST_XPATH)));
        return estimatedCost.getText()
                .replaceAll("Estimated Component Cost: ", "")
                .replaceAll(" per 1 month", "");
    }

    public GoogleCloudPricingCalculatorResultPage clickEmailButton() {
        new WebDriverWait(driver,
                Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(EMAIL_BUTTON_XPATH)));
        emailButton.click();
        return this;
    }

    public GoogleCloudPricingCalculatorResultPage fillEmail(String email) {
        WebElement iframe = new WebDriverWait(driver,
                Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//iframe)[1]")));
        driver.switchTo().frame(iframe);
        WebElement iframeInside = new WebDriverWait(driver,
                Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@id='myFrame']")));
        driver.switchTo().frame(iframeInside);
        new WebDriverWait(driver,
                Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(EMAIL_INPUT_XPATH)));
        emailInput.click();
        emailInput.sendKeys(email);
        return this;
    }

    public GoogleCloudPricingCalculatorResultPage clickSendEmailButton() {
        new WebDriverWait(driver,
                Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(SEND_EMAIL_BUTTON_XPATH)));
        sendEmailButton.click();
        logger.info("The email has been sent.");
        return this;
    }

    public YopMailPage createNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        logger.info("The new tab has been created.");
        return new YopMailPage(driver);
    }

    public YopMailPage goToSecondTab() {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        logger.info("Switched to 2nd tab");
        return new YopMailPage(driver);
    }
}
