package com.bebetteratjava.javaadvanced.commanddp;

import java.util.ArrayList;
import java.util.List;

//client
public class CommandDemoMain {

	public static void main(String args[]) {
		onCommandDemo();
		toggleCommandDemo();
		allLightDemo();
	}

	/**
	 * Showing usage of {@link OnCommand}
	 */
	private static void onCommandDemo() {
		Light light = new Light();
		Switch lightSwitch = new Switch();
		Command onCommand = new OnCommand(light);

		lightSwitch.storeAndExecute(onCommand);
	}

	/**
	 * This is improvement over {@link OnCommand} where we store
	 * and use state in {@link Light receiver}
	 */
	private static void toggleCommandDemo() {
		Light light = new Light();
		Switch lightSwitch = new Switch();

		Command toggleCommand = new ToggleCommand(light);

		lightSwitch.storeAndExecute(toggleCommand);
		lightSwitch.storeAndExecute(toggleCommand);
		lightSwitch.storeAndExecute(toggleCommand);
	}

	private static void allLightDemo() {
		System.out.println("All Lights Demo");
		Light bedroomLight = new Light();
		Light kitchenLight = new Light();
		Switch lightSwitch = new Switch();

		List<Light> lights = new ArrayList<>();
		lights.add(kitchenLight);
		lights.add(bedroomLight);
		Command allLightsCommand = new AllLightsCommand(lights);

		lightSwitch.storeAndExecute(allLightsCommand);
	}
}
