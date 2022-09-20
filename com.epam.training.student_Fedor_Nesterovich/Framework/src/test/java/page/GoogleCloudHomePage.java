package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleCloudHomePage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();
    private static final String PAGE_URL = "https://cloud.google.com";
    private static final String SEARCH_TEXT = "Google Cloud Platform Pricing Calculator";
    private static final String SEARCH_INPUT_XPATH = "//input[@name='q']";

    @FindBy(xpath = SEARCH_INPUT_XPATH)
    private WebElement searchTextInput;

    public GoogleCloudHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public GoogleCloudHomePage openPage() {
        driver.get(PAGE_URL);
        new WebDriverWait(driver,
                Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(SEARCH_INPUT_XPATH)));
        logger.info("The Google Cloud home page has been opened.");
        return this;
    }

    public GoogleCloudSearchResultsPage startSearch() {
        searchTextInput.click();
        searchTextInput.sendKeys(SEARCH_TEXT + Keys.RETURN);
        logger.info("The search for Google Cloud Pricing Calculator has started.");
        return new GoogleCloudSearchResultsPage(driver);
    }
}
