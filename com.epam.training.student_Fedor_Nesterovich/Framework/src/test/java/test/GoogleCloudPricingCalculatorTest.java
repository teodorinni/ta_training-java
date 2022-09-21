package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.Steps;

public class GoogleCloudPricingCalculatorTest extends CommonConditions {

    @Test
    public void estimatedCostTest() {
        Steps steps = new Steps(driver);
        steps.getGoogleCloudPricingCalculatorResultPage();
        String expectedEstimatedCost = steps.googleCloudPricingCalculatorResultPage.getEstimatedCost();
        steps.getYopMailPage();
        String generatedEmail = steps.yopMailPage.getGeneratedEmail();
        steps.sendEmail(generatedEmail);
        steps.checkMailbox();
        String estimatedCost = steps.yopMailPage.getEstimatedCost();
        Assert.assertEquals(estimatedCost, expectedEstimatedCost, "The estimated cost is incorrect!");
    }
}
