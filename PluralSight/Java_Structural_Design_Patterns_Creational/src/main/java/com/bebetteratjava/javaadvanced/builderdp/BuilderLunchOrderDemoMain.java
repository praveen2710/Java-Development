package com.bebetteratjava.javaadvanced.builderdp;

public class BuilderLunchOrderDemoMain {

	public static void main(String args[]) {
		
		LunchOrder.Builder builder = new LunchOrder.Builder();
		
		builder.bread("Wheat").dressing("Mayo").meat("Turkey");

		//.build() can be something more related like builder.makemesandwhich()
		LunchOrder lunchOrder = builder.build();

		//This instance is immutable i.e once it is build it cannot be changed.
		System.out.println(lunchOrder.getBread());
		System.out.println(lunchOrder.getCondiments());
		System.out.println(lunchOrder.getDressing());
		System.out.println(lunchOrder.getMeat());
	}
}
