package com.bebetteratjava.javaadvanced.chainofresponsibilitydp;

/**
 * a common interface implemented by {@link CEO},{@link Director},{@link VP}
 */
public abstract class Handler {

	protected Handler successor;
	
	public void setSuccessor(Handler successor) {
		this.successor = successor;
	}
	
	public abstract void handleRequest(Request request);
	
}
