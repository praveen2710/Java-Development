package com.bebetteratjava.threadsandconcurrency;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Callable;

/**
 * Similar to {@code {@link Adder}} but this one will return a result to main thread.
 * This uses {@code {@link Callable}} instead of {@code {@link Runnable}}
 * Created by pb033954 on 3/30/2017.
 */
public class AdderResult implements Callable<Integer> {
    private String inFile;

    public AdderResult(String inFile){
        this.inFile = inFile;
    }

    public int doAdd() throws IOException {
        int total=0;
        String line = null;
        try(BufferedReader reader = Files.newBufferedReader(Paths.get(inFile))){
            while ((line =reader.readLine())!=null){
                total+= Integer.parseInt(line);
            }
        }
        return total;
    }

    @Override
    public Integer call() throws Exception {
        return doAdd();
    }
}
