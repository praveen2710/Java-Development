package com.bebetteratjava.reflections;

/**
 * Created by pb033954 on 4/1/2017.
 */

public class AccountWorker implements Runnable {

    BankAccount ba;
    HighVolumeAccount hva;

    private char txType;

    private int amt;

    public AccountWorker(BankAccount ba) {this.ba = ba;}

    public AccountWorker(HighVolumeAccount hva) {this.hva = hva;}

    public void doWork(){
        Thread t = new Thread(hva!=null?hva:this);
        t.start();
    }

    @Override
    public void run() {
        char txType = this.txType;
        int amt = this.amt;
        if(txType == 'w')
            ba.withdraw(amt);
        else if(txType =='d')
            ba.deposit(amt);
    }

    public char getTxType() {return txType;}

    public void setTxType(char txType) {this.txType = txType;}

    public int getAmt() {return amt;}

    public void setAmt(int amt) {this.amt = amt;}
}
