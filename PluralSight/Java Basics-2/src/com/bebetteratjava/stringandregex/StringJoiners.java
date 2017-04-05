package com.bebetteratjava.stringandregex;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.List;
import java.util.StringJoiner;
/**
 * Created by PB033954 on 3/28/2017.
 */
public class StringJoiners {

    public static void main(String args[]){
//        stringJoinerExamples();
//        stringFormatConversions();
//        try {
//            formatterToFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        regexExampleFromStringClass();
        RegexExamples();
    }

    private static void RegexExamples() {
        String str  = "apple, apple and orange please";
        //TODO issue with finding Pattern class in java.util investigate
    }

    /**
     * SHows how to use basic regex in string class
     */
    private static void regexExampleFromStringClass() {
        String str  = "apple, apple and orange please";
        String newStr = str.replaceAll("ple","pricot");
        System.out.println(newStr);
        newStr = str.replaceAll("ple\\b","pricot");
        System.out.println(newStr);
        String[] parts = str.split("\\b");
        for(String eachPart:parts){
            if(eachPart.matches("\\w+"))
                System.out.println(eachPart);
        }
    }

    /**
     * THis method shows how to use {@code {@link StringJoiners}}
     */
    private static void stringJoinerExamples() {

         StringJoiner s1 = new StringJoiner(", ");
         s1.add("alpha");
         s1.add("theta");
         s1.add("gamma");
        System.out.println(s1);

        StringJoiner s2 = new StringJoiner(", ","{","}");
        s2.add("alpha");
        s2.add("theta");
        s2.add("gamma");
        System.out.println(s2);

        StringJoiner s3 = new StringJoiner("], [","[","]");
        s3.add("alpha");
        s3.add("theta");
        s3.add("gamma");
        //this calls the toString() method
        System.out.println(s3);

        //edge cases with only one value

        StringJoiner s4 = new StringJoiner(",");
        s4.add("alpha");
        System.out.println(s4);

        StringJoiner s5 = new StringJoiner(",","{","}");
        s5.add("alpha");
        System.out.println(s5);

        //edge case with no data

        StringJoiner s6 = new StringJoiner(",");
        System.out.println(s6);

        StringJoiner s7 = new StringJoiner(",","{","}");
        System.out.println(s7);

        //set a custom message when nothing added i.e add method is never called

        StringJoiner s8 = new StringJoiner(",");
        s8.setEmptyValue("EMPTY");
        System.out.println(s8);

        StringJoiner s9 = new StringJoiner(",","{","}");
        s9.setEmptyValue("EMPTY");
        System.out.println(s9);
    }

    /**
     * This method shows how to format string for better representation
     * using %[argument index][flags][width][precision]
     */
    private static void stringFormatConversions() {

        //FORMAT FLAGS

        //radix
        String s1 = String.format("%d",47);
        String s2 = String.format("%o",47);
        String s3 = String.format("%x",47);
        String s4 = String.format("%#o",47);
        String s5 = String.format("%#x",47);
        String s6 = String.format("%#X",47);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
        System.out.println(s6);

        s1 = String.format("W:%d X:%d",5,235);
        s2 = String.format("W:%d X:%d",481,12);
        System.out.println(s1);
        System.out.println(s2);
        // 1 .spacing
        s3 = String.format("W:%4d X:%4d",5,235);
        s4 = String.format("W:%4d X:%4d",481,12);
        System.out.println(s3);
        System.out.println(s4);
        // 2. add 0 instead of space
        s5 = String.format("W:%04d X:%04d",5,235);
        String s7 = String.format("W:%04d X:%04d",481,12);
        System.out.println(s5);
        System.out.println(s7);
        // 3. left justified
        s6 = String.format("W:%-4d X:%-4d",481,12);
        System.out.println(s6);
        // 4. grouping
        String s8 = String.format("%,d",4712131);
        System.out.println(s8);
        // 5. spaces
        String s9 = String.format("%d",123);
        System.out.println(s9);
        String s10 = String.format("%d",-456);
        System.out.println(s10);
        s9 = String.format("% d",123);
        System.out.println(s9);
        s10 = String.format("% d",-456);
        System.out.println(s10);
        s9 = String.format("%+d",123);
        System.out.println(s9);
        s10 = String.format("%+d",-456);
        System.out.println(s10);
        s9 = String.format("% (d",123);
        System.out.println(s9);
        s10 = String.format("%(d",-456);
        System.out.println(s10);

        //ARGUMENT INDEX
        //
        String sa = String.format("%d %d %d",100,200,-300);
        System.out.println(sa);
        //%[pos]$
        sa = String.format("%3$(d %1$+d %2$04d",100,200,-300);
        System.out.println(sa);
        // %< copy value of the previous one
        sa = String.format("%2$d %<04d %1$d",100,200,-300);
        System.out.println(sa);

    }

    private static void formatterToFile() throws IOException {
        BufferedWriter bw = Files.newBufferedWriter(Paths.get("formatterToFile.txt"));
        try(Formatter f = new Formatter(bw)){
            f.format("%2$d %<04d %1$d",100,200,-300);
            bw.newLine();
            f.format("%+d",-456);
            bw.newLine();
            f.format("W:%-4d X:%-4d",481,12);
            bw.newLine();
            f.format("W:%04d X:%04d",5,235);
        }
    }
}
