package com.bebetteratjava.outsideinTDD;

import java.io.PrintStream;

/**
 * Created by PB033954 on 5/1/2017.
 */
public class SalesReportRunner {

    private final PrintStream out;

    public SalesReportRunner(final PrintStream out) {
        this.out = out ;
    }

    public static void main(String args[]){
        String fileLocation = args[0];
        new SalesReportRunner(System.out).run(fileLocation);
    }

    public void run(final String fileLocation) {
        out.println("Hello World");
    }

}
