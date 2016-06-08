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


@Controller
public class ProductSearchController {
	
	//mapping will search for a jsp with same name as value
   @RequestMapping(value = "/index")
    public void index()
    {

    }
   
   /**
    * This method will search based on the product Name given. If no result was found or
    * if the search string was empty/invalid a message must be shown to user.
    * @param name
    * @return
    */
   @RequestMapping(value = "/index/search", method = RequestMethod.GET)
   public ResponseEntity<Object> getProductSearch(@RequestParam("productName") String name) {
       
	   SearchProductAPI spAPI = new SearchProductAPI(name);
	   
	   WalmartSearchResult searchResult = null;
	   try{
	     searchResult = spAPI.searchAPICall();
	   }catch(Exception e){
		  return new ResponseEntity<Object>("Internal Server Error Occured",HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	   return new ResponseEntity<Object>(searchResult,HttpStatus.OK);
   }
   
   @RequestMapping(value = "/index/recommendation", method = RequestMethod.GET)
   public ResponseEntity<Object> getProductRecommendations(@RequestParam("productId") String productId) {
       
	   ProductRecommendationAPI prAPI = new ProductRecommendationAPI(productId);
	   
	   List<ProductRecommendations> recommendedResult = null;
	   try{
		   recommendedResult = prAPI.recommendationAPICall();

		   for(ProductRecommendations eachProduct : recommendedResult){
			   ReviewsAPI rewAPI = new ReviewsAPI(eachProduct.getItemId());
			   ProductReview prReview = rewAPI.reviewAPICall();
			   eachProduct.setProductReview(prReview);
		   }
	   }catch(Exception e){
		   e.printStackTrace();
		   return new ResponseEntity<Object>("Internal Server Error Occured",HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	   return new ResponseEntity<Object>(recommendedResult,HttpStatus.OK);
   }

}
