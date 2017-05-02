package com.bebetteratjava.outsideinTDD;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

/**
 * Created by PB033954 on 5/1/2017.
 */
public class SalesAnalyser {

    private final SalesRepository repo;

    public SalesAnalyser(SalesRepository repo) {
        this.repo = repo;
    }


    public Map<String,Integer> tallyCitySales() {
        return repo.loadSales()
                .stream()
                .collect(groupingBy(Sale::getStore,summingInt(Sale::getValue)));
    }
}
