package com.bebetteratjava.newfiletypes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by PB033954 on 3/26/2017.
 */
public class Main {

    public static void main(String args[]){
//        oldFileTypeReader();
//        String[] data = {"Line 1","Line 1 2","Line 1 2 3", "Line 1 2 3 4","Line 1 2 3 4 5"};
//        oldFileTypeWriterLines(data);
//        oldFileTypeReaderLines();
        try {
            newFileTypeReadLines();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void oldFileTypeReaderLines() {
        System.out.println("Read Line");
        try(BufferedReader br = new BufferedReader(new FileReader("fileWithLines.txt"))){
            String inValue;
            while ((inValue=br.readLine())!= null){
                System.out.println(inValue);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void oldFileTypeWriterLines(String[] data) {

        try(BufferedWriter br = new BufferedWriter(new FileWriter("fileWithLines.txt"))){
            for(String str:data){
                br.write(str);
                br.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void oldFileTypeReader(){
        System.out.println("Read Character");
        try(BufferedReader br = new BufferedReader(new FileReader("file1.txt"))){
            int intVal;
            while((intVal = br.read())>0){
                char charVal = (char) intVal;
                System.out.println(charVal);
            }
        }catch (IOException ie){
            System.out.println(ie.getMessage());
        }
    }

    private static void newFileTypeReadLines() throws IOException {
        System.out.println("New File Reader");
       List<String> lines = Files.readAllLines(Paths.get("fileWithLines.txt"));
       for(String eachLine:lines){
           System.out.println(eachLine);
       }
    }
}
