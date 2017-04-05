package com.bebetteratjava.inheritance.Calculator.calEngine;

import com.bebetteratjava.interfaces.Calculator.interfaces.MathProcessing;

/**
 * Created by pb033954 on 3/24/2017.
 */
public class Adder extends CalculateBase implements MathProcessing {

    public Adder(){}

    public Adder(double leftVal,double rightVal){
        super(leftVal,rightVal);
    }

    @Override
    public void calculate() {
        double value = getLeftVal()+getRightVal();
        setResult(value);
    }

    @Override
    public String getKeyword() {
        return "add";
    }

    @Override
    public char getSymbol() {
        return '+';
    }

    @Override
    public double doCalculation(double leftVal, double rightVal) {
        setLeftVal(leftVal);
        setRightVal(rightVal);
        calculate();

        return getResult();
    }
}
