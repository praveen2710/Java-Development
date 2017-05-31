package com.bebetteratjava.javaadvanced.prototypedp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PrototypeDemoMain {

	public static void main(String[] args) {

		correctWayToUseObjects();
		pitFallsInPrototypePattern();
	}

	/**
	 * This example shows how when cloning if done improperly
	 * can cause issue where field in a instance can have unexpected values
	 */
	private static void pitFallsInPrototypePattern() {
		Registry registry = new Registry();
		Movie movie = (Movie) registry.createItem("Movie");
		movie.setTitle("Creational Patterns in Java Again");

		List<Record> movieCrew = movie.getPersonDetails();
		movieCrew.add(new Record("Peter Quill",45));

		System.out.println(movie);
		System.out.println(movie.getRuntime());
		System.out.println(movie.getTitle());
		System.out.println(movie.getUrl());
		movie.getPersonDetails().forEach(item-> System.out.println(item.getName() +" "+item.getAge()));

		Movie anotherMovie = (Movie) registry.createItem("Movie");
		anotherMovie.setTitle("Gang of Four Sequel");

		System.out.println(anotherMovie);
		System.out.println(anotherMovie.getRuntime());
		System.out.println(anotherMovie.getTitle());
		System.out.println(anotherMovie.getUrl());
		System.out.println(anotherMovie.getPersonDetails());
		//Here we got peter quill as unintended side effect of how things were saved
		//since both instances have same instance of record object.
		anotherMovie.getPersonDetails().forEach(item-> System.out.println(item.getName() +" "+item.getAge()));
	}

	private static void correctWayToUseObjects() {
		Registry registry = new Registry();
		Movie movie = (Movie) registry.createItem("Movie");
		movie.setTitle("Creational Patterns in Java");
//		Correct way to insert value in objects since we are replacing the default object
		ArrayList<Record> movieCrew = new ArrayList<>();
		movieCrew.add(new Record("Peter Quill",45));
		movie.setPersonDetails(movieCrew);

		System.out.println(movie);
		System.out.println(movie.getRuntime());
		System.out.println(movie.getTitle());
		System.out.println(movie.getUrl());
		movie.getPersonDetails().forEach(item-> System.out.println(item.getName() +" "+item.getAge()));

		Movie anotherMovie = (Movie) registry.createItem("Movie");
		anotherMovie.setTitle("Gang of Four");

		System.out.println(anotherMovie);
		System.out.println(anotherMovie.getRuntime());
		System.out.println(anotherMovie.getTitle());
		System.out.println(anotherMovie.getUrl());
		System.out.println(anotherMovie.getPersonDetails());
		anotherMovie.getPersonDetails().forEach(item-> System.out.println(item.getName() +" "+item.getAge()));
	}

}
