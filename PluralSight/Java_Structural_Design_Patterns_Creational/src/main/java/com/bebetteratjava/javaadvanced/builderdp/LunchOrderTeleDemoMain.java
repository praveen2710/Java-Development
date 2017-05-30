package com.bebetteratjava.javaadvanced.builderdp;

public class LunchOrderTeleDemoMain {

	public static void main(String args[]) {

		LunchOrderTele lunchOrderTele = new LunchOrderTele("Wheat", "Lettuce", "Mustard", "Ham");

		//This
		// lunchOrderTele.setBread("Wheat");
		// lunchOrderTele.setCondiments("Lettuce");
		// lunchOrderTele.setDressing("Mustard");
		// lunchOrderTele.setMeat("Ham");

		//We have an enforced contract which is better than {@link com.bebetteratjava.javaadvanced.builderdp.LunchOrderBean}
		//But we have to write constructor for every possible permutation which is lot of code

		System.out.println(lunchOrderTele.getBread());
		System.out.println(lunchOrderTele.getCondiments());
		System.out.println(lunchOrderTele.getDressing());
		System.out.println(lunchOrderTele.getMeat());
	}

}
