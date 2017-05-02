package com.bebetteratjava.outsideinTDD;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by PB033954 on 5/1/2017.
 */
public class SalesReportTest {

    private static final String CITY = "London";
    private static final int TALLY = 235;

    private PrintStream mockOut = mock(PrintStream.class);
    private SalesAnalyser mockAnalyser = mock(SalesAnalyser.class);
    private SalesReport report = new SalesReport(mockAnalyser,mockOut);

    @Test
    public void shouldPrintCityTallies(){
        //TODO ???
       Map<String,Integer> cityTallies = new HashMap<>();
        cityTallies.put(CITY,TALLY);
        when(mockAnalyser.tallyCitySales()).thenReturn(cityTallies);

        report.run();
        verify(mockOut).printf(anyString(),eq(CITY),eq(TALLY));
    }

}