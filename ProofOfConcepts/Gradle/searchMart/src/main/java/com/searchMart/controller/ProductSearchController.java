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
import com.searchMart.entities.testUser;


@Controller
public class ProductSearchController {
	
	//mapping will search for a jsp with same name as value
   @RequestMapping(value = "/index")
    public void index()
    {

    }
   
   @RequestMapping(value = "/index/search", method = RequestMethod.GET)
   public ResponseEntity<WalmartSearchResult> getProductSearch(@RequestParam("productName") String name) {
       
	   SearchProductAPI spAPI = new SearchProductAPI(name);
	   
	   WalmartSearchResult searchResult = spAPI.searchAPICall();
	   
	   return new ResponseEntity<WalmartSearchResult>(searchResult,HttpStatus.OK);
   }
   
   @RequestMapping(value = "/index/recommendation", method = RequestMethod.GET)
   public ResponseEntity<List<ProductRecommendations>> getProductRecommendations(@RequestParam("productId") String productId) {
       
	   ProductRecommendationAPI prAPI = new ProductRecommendationAPI(productId);
	   
	   List<ProductRecommendations> recommendedResult = prAPI.recommendationAPICall();
	   
	   for(ProductRecommendations eachProduct : recommendedResult){
		   ReviewsAPI rewAPI = new ReviewsAPI(eachProduct.getItemId());
		   ProductReview prReview = rewAPI.reviewAPICall();
		   eachProduct.setProductReview(prReview);
	   }
	   	   
	   return new ResponseEntity<List<ProductRecommendations>>(recommendedResult,HttpStatus.OK);
   }

}
