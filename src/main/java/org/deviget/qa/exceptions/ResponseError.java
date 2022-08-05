package org.deviget.qa.exceptions;
/**
 * This Class is used to handled respond errors
 *
 */
public class ResponseError extends Exception{
    /**
     * This Method is used to handled respond errors
     */

    public ResponseError() {
        super("There was an error trying to get the respond" );
    }
    /**
     * This Method is used to handled respond errors and get any additional info about the error
     * @param additionalInfo
     *
     */
    public ResponseError(String additionalInfo) {
        super("There was an error trying to get the response. " + additionalInfo);
    }
}
