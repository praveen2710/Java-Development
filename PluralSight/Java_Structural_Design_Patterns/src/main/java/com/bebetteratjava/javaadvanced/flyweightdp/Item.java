package com.bebetteratjava.javaadvanced.flyweightdp;

//Instances of Item will be the Flyweights.It must be immutable
class Item {
	private final String name;

	public Item(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
}