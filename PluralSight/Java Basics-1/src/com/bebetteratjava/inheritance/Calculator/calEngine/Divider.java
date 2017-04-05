package com.bebetteratjava.inheritance.Calculator.calEngine;

/**
 * This is an enhanced version of {@code {@link com.bebetteratjava.classes.MathEquation}}
 * Created by pb033954 on 3/24/2017.
 */
public class Divider extends CalculateBase {

    public Divider(){}

    public Divider(double leftVal,double rightVal){
        super(leftVal,rightVal);
    }

    @Override
    public void calculate() {
        double value = getRightVal()!= 0.0d ? getLeftVal() /getRightVal(): 0.0d;
        setResult(value);
    }
}
