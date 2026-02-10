package PomClass;

import Drivers.DriverManager;
import Utilities.ConfigProperty;
import Utilities.ExcelReader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BaseClass {


    public static void launchURL(){
//        Load data using property files
//        DriverManager.getDriver().get(ConfigProperty.getURL("url"));

//        Load data using Excel files
        DriverManager.getDriver().get(ExcelReader.getData("url"));

    }

    public void sendKeysOnElement(WebElement element,String value){
        waitForElement(element);
        element.clear();
        element.sendKeys(value);
    }

    public void waitForElement(WebElement element){
        WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickElement(WebElement element){
        waitForElement(element);
        element.click();
    }

    public void jsClick(WebElement element){
        JavascriptExecutor js=(JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].click()",element);
    }

    public void jsScroll(WebElement element){
        JavascriptExecutor js=(JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView()",element);
    }

    public void switchTabs(){
        List<String> tabs=new ArrayList<>(DriverManager.getDriver().getWindowHandles());
        DriverManager.getDriver().switchTo().window(tabs.get(1));
    }
}
