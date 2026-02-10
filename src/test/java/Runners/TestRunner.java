package Runners;

import Utilities.Report;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.joda.time.format.DateTimeFormat;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/Features"},glue = {"StepDefs"},monochrome = true,dryRun = false,tags = "@iphone",plugin = {"json:target/Results/CucumberReport.json","rerun:target/FailedTestCase.txt","pretty"})
public class TestRunner {

    public static String beforeTime;
    public static String afterTime;

    @BeforeClass
    public static void beforeStart(){
        LocalDateTime before=LocalDateTime.now();
        DateTimeFormatter format=DateTimeFormatter.ofPattern("dd-MM-yyyy, HH:mm:ss");
        beforeTime=format.format(before);
    }

    @AfterClass
    public static void afterEnd(){
        LocalDateTime after=LocalDateTime.now();
        DateTimeFormatter format=DateTimeFormatter.ofPattern("dd-MM-yyyy, HH:mm:ss");
        afterTime=format.format(after);
        Report.generateReport(System.getProperty("user.dir")+"/target/Results/CucumberReport.json");
    }
}
