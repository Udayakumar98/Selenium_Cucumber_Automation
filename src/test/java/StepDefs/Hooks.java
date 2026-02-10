package StepDefs;

import Drivers.DriverFactory;
import Drivers.DriverManager;
import Utilities.ExcelReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Hooks {

    private DriverFactory factory;

    @Before
    public void launchBrowser() {
//        comment below line while running thru property file
        ExcelReader.loadData();
        factory = new DriverFactory();
        WebDriver driver = factory.getDriver();
        DriverManager.setDriver(driver);
    }

    @After(order = 0)
    public void quit() {
        DriverManager.quitDriver();
    }

    @After(order = 1)
    public void failedScreenShot(Scenario s) {

        if (s.isFailed()) {
            TakesScreenshot t = (TakesScreenshot) DriverManager.getDriver();
            byte[] b = t.getScreenshotAs(OutputType.BYTES);
            s.attach(b, "image/png", "FailedScreenShot");
        }
    }

}
