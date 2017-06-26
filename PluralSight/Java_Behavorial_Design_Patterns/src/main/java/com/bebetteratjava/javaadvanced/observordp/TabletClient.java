package com.bebetteratjava.javaadvanced.observordp;

//concrete observer
public class TabletClient extends Observer {

	public TabletClient (Subject subject) {
		this.subject = subject;
		subject.attach(this);
	}
	
	public void addMessage(String message) {
		//we are setting state of subject in here.
		subject.setState(message + " - sent from tablet");
	}
	
	@Override
	void update() {
		System.out.println("Tablet Stream: " + subject.getState());
	}

}
