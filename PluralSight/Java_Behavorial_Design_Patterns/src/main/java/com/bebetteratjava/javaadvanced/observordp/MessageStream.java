package com.bebetteratjava.javaadvanced.observordp;

import java.util.ArrayDeque;
import java.util.Deque;

//concrete subject
public class MessageStream extends Subject {

	//Double ended queue . Java's implementation for stack behavior
	private Deque<String> messageHistory = new ArrayDeque<>();
	
	@Override
	void setState(String message) {
		messageHistory.add(message);
		this.notifyObservers();
	}

	@Override
	String getState() {
		return messageHistory.getLast();
	}
}
