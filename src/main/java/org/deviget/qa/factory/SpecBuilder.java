package org.deviget.qa.factory;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.deviget.qa.exceptions.RequestError;
import org.deviget.qa.exceptions.ResponseError;
import org.hamcrest.Matcher;

import java.util.Map;

public class SpecBuilder {
    /**
     * This Method is used to specific all request needed for make a request and receive queryParams
     * @param queryParams
     *
     */

    public static RequestSpecification requestSpecification (Map<String, String>queryParams) throws RequestError {
        RequestSpecification requestSpecification = new RequestSpecBuilder().addQueryParams(queryParams).setContentType(ContentType.JSON).build();
    return requestSpecification;
    }
    /**
     * This Method is used to specify the expected responses and validate them
     * @param httpStatus
     *
     */
    public static ResponseSpecification responseSpecification (int httpStatus)throws ResponseError {
        ResponseSpecification responseSpecificationSpec = new ResponseSpecBuilder().expectStatusCode(httpStatus).expectHeader("Content-Type", "application/json; charset=utf-8").expectContentType(ContentType.JSON).build();
        return responseSpecificationSpec;
    }
}
