package com.musicapp.application.exception;

public class NotAuthenticated extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NotAuthenticated(String message) {
        super(message);
    }

    public NotAuthenticated(String message, Throwable cause) {
        super(message, cause);
    }
}
