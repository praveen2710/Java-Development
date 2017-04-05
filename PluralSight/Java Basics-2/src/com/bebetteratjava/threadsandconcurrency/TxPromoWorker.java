package com.bebetteratjava.threadsandconcurrency;

import com.sun.xml.internal.txw2.TXW;

/**
 * This is a kind of {@code {@link TxWorker}} where we deposit 10% of
 * additional money for any amount that exceeds $500 when someone makes a deposit.
 * Created by pb033954 on 3/30/2017.
 */
public class TxPromoWorker extends TxWorker {

    public TxPromoWorker(BankAccount account, char txType, int amt) {
        super(account, txType, amt);
    }

    /**
     * This is example of how we need to use both
     * synchronized block and method for this to work properly.
     * example problem d|150 , w|300
     */
    @Override
    public void run() {
        if(txType == 'w')
            account.withdraw(amt);
        else if(txType == 'd'){
           //using synchronize statement block avoids issue in comments below
            synchronized ((account)) {
                //initial bal 450,d|150 , new bal 600
                account.deposit(amt);
                if (account.getBalance() > 500) {
                    //initial bal 600,w|300 , new bal 300
                    //initial bal 300,getBal :300,bonus : (300-500)*-.1 = -$20
                    int bonus = (int) ((account.getBalance() - 500) * 0.1);
                    //initial bal 300,d|-20,new bal:280
                    account.deposit(bonus);
                }
            }
        }
    }
}
