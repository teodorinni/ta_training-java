package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PastebinSubmittedPage {

    private final WebDriver driver;
    private static final String PAGE_TITLE_XPATH = "//div[@class='info-top']/h1";
    private static final String SYNTAX_HIGHLIGHTING_XPATH = "//div[@class='top-buttons']/div[@class='left']/a[1]";
    private static final String TEXT_AREA_XPATH = "//textarea[@class='textarea -raw js-paste-raw']";

    @FindBy(xpath = PAGE_TITLE_XPATH)
    private WebElement pageTitle;

    @FindBy(xpath = SYNTAX_HIGHLIGHTING_XPATH)
    private WebElement syntaxHighlighting;

    @FindBy(xpath = TEXT_AREA_XPATH)
    private WebElement textArea;

    public PastebinSubmittedPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PastebinSubmittedPage waitForElementsToLoad() {
        new WebDriverWait(driver,
                Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(
                        PAGE_TITLE_XPATH + "|" +
                        SYNTAX_HIGHLIGHTING_XPATH + "|" +
                        TEXT_AREA_XPATH)));
        return this;
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public String getSyntaxHighlighting() {
        return syntaxHighlighting.getText();
    }

    public String getPasteText() {
        return textArea.getText();
    }

    public void closePage() {
        driver.quit();
    }
}
