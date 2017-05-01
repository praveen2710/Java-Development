package com.bebetteratjava.outsideinTDD;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 * Created by PB033954 on 5/1/2017.
 */
public class ApplicationRunner {

    public String run(final String inputFile) {
        ByteArrayOutputStream dummyOutput = new ByteArrayOutputStream();
        SalesReportRunner app = new SalesReportRunner(new PrintStream(new PrintStream(dummyOutput)));
        app.run(inputFile);
        try {
            return dummyOutput.toString("UTF-8");
        } catch (UnsupportedEncodingException e) {
            new RuntimeException(e);
        }

        return null;
    }
}
