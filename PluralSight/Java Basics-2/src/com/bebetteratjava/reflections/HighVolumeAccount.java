package com.bebetteratjava.reflections;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pb033954 on 4/1/2017.
 */
public class HighVolumeAccount extends BankAccount implements Runnable {

    private String readDepositFile;
    private String readWithdrawFile;

    public HighVolumeAccount(String id, int balance) {super(id, balance);}

    public HighVolumeAccount(String id) {super(id);}

    private Integer[] readDailyDeposits(String depositFileName) throws IOException {
        return readFile(depositFileName);
    }

    private Integer[] readDailyWithDrawls(String withdrawalsFileName) throws IOException {
        return readFile(withdrawalsFileName);
    }

    private static Integer[] readFile(String fileName) throws IOException {
        List<Double> transactionsList = new ArrayList();
        String line = null;
        try(BufferedReader reader =Files.newBufferedReader(Paths.get(fileName))){
            while( (line =reader.readLine())!=null){
                transactionsList.add(Double.parseDouble(line));
            }
        }
        return transactionsList.toArray(new Integer[0]);
    }

    @Override
    public void run() {
        try {
            for (int depositAmt : readDailyDeposits(readDepositFile))
                deposit(depositAmt);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            for (int withdrawalAmt : readDailyWithDrawls(readWithdrawFile))
                withdraw(withdrawalAmt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getReadDepositFile() {return readDepositFile;}

    public void setReadDepositFile(String readDepositFile) {this.readDepositFile = readDepositFile;}

    public String getReadWithdrawFile() {return readWithdrawFile;}

    public void setReadWithdrawFile(String readWithdrawFile) {this.readWithdrawFile = readWithdrawFile;}
}
