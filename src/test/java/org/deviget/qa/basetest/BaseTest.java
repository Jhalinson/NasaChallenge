package org.deviget.qa.basetest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import org.apache.http.HttpStatus;
import org.deviget.qa.constants.FrameworkPaths;
import org.deviget.qa.utils.Configuration;
import org.deviget.qa.utils.PropertyReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.util.Map;

import static io.restassured.RestAssured.given;

@Listeners(org.deviget.qa.reports.ExtentReport.class)
public class BaseTest  {
    protected Response response;
    protected PropertyReader readerProterty;
    protected FrameworkPaths frameworkPaths = new FrameworkPaths();

    /**
     * Method to call and initialize the base URI
     */
    @SneakyThrows
    @BeforeMethod (alwaysRun = true)
    public void setUp() {
        readerProterty = new PropertyReader();
        RestAssured.baseURI = Configuration.NASA_BASE_URL;

    }

}
