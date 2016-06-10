package com.searchMart.externalcalls;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.web.client.HttpClientErrorException;

import com.searchMart.entities.ProductReview;
import com.searchMart.externalcalls.ReviewsAPI;

public class ReviewsAPITest {

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test
	public void testReviewAPI() {
		ReviewsAPI prReviewAPI = new ReviewsAPI("42608121");
		
		ProductReview pr =prReviewAPI.reviewAPICall();
		System.out.println(pr.toString());
		System.out.println(pr.getReviewStatistics().getAverageOverallRating());
	} 
	
	@Test
	public void testReviewAPIEmptyId() {
		ReviewsAPI prReviewAPI = new ReviewsAPI("");
		
		exception.expect(NullPointerException.class);
		ProductReview prEmpty =prReviewAPI.reviewAPICall();
		
		System.out.println(prEmpty.toString());

	} 
	
	@Test
	public void testReviewAPIBadRequest() {
		ReviewsAPI prReviewAPI = new ReviewsAPI("aasd");
		
		exception.expect(HttpClientErrorException.class);
		ProductReview prEmpty =prReviewAPI.reviewAPICall();
		
		System.out.println(prEmpty.toString());

	} 
		
}
