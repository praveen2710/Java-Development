package com.bebetteratjava.javaadvanced.abstractfactorydp.amex;

import com.bebetteratjava.javaadvanced.abstractfactorydp.CreditCard;
import com.bebetteratjava.javaadvanced.abstractfactorydp.Validator;

public class AmexGoldValidator implements Validator {

	@Override
	public boolean isValid(CreditCard creditCard) {
		
		return false;
	}

}
