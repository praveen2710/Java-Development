package com.bebetteratjava.javaadvanced.observordp;

//concrete observer
public class PhoneClient extends Observer {

	public PhoneClient (Subject subject) {
		this.subject = subject;
		//attaching observer to subject is done constructor rather than client doing it manually.
		subject.attach(this);
	}
	
	public void addMessage(String message) {
		//when a message is added which changes state of subject which then notifies all observers
		subject.setState(message + " - sent from phone");
	}
	
	@Override
	void update() {
		System.out.println("Phone Stream: " + subject.getState());
	}
}
