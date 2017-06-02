package com.bebetteratjava.javaadvanced.proxydp;

public class TwitterServiceStub implements TwitterService {

	@Override
	public String getTimeline(String screenName) {
		return "My neato timeline";
	}

	@Override
	public void postToTimeline(String screenName, String message) {
		
	}

}
