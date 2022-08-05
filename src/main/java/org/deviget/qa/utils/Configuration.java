package org.deviget.qa.utils;

import java.util.Properties;
/**
 * class that helps to configure the required routes in the framework
 */

public class Configuration {

    public Configuration() {
    }
    private static final Properties PROPERTIES = PropertyReader.getAllPropertiesFromFile();

    public static final String NASA_BASE_URL = PropertyReader.getNasaBaseUrl(PROPERTIES);
    public static final String SOL_VALUE = PropertyReader.getSolValue(PROPERTIES);
    public static final String API_KEY = PropertyReader.getApiKey(PROPERTIES);
    public static final String CAMERA = PropertyReader.getCamera(PROPERTIES);
    public static final String PAGE = PropertyReader.getPage(PROPERTIES);
    public static final String EARTH_DATE = PropertyReader.getEarthDate(PROPERTIES);
    public static final String PATH = PropertyReader.getPath(PROPERTIES);
    public static final String SPIRIT_PATH = PropertyReader.getSpiritPath(PROPERTIES);
    public static final String OPPORTUNITY_PATH = PropertyReader.getOpportunityPath(PROPERTIES);

    public static final String URI = "https://api.nasa.gov";
    public static final String PHOTOS = "/mars-photos/api/v1/rovers/curiosity/photos";







}
