package com.bebetteratjava.javaadvanced.bridgedp.shapesolution;

public class Square extends Shape {

	public Square(Color color) {
		super(color);
	}
	
	@Override
	public void applyColor() {
		color.defineColor();
	}

}
