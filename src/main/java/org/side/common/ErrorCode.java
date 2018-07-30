package org.side.common;

import com.fasterxml.jackson.annotation.JsonValue;

// TODO: Auto-generated Javadoc
/**
 * Enumeration of REST Error types.
 * 
 * @author nadia
 *
 *      
 */
public enum ErrorCode {
    
    /** The global. */
    GLOBAL(2),

    /** The authentication. */
    AUTHENTICATION(10), /** The jwt token expired. */
 JWT_TOKEN_EXPIRED(11);
    
    /** The error code. */
    private int errorCode;

    /**
     * Instantiates a new error code.
     *
     * @param errorCode the error code
     */
    private ErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * Gets the error code.
     *
     * @return the error code
     */
    @JsonValue
    public int getErrorCode() {
        return errorCode;
    }
}
