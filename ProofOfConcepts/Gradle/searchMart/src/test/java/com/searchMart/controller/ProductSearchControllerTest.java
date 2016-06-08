package com.searchMart.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import com.search.externalcalls.WalmartAPIDetails;
import com.searchMart.entities.WalmartSearchResult;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.Spring;

import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

public class ProductSearchControllerTest {
	
	private MockRestServiceServer mockServer;
	
	@InjectMocks
	private ProductSearchController prodSearchCtrl;
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext cntx;
	
	private RestTemplate restTemplate;
	
	@Before
	public void setup(){
		 this.restTemplate = new RestTemplate();
		 this.mockServer = MockRestServiceServer.createServer(restTemplate);
		 MockitoAnnotations.initMocks(this);
		 this.mockMvc = MockMvcBuilders.standaloneSetup(prodSearchCtrl).build();
	}

	@Test
	public void testProductSearch() throws Exception {
		
		MvcResult productSearchResult = this.mockMvc.perform(get("/index/search?productName={productName}","ipod"))
		            .andExpect(status().isOk())
		            .andReturn();
		
		System.out.println("Checking response");
		System.out.println(productSearchResult.getResponse().getContentType());
		System.out.println(productSearchResult.getResponse().getStatus());
		System.out.println(productSearchResult.getResponse().getContentAsString());
		
		MvcResult productSearchResultEmpty = this.mockMvc.perform(get("/index/search?productName={productName}",""))
	            .andExpect(status().is5xxServerError())
	            .andReturn();
		
		System.out.println("Checking empty response");
		System.out.println(productSearchResultEmpty.getResponse().getContentAsString());
		
		
	}
	
	@Test
	public void testProductRecommendation() throws Exception {
		MvcResult productRecommendResult = this.mockMvc.perform(get("/index/recommendation?productId={productId}","42608121"))
		            .andExpect(status().isOk())
		            .andReturn();
		
		System.out.println("Checking response");
		System.out.println(productRecommendResult.getResponse().getContentType());
		System.out.println(productRecommendResult.getResponse().getStatus());
		System.out.println(productRecommendResult.getResponse().getContentAsString());
		
		MvcResult productRecommendResultEmpty = this.mockMvc.perform(get("/index/recommendation?productId={productId}",""))
	            .andExpect(status().is5xxServerError())
	            .andReturn();
		
		System.out.println("Checking empty request");
		System.out.println(productRecommendResultEmpty.getResponse().getContentAsString());
		
		MvcResult productRecommendResultInvalidQuery = this.mockMvc.perform(get("/index/recommendation?productId={productId}","ABXC"))
	            .andExpect(status().is5xxServerError())
	            .andReturn();
		
		System.out.println("Checking empty ");
		System.out.println(productRecommendResultInvalidQuery.getResponse().getContentAsString());
		
		
	}	
	
	@Ignore
	@Test
	public void testMockSearch() throws Exception{
			
//		 this.mockServer.expect(requestTo("/hotels/42")).andExpect(method(HttpMethod.GET))
//	     .andRespond(withSuccess("{ \"id\" : \"42\", \"name\" : \"Holiday Inn\"}", MediaType.APPLICATION_JSON));
//
//	     String hotel = restTemplate.getForObject("/hotels/{id}", String.class, 42);
//	     
//	     System.out.println(hotel);
	     
	     URI   mockSearch =restTemplate.getUriTemplateHandler().expand(WalmartAPIDetails.searchUrl, WalmartAPIDetails.APIKey,"ipod");
		 
	     this.mockServer.expect(requestTo(mockSearch)).andExpect(method(HttpMethod.GET))
	     .andRespond(withSuccess("{ \"id\" : \"41\", \"name\" : \"Walmart Inn\"}", MediaType.APPLICATION_JSON));
		 
	 	MvcResult productSearchResult = this.mockMvc.perform(get("/index/search?productName={productName}","ipod"))
	            .andExpect(status().isOk())
	            .andReturn();
	
	System.out.println("Checking response");
	System.out.println(productSearchResult.getResponse().getContentType());
	System.out.println(productSearchResult.getResponse().getStatus());
	System.out.println(productSearchResult.getResponse().getContentAsString());
		 
		 
	}

}
