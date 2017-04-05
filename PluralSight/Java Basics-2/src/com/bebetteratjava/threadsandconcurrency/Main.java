package com.bebetteratjava.threadsandconcurrency;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by pb033954 on 3/29/2017.
 */
public class Main {
    public static void main(String args[]){
//        noThreads();
//        basicsThreads();
//        threadPool();
//        threadResultHandling();
//        threadConcurrencyIssue();
//        synchronizedStatementBlockInsteadOfMethods();
//        synchronizedBlockOnSynchronizedMethods();
        synchronizedCollections();
    }

    private static void synchronizedCollections() {

    }

    /**
     * This will skip the parts that failed and still execute other flows as long as it can get through it
     */
    private static void basicsThreads() {
        String[] inFiles = {"TFile1.txt", "./TFile2.txt", "./TFile3.txt", "./TFile4.txt", "./TFile5.txt", "./TFile6.txt"};
        String[] outFiles = {"./TFile1.out.txt", "./TFile2.out.txt", "./TFile3.out.txt", "./TFile4.out.txt", "./TFile5.out.txt", "./TFile6.out.txt"};
        Thread[]  threads = new Thread[inFiles.length];
        for (int i = 0; i < threads.length; i++) {
            Adder adder = new Adder(inFiles[i], outFiles[i]);
            threads[i] = new Thread(adder);
            threads[i].start();
        }

        //this will ensure that main thread does not exit before all the background threads are done
        for(Thread thread:threads)
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

    private static void synchronizedBlockOnSynchronizedMethods() {
        ExecutorService es = Executors.newFixedThreadPool(5);
        BankAccount account = new BankAccount(450);
        TxWorker[] workers = new TxWorker[2];
        workers[0] = new TxPromoWorker(account,'d',150);
        workers[1] = new TxPromoWorker(account,'w',300);
        for(TxWorker worker:workers)
            es.submit(worker);


        try {
            es.shutdown();
            es.awaitTermination(60,TimeUnit.SECONDS);
            System.out.println(account.getBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void synchronizedStatementBlockInsteadOfMethods() {
        ExecutorService es = Executors.newFixedThreadPool(5);
        BankAccountNotSync account = new BankAccountNotSync(100);

        for (int i=0;i<5;i++) {
            WorkerSyncStmtBlock worker = new WorkerSyncStmtBlock(account);
            es.submit(worker);
        }
        try {
            es.shutdown();
            es.awaitTermination(60,TimeUnit.SECONDS);
            System.out.println(account.getBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    

    /**
     * This method will show how to use thready concurrently
     * when all thread are using same resources.
     *
     */
    private static void threadConcurrencyIssue() {
        ExecutorService es = Executors.newFixedThreadPool(5);
        BankAccount account = new BankAccount(100);

        for (int i=0;i<5;i++) {
            Worker worker = new Worker(account);
            es.submit(worker);
        }
        try {
            es.shutdown();
            es.awaitTermination(60,TimeUnit.SECONDS);
            System.out.println(account.getBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /***
     * showing how not using threads will exit the program on first exception that is triggered.
     */
    private static void noThreads() {
        String[] inFiles = {"TFile1.txt", "./TFile2.txt", "./TFile3.txt", "./TFile4.txt", "./TFile5.txt", "./TFile6.txt"};
        String[] outFiles = {"./TFile1.out.txt", "./TFile2.out.txt", "./TFile3.out.txt", "./TFile4.out.txt", "./TFile5.out.txt", "./TFile6.out.txt"};

        for (int i = 0; i < inFiles.length; i++) {
            try {
                Adder adder = new Adder(inFiles[i], outFiles[i]);
                adder.doAdd();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * This method uses Executor which can restrict no.of
     * of threads that can be run at one time to not overwhelm the system with too many threads.
     * This took care of thread joining and running.
     */
    private static void threadPool() {
        String[] inFiles = {"TFile1.txt", "./TFile2.txt", "./TFile3.txt", "./TFile4.txt", "./TFile5.txt", "./TFile6.txt"};
        String[] outFiles = {"./TFile1.out.txt", "./TFile2.out.txt", "./TFile3.out.txt", "./TFile4.out.txt", "./TFile5.out.txt", "./TFile6.out.txt"};
        ExecutorService es = Executors.newFixedThreadPool(3);
        for (int i = 0; i < inFiles.length; i++) {
            Adder adder = new Adder(inFiles[i], outFiles[i]);
            es.submit(adder);
        }

        try {
            //this will ensure nothing more is added to executor
            es.shutdown();
            //this will ensure main thread waits 60 seconds after all background threads to terminate
            es.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method will have main create background threads whose result will be passed to amin that will
     * determines flow of main thread.This is synchronized
     */
    private static void threadResultHandling() {
        String[] inFiles = {"TFile1.txt", "./TFile2.txt", "./TFile3.txt", "./TFile4.txt", "./TFile5.txt", "./TFile6.txt"};
        ExecutorService es = Executors.newFixedThreadPool(3);
        Future<Integer>[] results = new Future[inFiles.length];
        for (int i = 0; i < inFiles.length; i++) {
            AdderResult adder = new AdderResult(inFiles[i]);
            results[i] = es.submit(adder);
        }

        for(Future<Integer> result:results){
            try {
                int value = result.get();//blocks until return value available
                System.out.println("Total :" + value);
            }catch (ExecutionException e){//Exception raised in Adder
                System.out.println("Execution Exception");
                Throwable adderEx = e.getCause();//Get the adder exception
                System.out.println(adderEx.getMessage());
            }catch (InterruptedException ie){
                System.out.println("Interrupted Exception");
                System.out.println(ie.getMessage());
            }
        }
    }

    private static int doAdd() {
        return 0;
    }
}
