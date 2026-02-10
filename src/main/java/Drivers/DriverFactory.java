package Drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


public class DriverFactory {

    public WebDriver getDriver() {

        WebDriver driver;
        String browser = System.getProperty("browser");

        if (browser == null) {
            throw new RuntimeException("Please pass browser using -Dbrowser");
        }

        switch (browser.toUpperCase()) {

            case "CHROME":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless=new");
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--window-size=1920,1080");
                driver = new ChromeDriver();
                break;

            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case "EDGE":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            case "SAFARI":
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;

            default:
                throw new RuntimeException("Browser not supported: " + browser);
        }

        driver.manage().window().maximize();
        return driver;
    }
}
