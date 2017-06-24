package com.bebetteratjava.javaadvanced.commanddp;

import java.util.List;

public class AllLightsCommand implements Command {

	private List<Light> lights;
	
	public AllLightsCommand(List<Light> lights) {
		this.lights = lights;
	}
	
	@Override
	public void execute() {
		for (Light light : lights) {
			//this check is added so we don't switch on a light that is already off.
			if(light.isOn()) {
				light.toggle();
			}
		}
	}

}
