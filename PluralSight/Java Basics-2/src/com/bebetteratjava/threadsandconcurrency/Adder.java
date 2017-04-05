package com.bebetteratjava.threadsandconcurrency;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by pb033954 on 3/29/2017.
 */
public class Adder implements Runnable{
    private String inFile,outFile;

    public Adder(String inFile,String  outFile){
        this.inFile = inFile;
        this.outFile = outFile;
    }

    public void doAdd() throws IOException {
        int total=0;
        String line = null;
        try(BufferedReader reader = Files.newBufferedReader(Paths.get(inFile))){
            while ((line =reader.readLine())!=null){
                total+= Integer.parseInt(line);
            }
        }

        try(BufferedWriter writer = Files.newBufferedWriter(Paths.get(outFile))){
            writer.write("Total: "+ total);
        }
    }

    @Override
    public void run() {
        try {
            doAdd();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
