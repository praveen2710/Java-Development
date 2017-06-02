package com.bebetteratjava.javaadvanced.compositedp;

import java.util.Iterator;

/**
 * This is composite class which has children under it
 */
public class MenuComposite extends MenuComponent {
	
	public MenuComposite(String name, String url) {
		this.name = name;
		this.url = url;
	}

	//returning the component that is added or removed adds point of reference
	//and does not cost anything
	@Override
	public MenuComponent add(MenuComponent menuComponent) {
		menuComponents.add(menuComponent);
		return menuComponent;
	}
	
	@Override
	public MenuComponent remove(MenuComponent menuComponent) {
		menuComponents.remove(menuComponent);
		return menuComponent;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(); //builder pattern
		
		builder.append(print(this));
		
		Iterator<MenuComponent> itr = menuComponents.iterator();
		while(itr.hasNext()) {
			MenuComponent menuComponent = itr.next();
			builder.append(menuComponent.toString());
		}
		
		return builder.toString();
	}
}
