package com.bebetteratjava.threadsandconcurrency;

/**
 * Created by pb033954 on 3/29/2017.
 */
public class BankAccount {



    private  int balance;

    public BankAccount(int startBalance){
        this.balance = startBalance;
    }

    public synchronized int getBalance() {
        return balance;
    }

    /**This is a non atomic operation which contain multiple
     steps [Read from mem,Perform Addition,Wrote to mem].
     This can cause issue where other thread might execute
     in between the multiple steps.
     This is where coordinating method access comes in
     */

    public synchronized void  deposit(int amount){
        balance += amount;
    }

    public synchronized  void withdraw(int amount){
        balance -= amount;
    }
}
