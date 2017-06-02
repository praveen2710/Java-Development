package com.bebetteratjava.javaadvanced.bridgedp.shapesolution;

public class Circle extends Shape {

	public Circle(Color color) {
		super(color);
	}
	
	@Override
	public void applyColor() {
		color.defineColor();
	}

}
