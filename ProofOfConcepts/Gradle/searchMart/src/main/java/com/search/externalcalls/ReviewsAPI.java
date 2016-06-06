package com.search.externalcalls;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.searchMart.entities.ProductRecommendations;
import com.searchMart.entities.ProductReview;
import com.searchMart.entities.WalmartSearchResult;

public class ReviewsAPI {
private String productId;	
	
	public ReviewsAPI(String queryId){
		productId = queryId;
	}
	
	/**
	 * Makes the API call and stores result in POJO
	 * It should also gracefully handle any errors
	 * @return
	 */
	public ProductReview reviewAPICall(){
		if(productId==null||productId.isEmpty() || productId.trim().isEmpty()){
			throw new NullPointerException("Query string cannot be empty");
		}
		List<ProductRecommendations> listItems = new ArrayList<ProductRecommendations>();
		RestTemplate restTemplate = new RestTemplate();
		ProductReview prodReview  = restTemplate.getForObject("http://api.walmartlabs.com/v1/reviews/{productId}?apiKey={apiKey}",ProductReview.class,productId,WalmartAPIKey.APIKey);
		
		return prodReview;
	}
}
