package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    public String getConfig(String propertyKey){

        Properties properties = new Properties();
        FileInputStream fileInputStream = null;
        String propertyValue = "";
        try {
            fileInputStream = new FileInputStream("src/test/resources/config/config.properties");
            properties.load(fileInputStream);
            propertyValue = properties.getProperty(propertyKey);

        }catch (Exception e){

        }
        return propertyValue;
    }

}
