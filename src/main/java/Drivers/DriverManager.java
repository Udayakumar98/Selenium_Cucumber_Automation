package Drivers;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static ThreadLocal<WebDriver> driver=new ThreadLocal<>();

    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void setDriver(WebDriver driverInstance){
        driver.set(driverInstance);
    }

    public static void quitDriver(){
        if(getDriver()!=null){
            getDriver().quit();
            driver.remove();
        }
    }
}
