package com.bebetteratjava.outsideinTDD;

import java.io.PrintStream;
import java.util.Map;

/**
 * Created by PB033954 on 5/1/2017.
 */
public class SalesReport {

    private final SalesAnalyser analyser;
    private  final PrintStream out;

    public SalesReport(SalesAnalyser analyser, PrintStream out) {
        this.analyser  = analyser;
        this.out = out;
    }

    public void run() {
        analyser.tallyCitySales().forEach((city,tally)->{
            out.printf("- %-15s - %6.6s -%n",city,tally);
        });
    }
}
