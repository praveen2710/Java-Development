package com.searchMart.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.search.externalcalls.ProductRecommendationAPI;
import com.search.externalcalls.ReviewsAPI;
import com.search.externalcalls.SearchProductAPI;
import com.searchMart.entities.ProductRecommendations;
import com.searchMart.entities.ProductReview;
import com.searchMart.entities.WalmartSearchResult;

/**
 * The controller class where all request for product search and recommendation
 * will come and response will be send.
 * @author praveen
 *
 */
@Controller
public class ProductSearchController {
	
	//mapping will search for a jsp with same name as value
   @RequestMapping(value = "/index")
    public void index()
    {

    }
   
   /**
    * This method will search based on the product Name given.Exceptions are handled
    * by {@link ExceptionControllerAdvice}
    * @param name Name of the product to search
    * @return  search result {@link WalmartSearchResult}
    */
   @RequestMapping(value = "/index/search", method = RequestMethod.GET)
   public ResponseEntity<Object> getProductSearch(@RequestParam("productName") String name) {
       
	   SearchProductAPI spAPI = new SearchProductAPI(name);
	   
	   WalmartSearchResult searchResult = null;

	   searchResult = spAPI.searchAPICall();
	   return new ResponseEntity<Object>(searchResult,HttpStatus.OK);
   }
   
   /**
    * This will retrieve recommendation for a given product and for each recommendation
    * retrieve the reviews on it.
    * @param productId The id of product for which recommendation's are to be found
    * @return List of recommended products {@link ProductRecommendations}
    */
   @RequestMapping(value = "/index/recommendation", method = RequestMethod.GET)
   public ResponseEntity<Object> getProductRecommendations(@RequestParam("productId") String productId){
       
	   ProductRecommendationAPI prAPI = new ProductRecommendationAPI(productId);
	   
	   List<ProductRecommendations> recommendedResult = null;
	   recommendedResult = prAPI.recommendationAPICall();

	   for(ProductRecommendations eachProduct : recommendedResult){
		   ReviewsAPI rewAPI = new ReviewsAPI(eachProduct.getItemId());
		   ProductReview prReview = rewAPI.reviewAPICall();
		   eachProduct.setProductReview(prReview);
	   }
	   return new ResponseEntity<Object>(recommendedResult,HttpStatus.OK);
   }

}
