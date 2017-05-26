package com.bebetteratjava.javaadvanced.bridgedp.movieprinterexample;

/**
 * In this example we will show how we can leverage bridge pattern
 * To connect two parts Printer and formatter in a way where we our
 * {@link Printer} can define the details on what needs to be printed
 * and our {@link Formatter} shows the details without each of them depending on
 * other for details
 */
public class BridgeDemoMain {

	public static void main(String[] args) {
		Movie movie = new Movie();
		movie.setClassification("Action");
		movie.setTitle("John Wick");
		movie.setRuntime("2:15");
		movie.setYear("2014");
		
		Formatter pageFormatter = new PageFormatter();
		Printer moviePrinter = new MoviePrinter(movie);
		
		String printedMaterial = moviePrinter.print(pageFormatter);
		
		System.out.println(printedMaterial);
		
//		Formatter htmlFormatter = new HtmlFormatter();
		
//		String htmlMaterial = moviePrinter.print(htmlFormatter);
		
//		System.out.println(htmlMaterial);
	}

}
