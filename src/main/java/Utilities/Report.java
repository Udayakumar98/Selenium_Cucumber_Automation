package Utilities;

import junit.textui.TestRunner;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Report{

    public static void generateReport(String json){

        File f=new File(System.getProperty("user.dir")+"/target/Results");
        Configuration config=new Configuration(f,"Amazon Project");
        config.addClassifications("Platform","Web");
        config.addClassifications("browser","Chrome");

        List<String> li=new ArrayList<>();
        li.add(json);

        ReportBuilder r=new ReportBuilder(li,config);
        r.generateReports();

    }
}
