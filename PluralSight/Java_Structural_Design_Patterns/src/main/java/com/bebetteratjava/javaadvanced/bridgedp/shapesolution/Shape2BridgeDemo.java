package com.bebetteratjava.javaadvanced.bridgedp.shapesolution;

/**
 * This is uplift of {@link com.bebetteratjava.javaadvanced.bridgedp.shapepremise.Shape1BridgeDemo Shape1BridgeDemo}
 * now every time we want a new colour for a new shape we don't have to create classes like
 * {@link com.bebetteratjava.javaadvanced.bridgedp.shapepremise.BlueCircle BlueCircle},
 * {@link com.bebetteratjava.javaadvanced.bridgedp.shapepremise.RedCircle RedCircle} etc..
 */
public class Shape2BridgeDemo {

	public static void main(String[] args) {
		Color blue = new Blue();
		
		Shape square = new Square(blue);
		
		Color red = new Red();
		
		Shape circle = new Circle(red);
		
		Color green = new Green();
		
		Shape greenCircle = new Circle(green);
		
		Shape greenSquare = new Square(green);
		
		square.applyColor();
		circle.applyColor();
		greenCircle.applyColor();
		greenSquare.applyColor();
	}

}
