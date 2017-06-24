package com.bebetteratjava.javaadvanced.iteratordp;

import javax.management.AttributeList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorDemoMain {

	public static void main(String[] args) {

		BikeRepository repo = new BikeRepository();
		
		repo.addBike("Cervelo");
		repo.addBike("Scott");
		repo.addBike("Fuji");
		
		Iterator<String> bikeIterator = repo.iterator();
		
		//while(bikeIterator.hasNext()) {
		//	System.out.println(bikeIterator.next());
		//}
		
		for (String bike : repo) {
			System.out.println(bike);
		}

		List example = new ArrayList();
		//this  iterator that is bi-directional
		ListIterator a = example.listIterator();
		a.hasPrevious();
		a.previous();

	}
}
