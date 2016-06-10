package com.searchMart.externalcalls;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.searchMart.entities.ExceptionMessages;
import com.searchMart.entities.ProductRecommendations;

/**
 * This will retrieve recommendation based of a given product
 * @see <a href="https://developer.walmartlabs.com/docs/read/Product_Recommendation_API">Walmart Recommendation API</a>
 * @author praveen
 *
 */
public class ProductRecommendationAPI {
	
	private String productId;	
	
	public ProductRecommendationAPI(String queryId){
		productId = queryId;
	}
	
	/**
	 * Makes the API call and stores result in POJO
	 * It should also gracefully handle any errors
	 * @return
	 */
	public List<ProductRecommendations> recommendationAPICall(){
		if(productId==null||productId.isEmpty() || productId.trim().isEmpty()){
			throw new NullPointerException(ExceptionMessages.queryIdExp);
		}
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<ProductRecommendations>> responseEntity  = restTemplate.exchange(WalmartAPIDetails.recommendationUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<ProductRecommendations>>() {
        },WalmartAPIDetails.APIKey,productId);
		List<ProductRecommendations> products = responseEntity.getBody();
		return products;
	}
}
