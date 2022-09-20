package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.GoogleCloudHomePage;
import page.GoogleCloudPricingCalculatorResultPage;
import page.YopMailPage;

public class GoogleCloudPricingCalculatorTest extends CommonConditions {

    @Test
    public void estimatedCostTest() {
            GoogleCloudHomePage googleCloudHomePage = new GoogleCloudHomePage(driver);
            GoogleCloudPricingCalculatorResultPage calculatorResultPage = googleCloudHomePage
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
        String expectedEstimatedCost = calculatorResultPage.getEstimatedCost();
            YopMailPage yopMailPage = calculatorResultPage
                    .clickEmailButton()
                    .createNewTab()
                    .openPage()
                    .acceptPrivacyTerms()
                    .generateRandomEmail();
            String generatedEmail = yopMailPage.getGeneratedEmail();
            GoogleCloudPricingCalculatorResultPage googleCloudPricingCalculatorResultPage = yopMailPage
                    .goToFirstTab()
                    .fillEmail(generatedEmail)
                    .clickSendEmailButton();
        YopMailPage resultPage = googleCloudPricingCalculatorResultPage
                .goToSecondTab()
                .acceptPrivacyTerms()
                .goToMailbox();
        Assert.assertEquals(resultPage.getEstimatedCost(), expectedEstimatedCost, "The estimated cost is incorrect!");
    }
}
