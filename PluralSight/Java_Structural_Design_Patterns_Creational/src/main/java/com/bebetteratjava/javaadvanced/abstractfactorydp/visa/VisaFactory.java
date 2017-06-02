package com.bebetteratjava.javaadvanced.abstractfactorydp.visa;

import com.bebetteratjava.javaadvanced.abstractfactorydp.CardType;
import com.bebetteratjava.javaadvanced.abstractfactorydp.CreditCard;
import com.bebetteratjava.javaadvanced.abstractfactorydp.CreditCardFactory;
import com.bebetteratjava.javaadvanced.abstractfactorydp.Validator;

public class VisaFactory extends CreditCardFactory {

	@Override
	public CreditCard getCreditCard(CardType cardType) {
		switch (cardType) {
			case GOLD:
				
				return new VisaGoldCreditCard();
	
			case PLATINUM:
				
				return new VisaBlackCreditCard();	
			
		}
		
		return null;
	}

	@Override
	public Validator getValidator(CardType cardType) {
		return new VisaValidator();
	}

}
