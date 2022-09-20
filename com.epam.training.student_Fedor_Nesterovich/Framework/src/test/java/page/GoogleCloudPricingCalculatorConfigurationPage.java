package page;

import model.PricingCalculatorConfiguration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleCloudPricingCalculatorConfigurationPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();
    private final static String COMPUTE_ENGINE_SECTION_BUTTON_XPATH = "(//div[@title='Compute Engine'])[1]";
    private final static String NUMBER_OF_INSTANCES_INPUT_XPATH = "(//input[@name='quantity'])[1]";
    private final static String SERIES_SELECTION_XPATH = "//*[contains(@aria-label,'Series')]";
    private final static String MACHINE_TYPE_SELECTION_XPATH = "//*[text()='Machine type']/parent::*";
    private final static String ADD_GPUS_TICK_MARK_XPATH = "(//*[contains(text(),'Add GPUs.')])[1]/parent::*";
    private final static String GPU_TYPE_SELECTION_XPATH = "//*[@placeholder='GPU type']";
    private final static String GPU_QUANTITY_SELECTION_XPATH = "//*[text()='Number of GPUs']/parent::*";
    private final static String LOCAL_SSD_SELECTION_XPATH = "(//*[text()='Local SSD'])[1]/parent::*";
    private final static String DATACENTER_LOCATION_SELECTION_XPATH = "(//*[@placeholder='Datacenter location'])[1]";
    private final static String COMMITTED_USAGE_SELECTION_XPATH = "(//*[@placeholder='Committed usage'])[1]";
    private final static String ADD_TO_ESTIMATE_BUTTON_XPATH = "(//button[@aria-label='Add to Estimate'])[1]";
    private static String numberOfInstances;
    private static String seriesValueXpath;
    private static String machineTypeValueXpath;
    private static String gpuTypeValueXpath;
    private static String gpuQuantityValueXpath;
    private static String localSsdValueXpath;
    private static String datacenterLocationValueXpath;
    private static String committedUsageValueXpath;

    @FindBy(xpath = COMPUTE_ENGINE_SECTION_BUTTON_XPATH)
    private WebElement computeEngineSectionButton;

    @FindBy(xpath = NUMBER_OF_INSTANCES_INPUT_XPATH)
    private WebElement numberOfInstancesInput;

    @FindBy(xpath = SERIES_SELECTION_XPATH)
    private WebElement seriesSelection;

    @FindBy(xpath = MACHINE_TYPE_SELECTION_XPATH)
    private WebElement machineTypeSelection;

    @FindBy(xpath = ADD_GPUS_TICK_MARK_XPATH)
    private WebElement addGpusTickMark;

    @FindBy(xpath = GPU_TYPE_SELECTION_XPATH)
    private WebElement gpuTypeSelection;

    @FindBy(xpath = GPU_QUANTITY_SELECTION_XPATH)
    private WebElement gpuQuantitySelection;

    @FindBy(xpath = LOCAL_SSD_SELECTION_XPATH)
    private WebElement localSsdSelection;

    @FindBy(xpath = DATACENTER_LOCATION_SELECTION_XPATH)
    private WebElement datacenterLocationSelection;

    @FindBy(xpath = COMMITTED_USAGE_SELECTION_XPATH)
    private WebElement committedUsageSelection;

    @FindBy(xpath = ADD_TO_ESTIMATE_BUTTON_XPATH)
    private WebElement addToEstimateButton;

    public GoogleCloudPricingCalculatorConfigurationPage(WebDriver driver, PricingCalculatorConfiguration calculatorConfiguration) {
        super(driver);
        numberOfInstances = calculatorConfiguration.getNumberOfInstances();
        seriesValueXpath = calculatorConfiguration.getSeriesValueXpath();
        machineTypeValueXpath = calculatorConfiguration.getMachineTypeValueXpath();
        gpuTypeValueXpath = calculatorConfiguration.getGpuTypeValueXpath();
        gpuQuantityValueXpath = calculatorConfiguration.getGpuQuantityValueXpath();
        localSsdValueXpath = calculatorConfiguration.getLocalSsdValueXpath();
        datacenterLocationValueXpath = calculatorConfiguration.getDatacenterLocationValueXpath();
        committedUsageValueXpath = calculatorConfiguration.getCommittedUsageValueXpath();
        logger.info("The Google Cloud Pricing Calculator page has been opened.");
        PageFactory.initElements(this.driver, this);
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
        logger.info("Engine calculation has been selected");
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
                                GPU_QUANTITY_SELECTION_XPATH + "|" +
                                LOCAL_SSD_SELECTION_XPATH + "|" +
                                DATACENTER_LOCATION_SELECTION_XPATH + "|" +
                                COMMITTED_USAGE_SELECTION_XPATH )));
        numberOfInstancesInput.click();
        numberOfInstancesInput.sendKeys(numberOfInstances);
        logger.info("Number of instances has been selected.");
        return this;
    }

    public GoogleCloudPricingCalculatorConfigurationPage selectSeries() {
        seriesSelection.click();
        WebElement seriesValue = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(seriesValueXpath)));
        seriesValue.click();
        logger.info("Series have been selected.");
        return this;
    }

    public GoogleCloudPricingCalculatorConfigurationPage selectMachineType() {
        machineTypeSelection.click();
        WebElement machineTypeValue = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(machineTypeValueXpath)));
        machineTypeValue.click();
        logger.info("Machine type has been selected.");
        return this;
    }

    public GoogleCloudPricingCalculatorConfigurationPage pressAddGpusTickMark() {
        addGpusTickMark.click();
        new WebDriverWait(driver,
                Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(GPU_TYPE_SELECTION_XPATH + "|" + GPU_QUANTITY_SELECTION_XPATH)));
        return this;
    }

    public GoogleCloudPricingCalculatorConfigurationPage selectGpuType() {
        gpuTypeSelection.click();
        WebElement gpuTypeValue = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(gpuTypeValueXpath)));
        gpuTypeValue.click();
        return this;
    }

    public GoogleCloudPricingCalculatorConfigurationPage selectGpuQuantity() {
        gpuQuantitySelection.click();
        WebElement gpuQuantityValue = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(gpuQuantityValueXpath)));
        gpuQuantityValue.click();
        logger.info("GPUs have been selected.");
        return this;
    }

    public GoogleCloudPricingCalculatorConfigurationPage selectLocalSsd() {
        localSsdSelection.click();
        WebElement localSsdValue = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(localSsdValueXpath)));
        localSsdValue.click();
        logger.info("Local SSDs have been selected.");
        return this;
    }

    public GoogleCloudPricingCalculatorConfigurationPage selectDatacenterLocation() {
        datacenterLocationSelection.click();
        WebElement datacenterLocationValue = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(datacenterLocationValueXpath)));
        datacenterLocationValue.click();
        logger.info("Datacenter location has been selected.");
        return this;
    }

    public GoogleCloudPricingCalculatorConfigurationPage selectCommittedUsage() {
        committedUsageSelection.click();
        WebElement committedUsageValue = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(committedUsageValueXpath)));
        committedUsageValue.click();
        logger.info("Committed usage has been selected.");
        return this;
    }
    public GoogleCloudPricingCalculatorResultPage addToEstimate() {
        new WebDriverWait(driver,
                Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(ADD_TO_ESTIMATE_BUTTON_XPATH)));
        addToEstimateButton.click();
        logger.info("Added to estimate");
        return new GoogleCloudPricingCalculatorResultPage(driver);
    }
}
