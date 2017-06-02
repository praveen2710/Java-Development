package com.bebetteratjava.javaadvanced.bridgedp.movieprinterexample;

import java.util.List;

/**
 * This is the composition class in this example
 */
public interface Formatter {
	String format(String header, List<Detail> details);
}
