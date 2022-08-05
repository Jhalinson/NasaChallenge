package org.deviget.qa.utils;

import org.jetbrains.annotations.NotNull;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * class to get the values of the configuration properties file
 */
public class PropertyReader
{

    @NotNull
    public static Properties getAllPropertiesFromFile(){
        Properties prop = new Properties();
        try {
            InputStream input = new FileInputStream("src/test/java/org/deviget/qa/resources/Config.Properties");
            prop.load(input);
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
        return prop;
    }

    public static String getNasaBaseUrl(Properties properties){
        return properties.getProperty("nasaBaseUrl");
    }
    public static String getSolValue(Properties properties){
        return properties.getProperty("sol");
    }
    public static String getApiKey(Properties properties){
        return properties.getProperty("api_key");
    }
    public static String getPage(Properties properties){
        return properties.getProperty("page");
    }
    public static String getCamera(Properties properties){
        return properties.getProperty("camera");
    }
    public static String getEarthDate(Properties properties){
        return properties.getProperty("earth_date");
    }
    public static String getPath(Properties properties){
        return properties.getProperty("path");
    }
    public static String getOpportunityPath(Properties properties){
        return properties.getProperty("opportunityPath");
    }
    public static String getSpiritPath(Properties properties){
        return properties.getProperty("spiritPath");
    }





}
