package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleCloudHomePage {

    private final WebDriver driver;
    private static final String PAGE_URL = "https://cloud.google.com";
    private static final String SEARCH_TEXT = "Google Cloud Platform Pricing Calculator";

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchTextInput;

    public GoogleCloudHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public GoogleCloudHomePage openPage() {
        driver.get(PAGE_URL);
        new WebDriverWait(driver,
                Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@name='q']")));
        return this;
    }

    public GoogleCloudSearchResultsPage startSearch() {
        searchTextInput.click();
        searchTextInput.sendKeys(SEARCH_TEXT + Keys.RETURN);
        return new GoogleCloudSearchResultsPage(driver);
    }

    public void closePage() {
        driver.quit();
    }
}
