package com.bebetteratjava.javaadvanced.abstractfactorydp;

import com.bebetteratjava.javaadvanced.abstractfactorydp.amex.AmexFactory;
import com.bebetteratjava.javaadvanced.abstractfactorydp.visa.VisaFactory;

//AbstractFactory
public abstract class CreditCardFactory {

	public static CreditCardFactory getCreditCardFactory(int creditScore) {
	
		if(creditScore > 650) {
			return new AmexFactory();
		}
		else {
			return new VisaFactory();
		}
	}
	
	public abstract CreditCard getCreditCard(CardType cardType);
		
	public abstract Validator getValidator(CardType cardType);
}
