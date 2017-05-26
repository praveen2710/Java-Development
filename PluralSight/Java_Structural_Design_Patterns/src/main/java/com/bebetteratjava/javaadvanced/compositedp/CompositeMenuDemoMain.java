package com.bebetteratjava.javaadvanced.compositedp;


public class CompositeMenuDemoMain {

	public static void main(String[] args) {
		
		MenuComposite mainMenuComposite = new MenuComposite("Main", "/main");

		MenuItem safetyMenuItem = new MenuItem("Safety", "/safety");

		mainMenuComposite.add(safetyMenuItem);

		MenuComposite claimsSubMenuComposite = new MenuComposite("Claims", "/claims");

		mainMenuComposite.add(claimsSubMenuComposite);

		MenuItem personalClaimsMenu = new MenuItem("Personal Claim", "/personalClaims");

		claimsSubMenuComposite.add(personalClaimsMenu);

		System.out.println(mainMenuComposite.toString());
	}
}
