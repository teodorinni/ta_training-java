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

    @FindBy(id = "postform-text")
    private WebElement textInput;

    @FindBy(xpath = "//span[@title='Never']")
    private WebElement expirationTime;

    @FindBy(id = "postform-name")
    private WebElement pasteTitle;

    @FindBy(xpath = "//button[@type='submit'][text()='Create New Paste']")
    private WebElement submitButton;

    @FindBy(xpath = "//button[text()='Agree and proceed']")
    private WebElement agreePrivacyButton;

    public PastebinHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PastebinHomePage openPage() {
        driver.get(PAGE_URL);
        new WebDriverWait(driver,
                Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[text()='Agree and proceed']")));
        return this;
    }

    public PastebinHomePage agreeWithPrivacyTerms() {
        agreePrivacyButton.click();
        new WebDriverWait(driver,
                Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='postform-text']|//span[@title='Never']|//*[@id='postform-name']|//button[@type='submit'][text()='Create New Paste']")));
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
