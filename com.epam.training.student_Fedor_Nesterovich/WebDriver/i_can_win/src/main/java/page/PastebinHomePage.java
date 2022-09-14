package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PastebinHomePage {

    private final WebDriver driver;
    private static final String PAGE_URL = "https://pastebin.com";
    private static final String INPUT_TEXT = "Hello from WebDriver";
    private static final String EXPIRATION_TIME = "10 Minutes";
    private static final String PASTE_TITLE = "helloweb";
    private static final String TEXT_INPUT_XPATH = "//*[@id='postform-text']";
    private static final String EXPIRATION_TIME_XPATH = "//span[@title='Never']";
    private static final String PASTE_TITLE_XPATH = "//*[@id='postform-name']";
    private static final String SUBMIT_BUTTON_XPATH = "//button[@type='submit'][text()='Create New Paste']";
    private static final String AGREE_WITH_PRIVACY_TERMS_XPATH = "//button[text()='Agree and proceed']";

    @FindBy(xpath = TEXT_INPUT_XPATH)
    private WebElement textInput;

    @FindBy(xpath = EXPIRATION_TIME_XPATH)
    private WebElement expirationTime;

    @FindBy(xpath = PASTE_TITLE_XPATH)
    private WebElement pasteTitle;

    @FindBy(xpath = SUBMIT_BUTTON_XPATH)
    private WebElement submitButton;

    @FindBy(xpath = AGREE_WITH_PRIVACY_TERMS_XPATH)
    private WebElement agreePrivacyButton;

    public PastebinHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PastebinHomePage openPage() {
        driver.get(PAGE_URL);
        new WebDriverWait(driver,
                Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(AGREE_WITH_PRIVACY_TERMS_XPATH)));
        return this;
    }

    public PastebinHomePage agreeWithPrivacyTerms() {
        agreePrivacyButton.click();
        new WebDriverWait(driver,
                Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(
                        TEXT_INPUT_XPATH + "|" +
                                EXPIRATION_TIME_XPATH + "|" +
                                PASTE_TITLE_XPATH + "|" +
                                SUBMIT_BUTTON_XPATH)));
        return this;
    }

    public PastebinHomePage fillPasteText() {
        textInput.sendKeys(INPUT_TEXT);
        return this;
    }

    public PastebinHomePage selectPasteExpirationTime() {
        expirationTime.click();
        driver.findElement(By.xpath(String.format("//li[text()='%s']", EXPIRATION_TIME))).click();
        return this;
    }

    public PastebinHomePage fillPasteTitle() {
        pasteTitle.sendKeys(PASTE_TITLE);
        return this;
    }

    public PastebinHomePage submitPaste() {
        submitButton.click();
        return this;
    }

    public void closePage() {
        driver.quit();
    }
}
