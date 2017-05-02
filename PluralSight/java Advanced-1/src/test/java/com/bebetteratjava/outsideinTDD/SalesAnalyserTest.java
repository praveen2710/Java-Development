package com.bebetteratjava.outsideinTDD;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by PB033954 on 5/1/2017.
 */
public class SalesAnalyserTest {
    private static final List<Sale> exampleSales = Arrays.asList(
            new Sale("Cardiff",10,2),
            new Sale("Cardiff",3,5),
            new Sale("Cardiff",6,20),
            new Sale("London",5,7)
    );

    private static final Map<String,Integer> expectedStoreSales = new HashMap<>();
    static {
        expectedStoreSales.put("Cardiff",155);
        expectedStoreSales.put("London",35);
    }

    @Test
    public void shouldAggregateStoreSales(){
        //given
        SalesRepository mockRepository = mock(SalesRepository.class);
        when(mockRepository.loadSales()).thenReturn(exampleSales);

        SalesAnalyser analyser = new SalesAnalyser(mockRepository);
        //when
        Map<String,Integer> storeSales = analyser.tallyCitySales();

        //then
        assertEquals("Calculated Wrong store sales",expectedStoreSales,storeSales);
        verify(mockRepository,times(1)).loadSales();
    }
}