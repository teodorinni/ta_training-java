import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.PastebinHomePage;
import page.PastebinSubmittedPage;

public class PastebinSubmittedDataTest {

    private WebDriver driver;
    private PastebinSubmittedPage submittedPage;

    @BeforeClass
    public void pastebinSetupAndSubmission() {
        driver = new ChromeDriver();
        PastebinHomePage pastebinHomePage = new PastebinHomePage(driver);
        submittedPage = pastebinHomePage
                .openPage()
                .agreeWithPrivacyTerms()
                .fillPasteText()
                .selectSyntaxHighlighting()
                .selectPasteExpirationTime()
                .fillPasteTitle()
                .submitPaste()
                .waitForElementsToLoad();
    }

    @Test
    public void titleNameTest() {
        String expectedTitle = "how to gain dominance among developers";
        Assert.assertEquals(submittedPage.getPageTitle(), expectedTitle, "The page title is incorrect!");
    }

    @Test
    public void syntaxIsBashTest() {
        String expectedSyntaxHighlighting = "Bash";
        Assert.assertEquals(submittedPage.getSyntaxHighlighting(), expectedSyntaxHighlighting, "The syntax highlighting is incorrect!");
    }

    @Test
    public void pasteTextTest() {
        String expectedInputText = """
                git config --global user.name  "New Sheriff in Town"
                git reset $(git commit-tree HEAD^{tree} -m "Legacy code")
                git push origin master --force""";
        Assert.assertEquals(submittedPage.getPasteText(), expectedInputText, "The paste text is incorrect!");
    }

    @AfterClass
    public void browserClosure() {
        driver.quit();
    }
}
