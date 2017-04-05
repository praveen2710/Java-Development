package com.bebetteratjava.conditional;

/**
 * Created by pb033954 on 3/21/2017.
 */

import javax.swing.*;

/***
 * This class will do basic math operations.
 * it will show using conditional operators.
 */
public class CalcEngine {
    public static void main (String args[]){

        original();
        originalPlus();
    }

    /**
     * Does same thing as {@code original} but for more than one
     * values using for loop and switch
     */
    private static void originalPlus() {
        double [] leftVals = {100.0d,25.0d,225.0d,11.0d};
        double [] rightVals = {50.0d,92.0d,0.0d,3.0d};
        char   [] opCodes   = {'m','a','d','s'};
        double [] results = new double[opCodes.length];

        for (int i=0;i<opCodes.length;i++) {
            switch (opCodes[i]) {
                case 'a':
                    results[i] = leftVals[i] + rightVals[i];
                    break;
                case 's':
                    results[i] = leftVals[i] - rightVals[i];
                    break;
                case 'd':
                    //double will not give an exception but value infinity.
                    results[i] = rightVals[i] != 0.0d ? leftVals[i] / rightVals[i] : 0.0d;
//            if(val2 != 0.0d)
//                result = val1/val2;
//            else
//                result = 0.0d;
                    break;
                case 'm':
                    results[i] = leftVals[i] * rightVals[i];
                    break;
                default:
                    System.out.println("Error- invlaid opCode");
                    results[i] = 0.0d;
                    break;
            }
        }

        for(double theResult : results){
            System.out.print("Result = ");
            System.out.println(theResult);
        }
    }

    private static void original() {
        char opCode;
        double val1 = 100.0d;
        double val2 = 50.0d;
        double result;

        opCode = 'd';
        if(opCode == 'a')
            result = val1 + val2;
        else if(opCode == 's')
            result = val1 - val2;
        else if(opCode == 'd')
            //double will not give an exception but value infinity.
            result = val2 != 0.0d?val1/val2:0.0d;
//            if(val2 != 0.0d)
//                result = val1/val2;
//            else
//                result = 0.0d;
        else if(opCode == 'm')
            result = val1 * val2;
        else {
            System.out.println("Error- invlaid opCode");
            result = 0.0d;
        }
        System.out.println(result);
    }
}
