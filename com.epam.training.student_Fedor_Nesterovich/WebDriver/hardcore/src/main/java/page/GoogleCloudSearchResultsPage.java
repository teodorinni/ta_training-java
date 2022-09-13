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

    @FindBy(xpath = "//b[text()='Google Cloud Platform Pricing Calculator']/parent::a")
    private WebElement pricingCalculatorLink;

    public GoogleCloudSearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public GoogleCloudPricingCalculatorConfigurationPage openPricingCalculatorLink() {
        new WebDriverWait(driver,
                Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(//b[text()='Google Cloud Platform Pricing Calculator'])[1]/parent::a")));
        pricingCalculatorLink.click();
        return new GoogleCloudPricingCalculatorConfigurationPage(driver);
    }

    public void closePage() {
        driver.quit();
    }
}
