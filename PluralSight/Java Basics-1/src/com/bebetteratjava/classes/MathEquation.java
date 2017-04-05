package com.bebetteratjava.classes;

/**
 * This is a better version of {@code {@link com.bebetteratjava.conditional.CalcEngine}}
 * Created by pb033954 on 3/21/2017.
 */
public class MathEquation {

    private double leftVal;
    private double rightVal;
    private double result;
    //putting a value so that user does not error if he creates a new object without values
    private char opCode='a';

    public double getLeftVal() {return leftVal;}

    public void setLeftVal(double leftVal) {this.leftVal = leftVal;}

    public double getRightVal() {return rightVal;}

    public void setRightVal(double rightVal) {this.rightVal = rightVal;}

    public double getResult() {return result;}

    public char getOpCode() {return opCode;}

    public void setOpCode(char opCode) {this.opCode = opCode;}

    public MathEquation(){}
    public MathEquation(char opCode){
        this.opCode = opCode;
    }
    public MathEquation(char opCode,double leftVal ,double rightVal){
        this(opCode);
        this.leftVal = leftVal;
        this.rightVal = rightVal;
    }

    /**
     * This performs the mathematical operations.It also checks for divide by zero error.
     */
    public void execute(){
        switch (opCode) {
            case 'a':
                result = leftVal + rightVal;
                break;
            case 's':
                result = leftVal - rightVal;
                break;
            case 'd':
                //double will not give an exception but value infinity.
                result = rightVal != 0.0d ? leftVal / rightVal : 0.0d;
//            if(val2 != 0.0d)
//                result = val1/val2;
//            else
//                result = 0.0d;
                break;
            case 'm':
                result = leftVal * rightVal ;
                break;
            default:
                System.out.println("Error- invlaid opCode");
                result = 0.0d;
                break;
        }
    }

    /**
     * This takes the parameter left val and right val
     * @param leftVal
     * @param rightVal
     */
    public void execute(double leftVal,double rightVal){
        this.leftVal = leftVal;
        this.rightVal = rightVal;
        execute();
    }

    public void execute(int leftVal,int rightVal){
        this.leftVal = leftVal;
        this.rightVal = rightVal;
        execute();
        result = (int)result;
    }
}
