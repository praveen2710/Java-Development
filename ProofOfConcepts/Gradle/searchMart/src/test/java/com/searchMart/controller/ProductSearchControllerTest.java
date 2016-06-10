package com.searchMart.controller;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;

import com.searchMart.entities.ExceptionMessages;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ProductSearchControllerTest {
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	private MockRestServiceServer mockServer;
	
	@InjectMocks
	private ProductSearchController prodSearchCtrl;
	
	private MockMvc mockMvc;
		
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
		
		exception.expect(Exception.class);
		exception.expectMessage(ExceptionMessages.queryStringExp);
		this.mockMvc.perform(get("/index/search?productName={productName}",""))
	            .andExpect(status().is5xxServerError())
	            .andReturn();
		
		
		
				
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
		
		
		exception.expect(Exception.class);
		exception.expectMessage(ExceptionMessages.queryIdExp);
		this.mockMvc.perform(get("/index/recommendation?productId={productId}",""))
	            .andExpect(status().is5xxServerError())
	            .andReturn();
						
	}	
	
	
}
