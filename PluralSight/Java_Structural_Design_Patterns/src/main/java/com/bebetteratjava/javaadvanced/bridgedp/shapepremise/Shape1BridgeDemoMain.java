package com.bebetteratjava.javaadvanced.bridgedp.shapepremise;

public class Shape1BridgeDemoMain {

	public static void main(String args[]) {

		Circle circle = new BlueCircle();

		Square square = new RedSquare();
		
		Square greenSquare = new GreenSquare();

		circle.applyColor();
		square.applyColor();
		greenSquare.applyColor();
	}

}
