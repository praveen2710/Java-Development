package week2;

import week3.acessModiferExample;

public class NotSameNotRelatedPackageModifier {
	public static void main(String args[]){
		acessModiferExample ace = new acessModiferExample();
		//this calls the toString of object by default.
		System.out.println(ace);
	}
}
