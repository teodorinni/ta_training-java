import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.GoogleCloudHomePage;
import page.GoogleCloudPricingCalculatorResultPage;

public class GoogleCloudPricingCalculatorTest {

    private WebDriver driver;
    private GoogleCloudPricingCalculatorResultPage resultPage;

    @BeforeClass
    public void googleCloudPricingCalculatorSearchAndConfiguration() {
        driver = new ChromeDriver();
        GoogleCloudHomePage googleCloudHomePage = new GoogleCloudHomePage(driver);
        resultPage = googleCloudHomePage
                .openPage()
                .startSearch()
                .openPricingCalculatorLink()
                .selectEngineSection()
                .fillNumberOfInstances()
                .selectSeries()
                .selectMachineType()
                .pressAddGpusTickMark()
                .selectGpuType()
                .selectGpuQuantity()
                .selectLocalSsd()
                .selectDatacenterLocation()
                .selectCommittedUsage()
                .addToEstimate();
    }

    @Test
    public void provisioningModelTest() {
        String expectedProvisioningModel = "Regular";
        Assert.assertEquals(resultPage.getProvisioningModel(), expectedProvisioningModel, "The provisioning model (VM Class) is incorrect!");
    }

    @Test
    public void instanceTypeTest() {
        String expectedInstanceType = "n1-standard-8";
        Assert.assertEquals(resultPage.getInstanceType(), expectedInstanceType, "The instance type is incorrect!");
    }

    @Test
    public void regionTest() {
        String expectedRegion = "Frankfurt";
        Assert.assertEquals(resultPage.getRegionResult(), expectedRegion, "The region is incorrect!");
    }

    @Test
    public void ssdCommittedTest() {
        String expectedSsdCommitted = "2x375 GiB";
        Assert.assertEquals(resultPage.getSsdCommitted(), expectedSsdCommitted, "The SSD committed is incorrect!");
    }

    @Test
    public void commitmentTermTest() {
        String expectedCommitmentTerm = "1 Year";
        Assert.assertEquals(resultPage.getCommitmentTerm(), expectedCommitmentTerm, "The commitment term is incorrect!");
    }

    @Test
    public void estimatedCostTest() {
        String expectedEstimatedCost = "1,081.20";
        Assert.assertEquals(resultPage.getEstimatedCost(), expectedEstimatedCost, "The estimated cost is incorrect!");
    }

    @AfterClass
    public void browserClosure() {
        driver.quit();
    }
}
