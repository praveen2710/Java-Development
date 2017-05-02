package com.bebetteratjava.outsideinTDD;

import org.junit.Test;

import java.util.List;


import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.*;

/**
 * Created by PB033954 on 5/1/2017.
 */
public class SalesRepositoryTest {
    @Test
    public void shouldLoadSampleData(){
        SalesRepository repository = new SalesRepository("src/main/resources/example-sales.csv");

        List<Sale> sale = repository.loadSales();

        //London 2,30
        assertThat(sale,hasItem(allOf(
                hasProperty("store",equalTo("London")),
                hasProperty("qty",equalTo(2)),
                hasProperty("price",equalTo(30))
        )));
     }
}