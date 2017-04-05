package com.bebetteratjava.inheritance.Calculator.calEngine;

/**
 * Created by pb033954 on 3/25/2017.
 */
public class CalculateHelper {

    private static final char ADD_SYMBOL='+';
    private static final char SUBTRACT_SYMBOL='-';
    private static final char MULTIPLY_SYMBOL='*';
    private static final char DIVIDE_SYMBOL='/';

     MathCommand command;
     double leftVal;
     double rightVal;
     double result;

     public void process(String statement) throws StatementEvaluationException {
         //add 1.0 2.0
         String[] parts = statement.split(" ");
         if(parts.length != 3)
             throw new StatementEvaluationException("Incorrect number of fields",statement);

         String commandString = parts[0];//add
         try {
             leftVal = Double.parseDouble(parts[1]); //1.0
             rightVal = Double.parseDouble(parts[2]); //2.0
         }catch (NumberFormatException ne){
             throw new StatementEvaluationException("non-numeric data",statement,ne);
         }

         setCommandFromString(commandString);
         if(command == null){
             throw new StatementEvaluationException("Invalid command",statement);
         }

         CalculateBase calculator = null;
         switch (command){
             case Add:
                 calculator = new Adder(leftVal,rightVal);
                 break;
             case Subtract:
                 calculator = new Subtractor(leftVal,rightVal);
                 break;
             case Multiply:
                 calculator = new Multiplier(leftVal,rightVal);
                 break;
             case Divide:
                 calculator = new Divider(leftVal,rightVal);
                 break;
         }

         calculator.calculate();
         result = calculator.getResult();
     }

     private void setCommandFromString(String commandString){
         //resetting command for every statement
         command = null;
         if(commandString.equalsIgnoreCase(MathCommand.Add.toString()))
             command = MathCommand.Add;
         else if(commandString.equalsIgnoreCase(MathCommand.Subtract.toString()))
             command = MathCommand.Subtract;
         else if(commandString.equalsIgnoreCase(MathCommand.Multiply.toString()))
             command = MathCommand.Multiply;
         else if(commandString.equalsIgnoreCase(MathCommand.Divide.toString()))
             command = MathCommand.Divide;
     }

    @Override
    public String toString() {

        //1.0 + 2.0 = 3.0
        char symbol = ' ';
        switch (command){
            case Add:
                symbol = ADD_SYMBOL;
                break;
            case Subtract:
                symbol = SUBTRACT_SYMBOL;
                break;
            case Multiply:
                symbol = MULTIPLY_SYMBOL;
                break;
            case Divide:
                symbol = DIVIDE_SYMBOL;
                break;
        }

        StringBuilder sb = new StringBuilder(20);
        sb.append(leftVal);
        sb.append(' ');
        sb.append(symbol);
        sb.append(' ');
        sb.append(rightVal);
        sb.append('=');
        sb.append(result);
        return sb.toString();
    }
}
