package com.bebetteratjava.javaadvanced.builderdp;

public class LunchOrderBeanDemoMain {

public static void main(String args[]) {
		
		LunchOrderBean lunchOrderBean = new LunchOrderBean();
		
//		lunchOrderBean.setBread("Wheat");
//		lunchOrderBean.setCondiments("Lettuce");
//		lunchOrderBean.setDressing("Mustard");
//		lunchOrderBean.setMeat("Ham");

		//This approach has issues where we cannot define what is required and what is optional
		//A sandwich without bread does not make sense but we cannot enforce bread in here.

		System.out.println(lunchOrderBean.getBread());
		System.out.println(lunchOrderBean.getCondiments());
		System.out.println(lunchOrderBean.getDressing());
		System.out.println(lunchOrderBean.getMeat());	
	}
	
}
