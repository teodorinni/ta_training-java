package page;

import org.openqa.selenium.WebDriver;

public class Steps {

    public GoogleCloudHomePage googleCloudHomePage;
    public GoogleCloudPricingCalculatorResultPage googleCloudPricingCalculatorResultPage;
    public YopMailPage yopMailPage;

    public Steps(WebDriver driver) {
        googleCloudHomePage = new GoogleCloudHomePage(driver);
    }

    public void getGoogleCloudPricingCalculatorResultPage() {
        googleCloudPricingCalculatorResultPage =  googleCloudHomePage
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

    public void getYopMailPage() {
        yopMailPage = googleCloudPricingCalculatorResultPage
                .clickEmailButton()
                .createNewTab()
                .openPage()
                .acceptPrivacyTerms()
                .generateRandomEmail();
    }

    public void sendEmail(String email) {
        googleCloudPricingCalculatorResultPage = yopMailPage
                .goToFirstTab()
                .fillEmail(email)
                .clickSendEmailButton();
    }

    public void checkMailbox() {
        yopMailPage = googleCloudPricingCalculatorResultPage
                .goToSecondTab()
                .acceptPrivacyTerms()
                .goToMailbox();
    }
}
