package com.bebetteratjava.javaadvanced.bridgedp.movieprinterexample;

import java.util.List;

/**This calls in the {@link com.bebetteratjava.javaadvanced.bridgedp.movieprinterexample.Formatter}
 * class
 */
public abstract class Printer {

	public String print(Formatter formatter) {
		return formatter.format(getHeader(), getDetails());
	}
	
	abstract protected List<Detail> getDetails();
	
	abstract protected String getHeader();
}
