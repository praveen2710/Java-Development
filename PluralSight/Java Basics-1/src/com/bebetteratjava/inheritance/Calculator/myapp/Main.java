package com.bebetteratjava.inheritance.Calculator.myapp;

import com.bebetteratjava.inheritance.Calculator.calEngine.Adder;
import com.bebetteratjava.inheritance.Calculator.calEngine.CalculateBase;
import com.bebetteratjava.inheritance.Calculator.calEngine.CalculateHelper;
import com.bebetteratjava.inheritance.Calculator.calEngine.Divider;
import com.bebetteratjava.inheritance.Calculator.calEngine.Multiplier;
import com.bebetteratjava.inheritance.Calculator.calEngine.StatementEvaluationException;
import com.bebetteratjava.inheritance.Calculator.calEngine.Subtractor;

/**
 * Created by pb033954 on 3/24/2017.
 */
public class Main {
    public static void main (String args[]){
//        useCalculateBase();
//        calculateUsingStatements();
        accessingEnum();

    }

    /**
     * This shows how we should use package-private access specifier to prevent
     * unintended use of classes outside package.
     */
    private static void accessingEnum() {
        String enumValue ="Cant Access enum";
//        enumValue= com.bebetteratjava.inheritance.Calculator.MathCommand.Divide.toString();
        System.out.println(enumValue);
    }

    private static void calculateUsingStatements() {
        String[] statements = {
                "divide 100.0 50.0",
                "add 25.0 92.0 ",
                "add 16.0",
                "add xx 25.0 ",
                "addX 25.0 92.0 ",
                "Subtract 225.0 17.0",
                "muLTiply 11.0 3.0"};

        CalculateHelper helper = new CalculateHelper();
        for(String statement:statements){
            try{
            helper.process(statement);
            System.out.println(helper);
            }catch (StatementEvaluationException se){
                System.out.println(se.getMessage());
                //this prints any additional exceptions with current exception
                if(se.getCause()!= null)
                    System.out.println("  Original Exception:"+se.getCause().getMessage());
            }
        }
    }

    private static void useCalculateBase() {

        CalculateBase[] calculateBases = {new Adder(12.0d,13.0d),
                new Multiplier(15.0d,12.0d),
                new Divider(455.0d,14.0d),
                new Subtractor(432.0d,21.0d) };

        for(CalculateBase cal:calculateBases){
            cal.calculate();
            System.out.println("Result ="+cal.getResult());
        }
    }
}
