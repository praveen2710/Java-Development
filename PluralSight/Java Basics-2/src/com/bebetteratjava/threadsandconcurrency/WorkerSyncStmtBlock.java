package com.bebetteratjava.threadsandconcurrency;

/**
 * Similar to {@code {@link Worker}} but here this take one
 * handles synchronization on a non synchronized class {@code {@link BankAccountNotSync}}
 * Created by pb033954 on 3/30/2017.
 */
public class WorkerSyncStmtBlock implements  Runnable{
    private BankAccountNotSync account;
    public WorkerSyncStmtBlock(BankAccountNotSync account){
        this.account = account;
    }

    @Override
    public void run() {
        for (int i=0;i<10;i++){
            //this allows to use non thread safe class in a safe way giving flexibility
            synchronized (account) {
                int startBalance = account.getBalance();
                account.deposit(10);
                int endBalance = account.getBalance();
                System.out.println("End Balance"+endBalance+" "+"Start Balance:"+startBalance);
            }

        }
    }
}
