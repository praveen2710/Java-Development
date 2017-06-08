package com.bebetteratjava.javaadvanced.observordp;

public abstract class Observer {
	// Unlike java's observer here we have subject in context
	// and we attach observer to subject in concrete implementation
	protected Subject subject;
	abstract void update();
}
