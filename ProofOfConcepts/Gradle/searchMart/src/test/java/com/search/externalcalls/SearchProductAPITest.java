package com.search.externalcalls;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.web.client.HttpClientErrorException;

import com.searchMart.entities.Items;
import com.searchMart.entities.WalmartSearchResult;

import junit.framework.TestCase;

/**
 * Will be Testing to mimic scenario such as 
 * 1)Happy path where the url has correct query string
 * 2)path where the API key is incorrect
 * 3)path where the query string is empty
 * @author praveen
 *
 */

public class SearchProductAPITest{
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setUp() {
	  System.out.println("Setting it up!");
		try {
			setFinalStatic(WalmartAPIDetails.class.getField("APIKey"), "rgcjh9zn65xgegdssd2ayd55");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Test
	public void testSearchAPI() {
		SearchProductAPI spi = new SearchProductAPI("ipod");
		
		WalmartSearchResult wsp = spi.searchAPICall();
		
		System.out.println(wsp.toString());
		Items[] item = wsp.getItems();
		System.out.println(item[0].getItemId());
	}
	
	@Test
	public void testSearchAPIWithEmptyQueryString() {
		SearchProductAPI spi = new SearchProductAPI("");
	
		System.out.println(WalmartAPIDetails.APIKey);
		
		exception.expect(NullPointerException.class);
		WalmartSearchResult wsp = spi.searchAPICall();
		
		System.out.println(wsp.toString());
	
	}
	
	@Test
	public void testSearchAPIWithNullQueryString() {
		SearchProductAPI spi = new SearchProductAPI(null);
	
		System.out.println(WalmartAPIDetails.APIKey);
		
		exception.expect(NullPointerException.class);
		WalmartSearchResult wsp = spi.searchAPICall();
		
		System.out.println(wsp.toString());
	
	}
	
	@Test
	public void testSearchAPIEmptyBadAPIKey() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		
		SearchProductAPI spi = new SearchProductAPI("ipod");
		try {
			setFinalStatic(WalmartAPIDetails.class.getField("APIKey"), "asas");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("In Bad API test API = "+WalmartAPIDetails.APIKey);
		
		exception.expect(HttpClientErrorException.class);
//		exception.expect(hasProperty("response", hasProperty("status", is(403))));
		WalmartSearchResult wsp  = spi.searchAPICall();
		
		System.out.println(wsp.toString());
		
	
	}
	
	  static void setFinalStatic(Field field, Object newValue) throws Exception {
	      field.setAccessible(true);
	
	      Field modifiersField = Field.class.getDeclaredField("modifiers");
	      modifiersField.setAccessible(true);
	      modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
	
	      field.set(null, newValue);
	   }

}
