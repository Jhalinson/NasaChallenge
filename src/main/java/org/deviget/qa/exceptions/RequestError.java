package org.deviget.qa.exceptions;
/**
 * This class is used to handle request errors
 */
public class RequestError extends Exception {

    /**
     * This Method is used to handled a request as error
     *
     */
    public RequestError() {
        super("There was an error trying to execute the request");
    }
    /**
     * This Method is used to handled a request as error
     * @param additionalInfo
     */
    public RequestError(String additionalInfo) {
        super("There was an error trying to execute the request. " + additionalInfo);
    }
    /**
     * This Method is used to handled a request as error
     * @param cause
     * @param message
     */
    public RequestError(String message, Throwable cause) {
        super(message, cause.getCause());
    }
}
