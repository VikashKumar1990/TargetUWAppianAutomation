package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    static Properties getLoadedPropertiesObject() throws IOException {
        //read the file
        FileInputStream fis = new FileInputStream("config/uwcentrac.properties");
        // create the properties object
        Properties prop = new Properties();
        // Load the file object using properties object
        prop.load(fis);
        return prop;
    }

    public static String getAppianUrl() throws IOException {
        return getLoadedPropertiesObject().getProperty("url");
    }
}
