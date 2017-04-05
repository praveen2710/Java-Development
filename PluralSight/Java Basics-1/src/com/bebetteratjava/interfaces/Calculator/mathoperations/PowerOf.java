package com.bebetteratjava.interfaces.Calculator.mathoperations;

import com.bebetteratjava.interfaces.Calculator.interfaces.MathProcessing;

/**
 * Created by PB033954 on 3/25/2017.
 */
public class PowerOf implements MathProcessing {
    @Override
    public String getKeyword() {
        return "power";
    }

    @Override
    public char getSymbol() {
        return '^';
    }

    @Override
    public double doCalculation(double leftVal, double rightVal) {
        return Math.pow(leftVal,rightVal);
    }
}
