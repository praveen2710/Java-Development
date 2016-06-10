package com.searchMart.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.searchMart.entities.ExceptionMessages;

/**
 * This will handle exception from the controller class and respond accordingly
 * to the front end based on kind of exception occurred.
 * @author praveen
 *
 */
@ControllerAdvice
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {
	
	private static final Logger logger = LogManager.getLogger();

	 /**
     * Catch all for any other exceptions and NullPointer Exception
     */
    @ExceptionHandler({Exception.class,NullPointerException.class})
    protected ResponseEntity<Object> handleUnknownException(Exception ex, WebRequest request) {
    	logger.error("Exception Stack",ex);
    	
    	ExceptionMessages emsg =new ExceptionMessages();
    	   emsg.setExceptionMsg(ex.getMessage());
    	   return new ResponseEntity<Object>(emsg, HttpStatus.INTERNAL_SERVER_ERROR);
	 }
    
    /**
     * This will reroute all http exception encountered from API calls to server
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler( {HttpClientErrorException.class})
    protected ResponseEntity<Object> handleHttpException(HttpClientErrorException ex, WebRequest request){
    	logger.error("http client error stack",ex);
    	
    	ExceptionMessages emsg =new ExceptionMessages();
 	    emsg.setExceptionMsg(ex.getMessage());
 	    return new ResponseEntity<Object>(emsg,ex.getStatusCode());
    } 
    
}
