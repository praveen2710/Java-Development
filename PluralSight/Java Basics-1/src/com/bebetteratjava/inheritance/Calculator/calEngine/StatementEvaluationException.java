package com.bebetteratjava.inheritance.Calculator.calEngine;

/**
 * When creating custom exception we should have 2 constructor's at very least one that
 * takes parameters and one that also takes an previous exception
 * Created by PB033954 on 3/25/2017.
 */
public class StatementEvaluationException extends Exception {

    public StatementEvaluationException(String reason,String statement){
        super(reason+": "+statement);
    }

    public StatementEvaluationException(String reason,String statement,Throwable cause){
        super(reason+": "+statement,cause);
    }


}
