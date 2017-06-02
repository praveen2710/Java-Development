package com.bebetteratjava.javaadvanced.factorydp;

import com.bebetteratjava.javaadvanced.factorydp.websites.Website;

public class FactoryDemoMain {

	public static void main(String[] args) {
		Website site = WebsiteFactory.getWebsite(WebsiteType.BLOG);
		
		System.out.println("********* Blog Website  ****************");
		site.getPages().forEach(page -> System.out.println(page.pageDescription()));
		site = WebsiteFactory.getWebsite(WebsiteType.SHOP);
		
		System.out.println("******** Shopping Website ***************");
		site.getPages().forEach(page -> System.out.println(page.pageDescription()));
	}

}
