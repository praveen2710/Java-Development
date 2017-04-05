package com.bebetteratjava.reflections;

import com.bebetteratjava.customannotations.WorkHandler;

/**
 * Created by pb033954 on 4/1/2017.
 */
@WorkHandler(useThreadPool = false)
public class AccountWorkerV2 implements Runnable,TaskWorker{
    BankAccount ba;

    private char txType;
    private int amt;

    @Override
    public void setTarget(Object target) {
        if(BankAccount.class.isInstance(target))
            ba = (BankAccount) target;
        else
            throw new IllegalArgumentException("Not a BankAccount compatible Object");
    }

    @WorkHandler(useThreadPool = false)
    public void doWork(){
        //we can also use instanceOf(Runner) to make is more usable by other classes
//       @WorkHandler(useThreadPool = false) [this wont work due to target annotation]
        Thread t = new Thread(HighVolumeAccount.class.isInstance(ba)?(HighVolumeAccount)ba:this);
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
