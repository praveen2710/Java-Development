package com.bebetteratjava.javaadvanced.bridgedp.movieprinterexample;

/**
 * It is a name value pair to pass information between bridge pieces
 * {@link MoviePrinter} and {@link PageFormatter}
 *
 */
public class Detail {
	private String label;
	private String value;

	public Detail(String label, String value) {
		this.label = label;
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public String getValue() {
		return value;
	}

}