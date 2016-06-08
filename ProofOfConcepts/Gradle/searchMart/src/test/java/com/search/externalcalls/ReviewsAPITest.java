package com.search.externalcalls;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.searchMart.entities.ProductReview;

public class ReviewsAPITest {

	@Test
	public void testReviewAPI() {
		ReviewsAPI prReviewAPI = new ReviewsAPI("42608121");
		
		ProductReview a =prReviewAPI.reviewAPICall();
		System.out.println(a.toString());
		System.out.println(a.getReviewStatistics().getAverageOverallRating());
	} 
		
}
