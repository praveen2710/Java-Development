package com.bebetteratjava.javaadvanced.abstractfactorydp.amex;

import com.bebetteratjava.javaadvanced.abstractfactorydp.CardType;
import com.bebetteratjava.javaadvanced.abstractfactorydp.CreditCard;
import com.bebetteratjava.javaadvanced.abstractfactorydp.CreditCardFactory;
import com.bebetteratjava.javaadvanced.abstractfactorydp.Validator;

public class AmexFactory extends CreditCardFactory {

	@Override
	public CreditCard getCreditCard(CardType cardType) {
		
		switch (cardType) {
			case GOLD:
				return new AmexGoldCreditCard();
	
			case PLATINUM:
				return new AmexPlatinumCreditCard();	
				
			default:
				break;
		}
		
		return null;
	}

	@Override
	public Validator getValidator(CardType cardType) {
		
		switch (cardType) {
			case GOLD:
				
				return new AmexGoldValidator();
	
			case PLATINUM:
				
				return new AmexPlatinumValidator();	
		
		}
		
		return null;
	}
}
