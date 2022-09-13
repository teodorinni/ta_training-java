import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.PastebinHomePage;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        PastebinHomePage pastebinHomePage = new PastebinHomePage(driver);
        pastebinHomePage
                .openPage()
                .agreeWithPrivacyTerms()
                .fillPasteText()
                .selectPasteExpirationTime()
                .fillPasteTitle();
        Thread.sleep(5000); // for visualization only
        pastebinHomePage.submitPaste();
        Thread.sleep(5000); // for visualization only
        pastebinHomePage.closePage();
    }
}
