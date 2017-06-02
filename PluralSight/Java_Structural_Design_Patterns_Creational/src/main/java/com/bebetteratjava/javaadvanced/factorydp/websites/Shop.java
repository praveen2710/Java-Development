package com.bebetteratjava.javaadvanced.factorydp.websites;

import com.bebetteratjava.javaadvanced.factorydp.pages.CartPage;
import com.bebetteratjava.javaadvanced.factorydp.pages.ItemPage;
import com.bebetteratjava.javaadvanced.factorydp.pages.SearchPage;

public class Shop extends Website {

	@Override
	public void createWebsite() {
		pages.add(new CartPage());
		pages.add(new ItemPage());
		pages.add(new SearchPage());
	}

}
