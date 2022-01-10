package com.jan.ry;

public class ErrorPageException extends Exception{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public ErrorPageException(String errorMessage, String string) {
	    super(errorMessage);
	}

}
