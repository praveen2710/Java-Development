package com.bebetteratjava.interfaces.Calculator;

import com.bebetteratjava.inheritance.Calculator.calEngine.Adder;
import com.bebetteratjava.interfaces.Calculator.helper.DynamicHelper;
import com.bebetteratjava.interfaces.Calculator.interfaces.MathProcessing;
import com.bebetteratjava.interfaces.Calculator.mathoperations.PowerOf;

/**
 * Created by PB033954 on 3/25/2017.
 */
public class Main {

    public static void main (String args[]){
        dynamicMathCalc();
    }

    private static void dynamicMathCalc() {
        String[] statements = {
                "add 25.0 92.0 ",
                "power 5.0 2.0"
        };

        DynamicHelper dh = new DynamicHelper(new MathProcessing[]{
                new Adder(),new PowerOf()
        });
        for(String statement:statements){
            String output = dh.process(statement);
            System.out.println(output);
        }
    }
}
