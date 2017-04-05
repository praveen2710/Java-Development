package com.bebetteratjava.customannotations;

import com.bebetteratjava.reflections.BankAccount;
import com.bebetteratjava.reflections.TaskWorker;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by pb033954 on 4/1/2017.
 */
public class Main {
    public static void main(String args[]){
        createClassInstanceAnnotations();
        createClassUsingClassAnnotations();
    }

    private static void createClassUsingClassAnnotations() {
        BankAccount acct1 = new BankAccount("12451");
        startWorkSelfContained(acct1);
        System.out.println(acct1.getId());
    }

    private static void startWorkSelfContained(Object workerTarget) {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        try {
            Class<?> targetType = workerTarget.getClass();
            ProcessedBy pb = targetType.getAnnotation(ProcessedBy.class);
            Class<?> workerType = pb.value();
            TaskWorker worker= (TaskWorker) workerType.newInstance();
            worker.setTarget(workerTarget);
            WorkHandler wh =workerType.getAnnotation(WorkHandler.class);
            //this fails because retention of annotation is not set
            if(wh == null)
                throw new NullPointerException("WorkerHandler annotation not set");

            if(wh.useThreadPool()){
                pool.submit(new Runnable() {
                    @Override
                    public void run() {
                        worker.doWork();
                    }
                });
            }else
                worker.doWork();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * This will show how to use reflection to create objects
     */
    private static void createClassInstanceAnnotations() {
        BankAccount acct1 = new BankAccount("12451");
        startWorkWithAnnotations("com.bebetteratjava.reflections.AccountWorkerV2",acct1);
        System.out.println(acct1.getId());
    }

    private static void startWorkWithAnnotations(String workerTypeName, Object workerTarget) {
        try {
            ExecutorService pool = Executors.newFixedThreadPool(5);
            Class<?>  workerType = Class.forName(workerTypeName);
            TaskWorker worker = (TaskWorker)workerType.newInstance();
            worker.setTarget(workerTarget);
            WorkHandler wh =workerType.getAnnotation(WorkHandler.class);
            //this fails because retention of annotation is not set
            if(wh == null)
                throw new NullPointerException("WorkerHandler annotation not set");

            if(wh.useThreadPool()){
                pool.submit(new Runnable() {
                    @Override
                    public void run() {
                        worker.doWork();
                    }
                });
            }else
                worker.doWork();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
