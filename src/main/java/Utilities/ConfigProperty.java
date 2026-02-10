package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigProperty {

    private static Properties prop;

    static {
        try {
            String env=System.getProperty("environment");
            if (env.equalsIgnoreCase("QA")||env.equalsIgnoreCase("UAT")) {
                String dir = System.getProperty("user.dir");

                FileInputStream file = new FileInputStream(dir + "/src/test/resources/Properties/"+env.toUpperCase()+".properties");
                prop=new Properties();
                prop.load(file);
            }else{
                throw new IllegalArgumentException("Unsupported environment specified");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties",e);
        }
    }

    public static String getURL(String property){
        return prop.getProperty(property);
    }

}
