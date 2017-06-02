package com.bebetteratjava.javaadvanced.factorydp.websites;

import com.bebetteratjava.javaadvanced.factorydp.pages.AboutPage;
import com.bebetteratjava.javaadvanced.factorydp.pages.CommentPage;
import com.bebetteratjava.javaadvanced.factorydp.pages.ContactPage;
import com.bebetteratjava.javaadvanced.factorydp.pages.PostPage;

public class Blog extends Website {

	@Override
	public void createWebsite() {
		pages.add(new PostPage());
		pages.add(new AboutPage());
		pages.add(new CommentPage());
		pages.add(new ContactPage());
	}

}
