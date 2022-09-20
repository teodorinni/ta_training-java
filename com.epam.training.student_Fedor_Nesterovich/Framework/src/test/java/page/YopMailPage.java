package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class YopMailPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();
    private static final String MAIL_PAGE_URL = "https://yopmail.com/en/";
    private static final String ACCEPT_NECESSARY_COOKIES_BUTTON_XPATH = "//button[@id='necesary']";
    private static final String GENERATE_RANDOM_EMAIL_BUTTON_XPATH = "(//a[@href='email-generator'])[1]";
    private static final String GENERATED_EMAIL_XPATH = "//div[@id='egen']";
    private static final String GO_TO_MAILBOX_BUTTON_XPATH = "//button[@onclick='egengo();']";
    private static final String ESTIMATED_COST_XPATH = "//*[contains(text(),'Estimated Monthly Cost:')]";
    private static final String REFRESH_MAILBOX_BUTTON_XPATH = "//button[@id='refresh']";

    @FindBy(xpath = ACCEPT_NECESSARY_COOKIES_BUTTON_XPATH)
    private WebElement acceptNecessaryCookiesButton;

    @FindBy(xpath = GENERATE_RANDOM_EMAIL_BUTTON_XPATH)
    private WebElement generateRandomEmailButton;

    @FindBy(xpath = GENERATED_EMAIL_XPATH)
    private WebElement generatedEmail;

    @FindBy(xpath = GO_TO_MAILBOX_BUTTON_XPATH)
    private WebElement goToMailboxButton;

    @FindBy(xpath = ESTIMATED_COST_XPATH)
    private WebElement estimatedCost;

    @FindBy(xpath = REFRESH_MAILBOX_BUTTON_XPATH)
    private WebElement refreshMailboxButton;

    public YopMailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public YopMailPage openPage() {
        driver.get(MAIL_PAGE_URL);
        return this;
    }

    public YopMailPage acceptPrivacyTerms() {
        try {
            new WebDriverWait(driver,
                    Duration.ofSeconds(2))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath(ACCEPT_NECESSARY_COOKIES_BUTTON_XPATH)));
            acceptNecessaryCookiesButton.click();
        } catch (NoSuchElementException | TimeoutException exception) {
            logger.info("The Accept Privacy Terms message did not appear on the mailbox page.");
        }
        return this;
    }

    public YopMailPage generateRandomEmail() {
        new WebDriverWait(driver,
                Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(GENERATE_RANDOM_EMAIL_BUTTON_XPATH)));
        generateRandomEmailButton.click();
        logger.info("Email has been generated");
        return this;
    }

    public String getGeneratedEmail() {
        new WebDriverWait(driver,
                Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(GENERATED_EMAIL_XPATH)));
        return generatedEmail.getText();
    }

    public GoogleCloudPricingCalculatorResultPage goToFirstTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        logger.info("Switched to 1st tab");
        return new GoogleCloudPricingCalculatorResultPage(driver);
    }

    public YopMailPage goToMailbox() {
        new WebDriverWait(driver,
                Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(GO_TO_MAILBOX_BUTTON_XPATH)));
        goToMailboxButton.click();
        return this;
    }

    public void refreshMailbox() {
        driver.switchTo().parentFrame();
        new WebDriverWait(driver,
                Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(REFRESH_MAILBOX_BUTTON_XPATH)));
        refreshMailboxButton.click();
    }

    public String getEstimatedCost() {
        for (int i = 0; i < 3; i++) {
            try {
                WebElement iframe = new WebDriverWait(driver,
                        Duration.ofSeconds(10))
                        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@id='ifmail']")));
                driver.switchTo().frame(iframe);
                return estimatedCost.getText().replaceAll("Estimated Monthly Cost: ", "");
            } catch (NoSuchElementException exception) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                refreshMailbox();
            }
        }
        logger.info("The email has not been received");
        return "Email has not been received.";
    }
}
