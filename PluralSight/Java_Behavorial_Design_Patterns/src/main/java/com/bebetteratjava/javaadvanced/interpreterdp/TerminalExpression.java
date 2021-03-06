package com.bebetteratjava.javaadvanced.interpreterdp;

import java.util.StringTokenizer;

/**
 * This is a terminal expression that does evaluation
 */
public class TerminalExpression implements Expression {

	private String data;

	public TerminalExpression(String data) {
		this.data = data;
	}


	@Override
	public boolean interpret(String str) {
		StringTokenizer st = new StringTokenizer(str);
		while (st.hasMoreTokens()) {
			String test = st.nextToken();
			if (test.equals(data)) {
				return true;
			}
		}
		return false;

	}
}