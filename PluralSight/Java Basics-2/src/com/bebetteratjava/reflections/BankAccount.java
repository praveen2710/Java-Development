package com.bebetteratjava.reflections;

import com.bebetteratjava.customannotations.ProcessedBy;

import java.io.Serializable;

/**
 * Created by pb033954 on 3/31/2017.
 */
@ProcessedBy(AccountWorkerV2.class)
public class BankAccount{
    private final String id;
    private  int balance=0;

    public BankAccount(String id, int balance) {
        this(id);
        this.balance = balance;
    }

    public BankAccount(String id){
       this.id = id;
    }

    public  int getBalance() {
        return balance;
    }

    public String getId() {return id;}

    public  void  deposit(int amount){
        balance += amount;
    }

    public   void withdraw(int amount){
        balance -= amount;
    }
}
