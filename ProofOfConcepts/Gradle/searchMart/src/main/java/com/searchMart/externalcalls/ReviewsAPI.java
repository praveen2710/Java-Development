package com.searchMart.externalcalls;


import org.springframework.web.client.RestTemplate;

import com.searchMart.entities.ExceptionMessages;
import com.searchMart.entities.ProductReview;
/**
 * This class makes a call to API to get review based on product Id
 * @see <a href="https://developer.walmartlabs.com/docs/read/Reviews_Api">Walmart Review API</a>
 * @author praveen
 *
 */
public class ReviewsAPI {
private String productId;	
	
	public ReviewsAPI(String queryId){
		productId = queryId;
	}
	
	/**
	 * Makes the API call and stores result in POJO
	 * It should also gracefully handle any errors
	 * @return Review of a product {@link ProductReview} 
	 */
	public ProductReview reviewAPICall(){
		if(productId==null||productId.isEmpty() || productId.trim().isEmpty()){
			throw new NullPointerException(ExceptionMessages.queryIdExp);
		}
		RestTemplate restTemplate = new RestTemplate();
		ProductReview prodReview  = restTemplate.getForObject(WalmartAPIDetails.reviewUrl,ProductReview.class,productId,WalmartAPIDetails.APIKey);
		
		return prodReview;
	}
}
