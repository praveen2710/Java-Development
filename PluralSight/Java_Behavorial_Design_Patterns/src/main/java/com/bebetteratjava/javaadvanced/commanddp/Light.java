package com.bebetteratjava.javaadvanced.commanddp;

//receiver
public class Light {

	private boolean isOn = false;

	/**
	 * 	this will return the current state of receiver to
	 * 	{@link com.bebetteratjava.javaadvanced.commanddp.AllLightsCommand command}
	 */
	public boolean isOn() {
		return isOn;
	}
	
	public void toggle() {
		if(isOn) {
			off();
			isOn = false;
		}
		else {
			on();
			isOn = true;
		}
	}
	
	public void on() {
		System.out.println("Light switched on.");
	}
	
	public void off() {
		System.out.println("Light switched off.");
	}
}
