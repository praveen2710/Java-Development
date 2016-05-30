package week2;

import java.nio.channels.AcceptPendingException;

import week3.acessModiferExample;

public class NotSamePackageRelatedModifer extends acessModiferExample {
	
	public NotSamePackageRelatedModifer(){
		System.out.println("Accessing public : "+x);
//		System.out.println(" Acsessing private :"+y);
		System.out.println("Acessing Protected :"+a);
//		System.out.println("Acessing default:" +z);
	}
}
