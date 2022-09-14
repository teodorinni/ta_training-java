package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleCloudSearchResultsPage {

    private final WebDriver driver;
    private static final String PRICING_CALCULATOR_LINK_XPATH = "//b[text()='Google Cloud Platform Pricing Calculator']/parent::a";


    @FindBy(xpath = PRICING_CALCULATOR_LINK_XPATH)
    private WebElement pricingCalculatorLink;

    public GoogleCloudSearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public GoogleCloudPricingCalculatorConfigurationPage openPricingCalculatorLink() {
        new WebDriverWait(driver,
                Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(PRICING_CALCULATOR_LINK_XPATH)));
        pricingCalculatorLink.click();
        return new GoogleCloudPricingCalculatorConfigurationPage(driver);
    }

    public void closePage() {
        driver.quit();
    }
}
