package com.bebetteratjava.TDDSimpleExamples;

/**
 * Created by PB033954 on 5/1/2017.
 */
public class LeapYear {

    public static boolean isLeapYear(int year) {
        return isDivisible(year,4) && (!(isDivisible(year,100))|| isDivisible(year,400));
    }

    private static boolean isDivisible(final int year,final int denominator) {
        return year%denominator == 0;
    }


}
