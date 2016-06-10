package com.searchMart.externalcalls;

import org.springframework.web.client.RestTemplate;

import com.searchMart.entities.ExceptionMessages;
import com.searchMart.entities.WalmartSearchResult;

/**
 * This class will make a call to Walmart Search Product API
 * @see <a href="https://developer.walmartlabs.com/docs/read/Search_API">Walmart Search API</a>
 * @author praveen
 *
 */
public class SearchProductAPI {
	
	private String productQuery;	
	
	public SearchProductAPI(String queryString){
		productQuery = queryString;
	}
	
	/**
	 * This method retrieves products based on search criteria
	 * @return the search result {@code WalmartSearchResult}
	 */
	public WalmartSearchResult searchAPICall(){
		if(productQuery==null||productQuery.isEmpty() || productQuery.trim().isEmpty()){
			throw new NullPointerException(ExceptionMessages.queryStringExp);
		}
		RestTemplate restTemplate = new RestTemplate();
		WalmartSearchResult wsr = restTemplate.getForObject(WalmartAPIDetails.searchUrl, WalmartSearchResult.class,WalmartAPIDetails.APIKey,productQuery);
		return wsr;
	}
}
