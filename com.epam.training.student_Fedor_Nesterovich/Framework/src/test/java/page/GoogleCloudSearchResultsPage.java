package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import service.PricingCalculatorConfigurationCreator;

import java.time.Duration;

public class GoogleCloudSearchResultsPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();
    private static final String PRICING_CALCULATOR_LINK_XPATH = "//b[text()='Google Cloud Platform Pricing Calculator']/parent::a";

    @FindBy(xpath = PRICING_CALCULATOR_LINK_XPATH)
    private WebElement pricingCalculatorLink;

    public GoogleCloudSearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public GoogleCloudPricingCalculatorConfigurationPage openPricingCalculatorLink() {
        new WebDriverWait(driver,
                Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(PRICING_CALCULATOR_LINK_XPATH)));
        pricingCalculatorLink.click();
        logger.info("Opening Google Cloud Pricing Calculator link.");
        return new GoogleCloudPricingCalculatorConfigurationPage(driver, PricingCalculatorConfigurationCreator.getCalculatorConfiguration());
    }
}
