package com.trilogyed.tasker.exception;

public class FeignClientException extends RuntimeException {
    /**
     * Constructs a new FeignClientException exception
     */
    public FeignClientException() {
        super();
    }

    /**
     * Constructs a new runtime exception with the specified message.
     * @param message
     */
    public FeignClientException(String message) {
        super(message);
    }
}
