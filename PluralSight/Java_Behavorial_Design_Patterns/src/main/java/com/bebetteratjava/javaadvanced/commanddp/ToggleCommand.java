package com.bebetteratjava.javaadvanced.commanddp;

//concrete command

/**
 * This one will toggle the {@link Light invoker} to other state.
 * On if Off and vice versa.It is improvement over {@link OnCommand}
 * which does not check state.
 */
public class ToggleCommand implements Command {

	private Light light;
	
	public ToggleCommand(Light light) {
		this.light = light;
	}

	/**
	 * This calls light.toggle() instead of light.on()
	 */
	@Override
	public void execute() {
		light.toggle();
	}
}