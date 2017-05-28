package com.bebetteratjava.javaadvanced.proxydp;

public interface TwitterService {
	public String getTimeline(String screenName);
	public void postToTimeline(String screenName, String message);
}
