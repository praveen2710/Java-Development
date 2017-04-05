package com.bebetteratjava.interfaces.Calculator.interfaces;

/**
 * Created by PB033954 on 3/25/2017.
 */
public interface MathProcessing {
    String SEPARATOR = " ";
    String getKeyword();
    char getSymbol();
    double doCalculation(double leftVal,double rightVal);
}
