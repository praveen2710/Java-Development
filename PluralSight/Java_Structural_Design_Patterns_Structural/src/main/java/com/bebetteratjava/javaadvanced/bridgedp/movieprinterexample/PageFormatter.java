package com.bebetteratjava.javaadvanced.bridgedp.movieprinterexample;

import java.util.List;

/**
 * This is second part of the bridge where we connect Printer to Detail
 */
public class PageFormatter implements Formatter {

	@Override
	public String format(String header, List<Detail> details) {
		StringBuilder builder = new StringBuilder();
		builder.append(header);
		builder.append("\n");

		for (Detail detail : details) {
			builder.append(detail.getLabel());
			builder.append(":");
			builder.append(detail.getValue());
			builder.append("\n");
		}

		return builder.toString();
	}
}
