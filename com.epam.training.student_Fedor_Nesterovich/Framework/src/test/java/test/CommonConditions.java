package test;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import util.TestListener;

@Listeners({TestListener.class})
public class CommonConditions {

    protected WebDriver driver;

    @BeforeClass()
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @AfterClass()
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}
