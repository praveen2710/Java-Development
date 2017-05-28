package com.bebetteratjava.javaadvanced.decoratordp;

public abstract class SandwichDecorator implements Sandwich {


	protected Sandwich customSandwich;

	//This can be a concrete component or an instance of concrete decorator
	public SandwichDecorator(Sandwich customSandwich) {
		this.customSandwich = customSandwich;
	}

	public String make() {
		return customSandwich.make();
	}
	
}
