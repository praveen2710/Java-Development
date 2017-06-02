package com.bebetteratjava.javaadvanced.compositedp;

import java.util.ArrayList;
import java.util.List;

/**
 *This is the primary class that is extended both {@link MenuItem Leaf} and {@link MenuComposite composite}
 */
public abstract class MenuComponent {
	
	String name;
	String url;
	List<MenuComponent> menuComponents = new ArrayList();
	
	public MenuComponent add(MenuComponent menuComponent) {
		throw new UnsupportedOperationException("Feature not implemented at this level");
	}

	public MenuComponent remove(MenuComponent menuComponent) {
		throw new UnsupportedOperationException("Feature not implemented at this level");
	}
	
	public String getName() {
		return name;
	}
	
	public String getUrl() {
		return url;
	}	
	
	public abstract String toString();
	
	String print(MenuComponent menuComponent) {
		StringBuilder builder = new StringBuilder(name);
		builder.append(": ");
		builder.append(url);
		builder.append("\n");
		return builder.toString();
	}
}
