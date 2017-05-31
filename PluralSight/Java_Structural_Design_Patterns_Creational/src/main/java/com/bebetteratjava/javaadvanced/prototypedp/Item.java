package com.bebetteratjava.javaadvanced.prototypedp;

import java.util.List;

public abstract class Item implements Cloneable {
	private String title;
	private double price;
	private String url;
	private List<Record> personDetails;

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<Record> getPersonDetails() {
		return personDetails;
	}
	public void setPersonDetails(List<Record> personDetails) {
		this.personDetails = personDetails;
	}

}
