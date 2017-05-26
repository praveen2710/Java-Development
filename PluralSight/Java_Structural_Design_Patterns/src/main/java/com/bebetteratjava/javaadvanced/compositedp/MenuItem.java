package com.bebetteratjava.javaadvanced.compositedp;


/**
 * This is the leaf class which extends menu component
 */
public class MenuItem extends MenuComponent {

	public MenuItem(String name, String url) {
		this.name = name;
		this.url = url;
	}
	
	@Override
	public String toString() {
		return print(this);
	}
}
