package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleCloudPricingCalculatorResultPage {

    private final WebDriver driver;
    private final static String REGION_RESULT_XPATH = "(//*[@class='md-1-line md-no-proxy'])[1]/child::*";
    private final static String PROVISIONING_MODEL_XPATH = "(//*[contains(@ng-if,'class')])[1]/child::*";
    private final static String INSTANCE_TYPE_XPATH = "//*[contains(@ng-class,'Instance')]";
    private final static String SSD_COMMITTED_XPATH = "//*[contains(@ng-class,'SsdCommitted')]";
    private final static String COMMITMENT_TERM_XPATH = "(//*[contains(@ng-if,'term')])[1]/child::*";
    private final static String ESTIMATED_COST_XPATH = "//*[contains(text(), 'Estimated Component Cost')]";


    @FindBy(xpath = REGION_RESULT_XPATH)
    private WebElement regionResult;

    @FindBy(xpath = PROVISIONING_MODEL_XPATH)
    private WebElement provisioningModel;

    @FindBy(xpath = INSTANCE_TYPE_XPATH)
    private WebElement instanceType;

    @FindBy(xpath = SSD_COMMITTED_XPATH)
    private WebElement ssdCommitted;

    @FindBy(xpath = COMMITMENT_TERM_XPATH)
    private WebElement commitmentTerm;

    @FindBy(xpath = ESTIMATED_COST_XPATH)
    private WebElement estimatedCost;

    public GoogleCloudPricingCalculatorResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getRegionResult() {
        new WebDriverWait(driver,
                Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(
                        REGION_RESULT_XPATH + "|" +
                                PROVISIONING_MODEL_XPATH + "|" +
                                INSTANCE_TYPE_XPATH + "|" +
                                SSD_COMMITTED_XPATH + "|" +
                                COMMITMENT_TERM_XPATH + "|" +
                                ESTIMATED_COST_XPATH
                )));
        return regionResult.getText().strip().replaceAll("Region: ", "");
    }

    public String getProvisioningModel() {
        return provisioningModel.getText().strip().replaceAll("Provisioning model: ", "");
    }

    public String getInstanceType() {
        return instanceType.getText().strip().replaceAll("Instance type: ", "")
                .replaceAll("Committed Use Discount applied", "")
                .replaceAll("\n", "");
    }

    public String getSsdCommitted() {
        return ssdCommitted.getText().strip().replaceAll("Local SSD: ", "")
                .replaceAll("Committed Use Discount applied", "")
                .replaceAll("\n", "");
    }

    public String getCommitmentTerm() {
        return commitmentTerm.getText().strip().replaceAll("Commitment term: ", "");
    }

    public String getEstimatedCost() {
        return estimatedCost.getText()
                .replaceAll("Estimated Component Cost: USD ", "")
                .replaceAll(" per 1 month", "");
    }

    public void closePage() {
        driver.quit();
    }
}
