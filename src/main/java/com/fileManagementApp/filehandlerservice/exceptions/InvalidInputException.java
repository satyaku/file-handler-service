package com.fileManagementApp.filehandlerservice.exceptions;

import java.util.Arrays;

public class InvalidInputException extends RuntimeException {

	private static final long serialVersionUID = 922960038359686655L;

	public InvalidInputException() {
		super();
	}

	public InvalidInputException(String msg) {
		super(msg);
	}

	@Override
	public String toString() {
		return "InvalidInputException [getMessage()=" + getMessage() + ", getLocalizedMessage()="
				+ getLocalizedMessage() + ", getCause()=" + getCause() + ", toString()=" + super.toString()
				+ ", fillInStackTrace()=" + fillInStackTrace() + ", getStackTrace()=" + Arrays.toString(getStackTrace())
				+ ", getSuppressed()=" + Arrays.toString(getSuppressed()) + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}

}
