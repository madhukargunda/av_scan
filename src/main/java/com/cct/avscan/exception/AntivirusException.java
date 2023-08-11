package com.cct.avscan.exception;

public class AntivirusException extends Exception {
	
    private static final long serialVersionUID = 1L;

	public AntivirusException(String message) {
        super(message);
    }

    public AntivirusException(String message, Throwable cause) {
        super(message, cause);
    }
}