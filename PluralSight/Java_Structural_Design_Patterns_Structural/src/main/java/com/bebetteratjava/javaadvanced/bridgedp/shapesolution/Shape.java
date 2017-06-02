package com.bebetteratjava.javaadvanced.bridgedp.shapesolution;

/**
 * This is update to {@link com.bebetteratjava.javaadvanced.bridgedp.shapepremise.Shape Shape}
 * where we are leveraging composition
 */
public abstract class Shape {

	protected Color color;
	
	public Shape(Color color) {
		this.color = color;
	}
	
	abstract public void applyColor();
}
