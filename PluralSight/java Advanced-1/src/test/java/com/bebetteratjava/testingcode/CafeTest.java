package com.bebetteratjava.testingcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by pb033954 on 4/26/2017.
 */
public class CafeTest {

    @Test
    public void canBrewEspresso(){
        Cafe cafe = new Cafe();
        cafe.restockBeans(7);
        cafe.restockMilk(100);
        Coffee coffee = cafe.brew(CoffeeType.Espresso);

        Assert.assertEquals(CoffeeType.Espresso,coffee.getType());
        Assert.assertEquals(0,coffee.getMilk());
        Assert.assertEquals(7,coffee.getBeans());
    }
}