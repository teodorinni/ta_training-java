package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class YopMailPage {

    private final WebDriver driver;
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
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public YopMailPage openMailPage() {
        driver.get(MAIL_PAGE_URL);
        return this;
    }

    public YopMailPage acceptPrivacyTerms() {
        try {
            new WebDriverWait(driver,
                    Duration.ofSeconds(2))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath(ACCEPT_NECESSARY_COOKIES_BUTTON_XPATH)));
            acceptNecessaryCookiesButton.click();
        } catch (NoSuchElementException | TimeoutException ignored) {}
        return this;
    }

    public YopMailPage generateRandomEmail() {
        new WebDriverWait(driver,
                Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(GENERATE_RANDOM_EMAIL_BUTTON_XPATH)));
        generateRandomEmailButton.click();
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
                        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@name='ifmail']")));
                driver.switchTo().frame(iframe);
                return estimatedCost.getText().replaceAll("Estimated Monthly Cost: ", "");
            } catch (NoSuchElementException exception) {
                refreshMailbox();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            }
        }
        return null;
    }

    public void closePage() {
        driver.quit();
    }
}
