package com.bebetteratjava.threadsandconcurrency;

/**
 * Created by pb033954 on 3/30/2017.
 */
public class BankAccountNotSync {

    private  int balance;

    public BankAccountNotSync(int startBalance){
        this.balance = startBalance;
    }

    public  int getBalance() {
        return balance;
    }

    public void  deposit(int amount){
        balance += amount;
    }
}
