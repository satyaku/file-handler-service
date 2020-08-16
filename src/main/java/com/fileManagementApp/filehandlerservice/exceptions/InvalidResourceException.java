package com.fileManagementApp.filehandlerservice.exceptions;

import java.util.Arrays;

public class InvalidResourceException extends RuntimeException {

	private static final long serialVersionUID = -2316928422257956962L;

	public InvalidResourceException() {
		super();
	}

	public InvalidResourceException(String msg) {
		super(msg);
	}

	@Override
	public String toString() {
		return "InvalidResourceException [getMessage()=" + getMessage() + ", getLocalizedMessage()="
				+ getLocalizedMessage() + ", getCause()=" + getCause() + ", toString()=" + super.toString()
				+ ", fillInStackTrace()=" + fillInStackTrace() + ", getStackTrace()=" + Arrays.toString(getStackTrace())
				+ ", getSuppressed()=" + Arrays.toString(getSuppressed()) + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}

}
