import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.GoogleCloudHomePage;
import page.GoogleCloudPricingCalculatorResultPage;
import page.YopMailPage;

public class GoogleCloudPricingCalculatorTest {

    private WebDriver driver;
    private YopMailPage resultPage;
    private static String expectedEstimatedCost;

    @BeforeClass
    public void googleCloudPricingCalculatorSearchAndConfiguration() {
        driver = new ChromeDriver();
        GoogleCloudHomePage googleCloudHomePage = new GoogleCloudHomePage(driver);
        GoogleCloudPricingCalculatorResultPage calculatorResultPage = googleCloudHomePage
                .openPage()
                .startSearch()
                .openPricingCalculatorLink()
                .selectEngineSection()
                .fillNumberOfInstances()
                .selectSeries()
                .selectMachineType()
                .addGpus()
                .selectLocalSsd()
                .selectDatacenterLocation()
                .selectCommittedUsage()
                .addToEstimate();
        expectedEstimatedCost = calculatorResultPage.getEstimatedCost();
        YopMailPage yopMailPage = calculatorResultPage
                .clickEmailButton()
                .createNewTab()
                .openMailPage()
                .acceptPrivacyTerms()
                .generateRandomEmail();
        String generatedEmail = yopMailPage.getGeneratedEmail();
        GoogleCloudPricingCalculatorResultPage googleCloudPricingCalculatorResultPage = yopMailPage
                .goToFirstTab()
                .fillEmail(generatedEmail)
                .clickSendEmailButton();
        resultPage = googleCloudPricingCalculatorResultPage
                .goToSecondTab()
                .acceptPrivacyTerms()
                .goToMailbox();

    }

    @Test
    public void estimatedCostTest() {
        Assert.assertEquals(resultPage.getEstimatedCost(), expectedEstimatedCost, "The estimated cost is incorrect!");
    }

    @AfterClass
    public void browserClosure() {
        driver.quit();
    }
}
