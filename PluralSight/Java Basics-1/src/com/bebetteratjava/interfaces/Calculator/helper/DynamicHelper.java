package com.bebetteratjava.interfaces.Calculator.helper;

import com.bebetteratjava.interfaces.Calculator.interfaces.MathProcessing;

/**
 * This is an enhanced version of {@code {@link com.bebetteratjava.inheritance.Calculator.calEngine.CalculateHelper}}
 * This will use interfaces to add commands dynamically
 *
 * Created by PB033954 on 3/25/2017.
 */
public class DynamicHelper {
    private MathProcessing[] handlers;

    public DynamicHelper(MathProcessing[] handlers){
        this.handlers = handlers;
    }

    public String process(String statement){
        //IN add 1.0 2.0
        //OUT 1.0 + 2.0 = 3.0

        String[] parts = statement.split(MathProcessing.SEPARATOR);
        String keyWord = parts[0];

        MathProcessing theHandler = null;

        for(MathProcessing handler: handlers){
            if(keyWord.equalsIgnoreCase(handler.getKeyword())){
                theHandler = handler;
                break;
            }
        }

        double leftVal = Double.parseDouble(parts[1]);
        double rightVal = Double.parseDouble(parts[2]);

        double result = theHandler.doCalculation(leftVal,rightVal);

        StringBuilder sb = new StringBuilder(20);
        sb.append(leftVal);
        sb.append(' ');
        sb.append(theHandler.getSymbol());
        sb.append(' ');
        sb.append(rightVal);
        sb.append('=');
        sb.append(result);
        return sb.toString();
    }
}
