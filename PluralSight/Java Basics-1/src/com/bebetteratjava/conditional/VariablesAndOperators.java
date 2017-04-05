package com.bebetteratjava.conditional;

public class VariablesAndOperators {

    public static void main(String[] args) {
        System.out.println("Hello World Again");

        preAndPostDifference(5);
        compoundAssignment(100);
        operatorPrecedence(80);
        typeConversion();
    }

    private static void typeConversion() {
        float floatVal = 1.0f;
        double doubleVal  = 4.0d;
        byte byteVal = 7;
        short shortVal = 7;
        long longVal = 5;

        System.out.println("Type Conversions");
        short result1 = byteVal ;
        short result2 = (short)longVal ;
        //this by default takes the largest present which is longVal
        short result3 = (short) (byteVal - longVal);
        // result always will be floating point type
        long result4 = (long) (longVal - floatVal);
        float result5 = longVal - floatVal;
        //here the result would actually be double
        float result6  = (float) (longVal - doubleVal);
        double result7  = longVal - doubleVal;
        //here largest is double so effective result is double
        long result8  = (long) (shortVal - longVal + floatVal + doubleVal);
        System.out.println("Success");
    }

    /**
     * This subroutine shows how operator precede works.
     * The order is Postfix[ x++ x-- ]|Prefix[++x --x]|Multiplicative[* / %]|Additive[ + - ].
     * Parenthesis over rides all order.
     * @param data
     */
    private static void operatorPrecedence(int data) {
        //operators of equal precedence are evaluated left to right
        System.out.println("Effect of left to right precedence");
        int output1= data * 5 / 10;
        System.out.println(output1);
        int output2= data / 5 * 10;
        System.out.println(output2);

        int valA = 21;
        int valB = 6;
        int valC = 3;
        int valD = 1;

        int result1 = valA - valB / valC;

        int result2 = (valA - valB) / valC;
        System.out.println("Effect of parenthesis precedence");
        System.out.println(result1);
        System.out.println(result2);

        System.out.println("Effect of nested parenthesis precedence");
        // in nested parenthesis inner most is evaluated first
        int result3 = valA / valC * valD + valB;
        int result4 = valA / (valC * (valD + valB));
        System.out.println(result3);
        System.out.println(result4);
    }

    /**
     * This method shows how compound assignment operators work
     * @param result
     */
    private static void compoundAssignment(int result) {
        int val1 = 5;
        int val2 = 10;
        result /= val1 * val2;
        System.out.println(result);
    }

    /**
     * This method shows the difference on pre and post difference
     * @param val
     */
    public static void preAndPostDifference(int val){

        int myVal = val;
        System.out.println("Prefix example");
        System.out.println(++myVal);
        System.out.println(myVal);

        int myVal2 = val;
        System.out.println("Postfix example");
        System.out.println(myVal2++);
        System.out.println(myVal2);

    }
}
