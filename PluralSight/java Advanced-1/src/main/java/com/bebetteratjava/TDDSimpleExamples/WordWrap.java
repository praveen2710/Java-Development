package com.bebetteratjava.TDDSimpleExamples;

import static java.lang.Math.min;

/**
 * Created by PB033954 on 5/1/2017.
 */
public class WordWrap {

    public static String wrap(final String inputLine,final int lineLength) {
        final StringBuilder accumulator = new StringBuilder();
        final int length = inputLine.length();
        accumulator.append(inputLine,0,min(length,lineLength));

        int split = lineLength;

        while (length > split){
            accumulator.append("\n");
            accumulator.append(inputLine, split, min(split+lineLength,length));
            split += lineLength;
        }

        return accumulator.toString();
    }
}
