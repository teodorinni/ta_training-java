package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleCloudPricingCalculatorConfigurationPage {

    private final WebDriver driver;
    private final static String NUMBER_OF_INSTANCES = "4";
    private final static String COMPUTE_ENGINE_SECTION_BUTTON_XPATH = "(//div[@title='Compute Engine'])[1]";
    private final static String NUMBER_OF_INSTANCES_INPUT_XPATH = "(//input[@name='quantity'])[1]";
    private final static String SERIES_SELECTION_XPATH = "//*[contains(@aria-label,'Series')]";
    private final static String SERIES_VALUE_XPATH = "//*[@value='n1']";
    private final static String MACHINE_TYPE_SELECTION_XPATH = "//*[text()='Machine type']/parent::*";
    private final static String MACHINE_TYPE_VALUE_XPATH = "//*[contains(text(),'n1-standard-8 (vCPUs: 8, RAM: 30GB')]";
    private final static String ADD_GPUS_TICK_MARK_XPATH = "(//*[contains(text(),'Add GPUs.')])[1]/parent::*";
    private final static String GPU_TYPE_SELECTION_XPATH = "//*[@placeholder='GPU type']";
    private final static String GPU_TYPE_VALUE_XPATH = "//*[@value='NVIDIA_TESLA_V100']";
    private final static String GPU_NUMBER_SELECTION_XPATH = "//*[text()='Number of GPUs']/parent::*";
    private final static String GPU_NUMBER_VALUE_XPATH = "//*[contains(@ng-repeat,'supportedGpuNumbers')][@value='1']";
    private final static String LOCAL_SSD_SELECTION_XPATH = "(//*[text()='Local SSD'])[1]/parent::*";
    private final static String LOCAL_SSD_VALUE_XPATH = "//*[contains(text(),'2x375 GB')]/parent::*";
    private final static String DATACENTER_LOCATION_SELECTION_XPATH = "(//*[@placeholder='Datacenter location'])[1]";
    private final static String DATACENTER_LOCATION_VALUE_XPATH = "//*[contains(text(),'Frankfurt (europe-west3)')]/parent::*[contains(@ng-repeat,'computeServer')]";
    private final static String COMMITTED_USAGE_SELECTION_XPATH = "(//*[@placeholder='Committed usage'])[1]";
    private final static String COMMITTED_USAGE_VALUE_XPATH = "(//*[contains(text(),'1 Year')])[2]/parent::*";
    private final static String ADD_TO_ESTIMATE_BUTTON_XPATH = "(//button[@aria-label='Add to Estimate'])[1]";

    @FindBy(xpath = COMPUTE_ENGINE_SECTION_BUTTON_XPATH)
    private WebElement computeEngineSectionButton;

    @FindBy(xpath = NUMBER_OF_INSTANCES_INPUT_XPATH)
    private WebElement numberOfInstancesInput;

    @FindBy(xpath = SERIES_SELECTION_XPATH)
    private WebElement seriesSelection;

    @FindBy(xpath = SERIES_VALUE_XPATH)
    private WebElement seriesValue;

    @FindBy(xpath = MACHINE_TYPE_SELECTION_XPATH)
    private WebElement machineTypeSelection;

    @FindBy(xpath = MACHINE_TYPE_VALUE_XPATH)
    private WebElement machineTypeValue;

    @FindBy(xpath = ADD_GPUS_TICK_MARK_XPATH)
    private WebElement addGpusTickMark;

    @FindBy(xpath = GPU_TYPE_SELECTION_XPATH)
    private WebElement gpuTypeSelection;

    @FindBy(xpath = GPU_TYPE_VALUE_XPATH)
    private WebElement gpuTypeValue;

    @FindBy(xpath = GPU_NUMBER_SELECTION_XPATH)
    private WebElement gpuNumberSelection;

    @FindBy(xpath = GPU_NUMBER_VALUE_XPATH)
    private WebElement gpuNumberValue;

    @FindBy(xpath = LOCAL_SSD_SELECTION_XPATH)
    private WebElement localSsdSelection;

    @FindBy(xpath = LOCAL_SSD_VALUE_XPATH)
    private WebElement localSsdValue;

    @FindBy(xpath = DATACENTER_LOCATION_SELECTION_XPATH)
    private WebElement datacenterLocationSelection;

    @FindBy(xpath = DATACENTER_LOCATION_VALUE_XPATH)
    private WebElement datacenterLocationValue;

    @FindBy(xpath = COMMITTED_USAGE_SELECTION_XPATH)
    private WebElement committedUsageSelection;

    @FindBy(xpath = COMMITTED_USAGE_VALUE_XPATH)
    private WebElement committedUsageValue;

    @FindBy(xpath = ADD_TO_ESTIMATE_BUTTON_XPATH)
    private WebElement addToEstimateButton;

    public GoogleCloudPricingCalculatorConfigurationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public GoogleCloudPricingCalculatorConfigurationPage selectEngineSection() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='devsite-snackbar-action']"))).click();
        WebElement iframe = new WebDriverWait(driver,
                Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//iframe)[1]")));
        driver.switchTo().frame(iframe);
        WebElement iframeInside = new WebDriverWait(driver,
                Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@id='myFrame']")));
        driver.switchTo().frame(iframeInside);
        new WebDriverWait(driver,
                Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(COMPUTE_ENGINE_SECTION_BUTTON_XPATH)));
        computeEngineSectionButton.click();
        return this;
    }

    public GoogleCloudPricingCalculatorConfigurationPage fillNumberOfInstances() {
        new WebDriverWait(driver,
                Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(
                        NUMBER_OF_INSTANCES_INPUT_XPATH + "|" +
                                SERIES_SELECTION_XPATH + "|" +
                                MACHINE_TYPE_SELECTION_XPATH + "|" +
                                ADD_GPUS_TICK_MARK_XPATH + "|" +
                                GPU_TYPE_SELECTION_XPATH + "|" +
                                GPU_NUMBER_SELECTION_XPATH + "|" +
                                LOCAL_SSD_SELECTION_XPATH + "|" +
                                DATACENTER_LOCATION_SELECTION_XPATH + "|" +
                                COMMITTED_USAGE_SELECTION_XPATH )));
        numberOfInstancesInput.click();
        numberOfInstancesInput.sendKeys(NUMBER_OF_INSTANCES);
        return this;
    }

    public GoogleCloudPricingCalculatorConfigurationPage selectSeries() {
        seriesSelection.click();
        new WebDriverWait(driver,
                Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(SERIES_VALUE_XPATH)));
        seriesValue.click();
        return this;
    }

    public GoogleCloudPricingCalculatorConfigurationPage selectMachineType() {
        machineTypeSelection.click();
        new WebDriverWait(driver,
                Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(MACHINE_TYPE_VALUE_XPATH)));
        machineTypeValue.click();
        return this;
    }

    public GoogleCloudPricingCalculatorConfigurationPage addGpus() {
        addGpusTickMark.click();
        new WebDriverWait(driver,
                Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(GPU_TYPE_SELECTION_XPATH + "|" + GPU_NUMBER_SELECTION_XPATH)));
        gpuTypeSelection.click();
        new WebDriverWait(driver,
                Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(GPU_TYPE_VALUE_XPATH)));
        gpuTypeValue.click();
        gpuNumberSelection.click();
        new WebDriverWait(driver,
                Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(GPU_NUMBER_VALUE_XPATH)));
        gpuNumberValue.click();
        return this;
    }

    public GoogleCloudPricingCalculatorConfigurationPage selectLocalSsd() {
        localSsdSelection.click();
        new WebDriverWait(driver,
                Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(LOCAL_SSD_VALUE_XPATH)));
        localSsdValue.click();
        return this;
    }

    public GoogleCloudPricingCalculatorConfigurationPage selectDatacenterLocation() {
        datacenterLocationSelection.click();
        new WebDriverWait(driver,
                Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(DATACENTER_LOCATION_VALUE_XPATH)));
        datacenterLocationValue.click();
        return this;
    }

    public GoogleCloudPricingCalculatorConfigurationPage selectCommittedUsage() {
        committedUsageSelection.click();
        new WebDriverWait(driver,
                Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(COMMITTED_USAGE_VALUE_XPATH)));
        committedUsageValue.click();
        return this;
    }
    public GoogleCloudPricingCalculatorResultPage addToEstimate() {
        new WebDriverWait(driver,
                Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(ADD_TO_ESTIMATE_BUTTON_XPATH)));
        addToEstimateButton.click();
        return new GoogleCloudPricingCalculatorResultPage(driver);
    }

    public void closePage() {
        driver.quit();
    }
}
