package com.search.externalcalls;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.searchMart.entities.ProductRecommendations;

public class ProductRecommendationAPITest {
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test
	public void testRecommendationAPI() {
		ProductRecommendationAPI prAPI = new ProductRecommendationAPI("42608121");
		
		List<ProductRecommendations> pra = prAPI.recommendationAPICall();
		
		for(ProductRecommendations eachProd: pra){
			System.out.println(eachProd.getItemId());
		}
	}
	
	@Test
	public void testRecommendationAPIEmptyQuery() {
		ProductRecommendationAPI prAPI = new ProductRecommendationAPI("");
		
		exception.expect(NullPointerException.class);
		List<ProductRecommendations> pra = prAPI.recommendationAPICall();
		
		for(ProductRecommendations eachProd: pra){
			System.out.println(eachProd.getItemId());
		}
	}

}
