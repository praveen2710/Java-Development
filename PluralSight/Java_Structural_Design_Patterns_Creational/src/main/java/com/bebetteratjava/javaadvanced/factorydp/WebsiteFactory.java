package com.bebetteratjava.javaadvanced.factorydp;

import com.bebetteratjava.javaadvanced.factorydp.websites.Blog;
import com.bebetteratjava.javaadvanced.factorydp.websites.Shop;
import com.bebetteratjava.javaadvanced.factorydp.websites.Website;

public class WebsiteFactory {

	public static Website getWebsite(WebsiteType siteType) {
		switch(siteType) {
			case BLOG : {
				return new Blog();
			}
		
			case SHOP : {
				return new Shop();
			}
			
			default : {
				return null;
			}
 		}
	}
	
}
