package com.bebetteratjava.javaadvanced.decoratordp;

public class DecoratorSandwichDemoMain {

	public static void main(String args[]) {
		//here meat decorator takes instance of Meat decorator which is concrete implementation of decorator class
		Sandwich sandwich = new DressingDecorator(new MeatDecorator(new SimpleSandwich()));
		
		System.out.println(sandwich.make());
	}
}
