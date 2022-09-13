package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PastebinSubmittedPage {

    private final WebDriver driver;

    @FindBy(xpath = "//div[@class='info-top']/h1")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[@class='top-buttons']/div[@class='left']/a[1]")
    private WebElement syntaxHighlighting;

    @FindBy(xpath = "//textarea[@class='textarea -raw js-paste-raw']")
    private WebElement textArea;

    public PastebinSubmittedPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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
