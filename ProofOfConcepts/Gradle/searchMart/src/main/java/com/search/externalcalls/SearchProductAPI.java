package com.search.externalcalls;

import org.springframework.web.client.RestTemplate;

import com.searchMart.entities.WalmartSearchResult;

/**
 * This class will make a call to Walmart Search Product API
 * @see <a href="https://developer.walmartlabs.com/docs/read/Search_API">Walmart Search API</a>
 * It then stores the retrieved results in a POJO
 * 
 * @author praveen
 *
 */
public class SearchProductAPI {
	
	private String productQuery;	
	
	public SearchProductAPI(String queryString){
		productQuery = queryString;
	}
	
	/**
	 * Makes the API call and stores result in POJO
	 * It should also gracefully handle any errors
	 * @return
	 */
	public WalmartSearchResult searchAPICall(){
		if(productQuery==null||productQuery.isEmpty() || productQuery.trim().isEmpty()){
			throw new NullPointerException("Query string cannot be empty");
		}
		RestTemplate restTemplate = new RestTemplate();
		WalmartSearchResult wsr = restTemplate.getForObject(WalmartAPIDetails.searchUrl, WalmartSearchResult.class,WalmartAPIDetails.APIKey,productQuery);
		return wsr;
	}
}
