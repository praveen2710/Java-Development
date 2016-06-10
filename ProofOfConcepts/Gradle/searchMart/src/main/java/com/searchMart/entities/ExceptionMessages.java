package com.searchMart.entities;

/**
 * This will store the exception message and other details that need to be
 * passed to front end to display to user/ investigate issue's s
 * 
 * @author praveen
 *
 */
public class ExceptionMessages {
	
	private String exceptionMsg;
	
	public static final String queryStringExp = "Query string cannot be empty";
	
	public static final String queryIdExp = "Query Id cannot be empty or invalid";
	
	public String getExceptionMsg() {
		return exceptionMsg;
	}

	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}

}
