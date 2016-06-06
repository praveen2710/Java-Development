package com.search.externalcalls;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.searchMart.entities.ProductRecommendations;

public class ProductRecommendationAPITest {

	@Test
	public void testAPI() {
		ProductRecommendationAPI prAPI = new ProductRecommendationAPI("42608121");
		
		List<ProductRecommendations> pra = prAPI.recommendationAPICall();
		
		for(ProductRecommendations a: pra){
			System.out.println(a.getItemId());
		}
		
	}

}
