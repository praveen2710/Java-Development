package com.bebetteratjava.javaadvanced.commanddp;

//concrete command

/**
 * This will switch {@link Light invoker} to on state.Regardless
 * weather it is on or not.
 */
public class OnCommand implements Command {

	private Light light;
	
	public OnCommand(Light light) {
		this.light = light;
	}
	
	@Override
	public void execute() {
		light.on();
	}

}
