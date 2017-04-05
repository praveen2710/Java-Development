package com.bebetteratjava.threadsandconcurrency;

/**
 * Created by pb033954 on 3/30/2017.
 */
public class TxWorker implements Runnable {

    protected BankAccount account;
    protected  char txType;// 'w' -> withdrawal, 'd'->deposit
    protected  int amt;

    public TxWorker(BankAccount account, char txType,int amt) {
        this.account = account;
        this.txType = txType;
        this.amt = amt;
    }

    @Override
    public void run() {
        if(txType == 'w')
            account.withdraw(amt);
        else if(txType == 'd')
            account.deposit(amt);
    }
}
