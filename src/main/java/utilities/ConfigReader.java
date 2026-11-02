package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    static Properties getLoadedPropertiesObject() throws IOException {
        //1. Read the file
        FileInputStream fis = new FileInputStream("Config/config.properties");

        //2. Create the object of Properties Class
        Properties prop = new Properties();

        //3. Load the prop object with file object
        prop.load(fis);

        return prop;
    }
    public static String getUrl() throws IOException {
        return getLoadedPropertiesObject().getProperty("url");
    }
    public static String getUserName() throws IOException {
        return getLoadedPropertiesObject().getProperty("username");
    }
    public static String getPassword() throws IOException {
        return getLoadedPropertiesObject().getProperty("password");
    }

}
