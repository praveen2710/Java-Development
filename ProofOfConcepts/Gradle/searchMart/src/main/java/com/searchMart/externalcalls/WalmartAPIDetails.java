package com.searchMart.externalcalls;

/**
 * This is a static class to initialize the URL and API key to be used
 * Declared a private constructor to avoid being instantiated
 * @author praveen
 *
 */
public final class WalmartAPIDetails {
	
	private WalmartAPIDetails(){
		
	}
	
	public static final String APIKey = getAPIKey();

	private static String getAPIKey() {
		return "rgcjh9zn65xgegdssd2ayd55";
	}
	
	public static final String searchUrl = "http://api.walmartlabs.com/v1/search?apiKey={apiKey}&query={queryString}";

	public static final String recommendationUrl = "http://api.walmartlabs.com/v1/nbp?apiKey={apiKey}&itemId={itemID}";
	
	public static final String reviewUrl = "http://api.walmartlabs.com/v1/reviews/{productId}?apiKey={apiKey}";
	
}
