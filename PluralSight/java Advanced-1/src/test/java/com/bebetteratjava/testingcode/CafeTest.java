package com.bebetteratjava.testingcode;

import org.junit.Assert;
import org.junit.Test;

import static com.bebetteratjava.testingcode.CoffeeType.Espresso;
import static com.bebetteratjava.testingcode.CoffeeType.Latte;
import static org.junit.Assert.*;


/**
 * Created by pb033954 on 4/26/2017.
 */
public class CafeTest {

    public static final int ESPRESSO_BEANS  = Espresso.getRequiredBeans();
    public static final int NO_MILK = 0;
    public static final int NO_BEANS = 0;

    @Test
    public void canBrewEspresso(){
        //Given
        Cafe cafe = new Cafe();
        cafe.restockBeans(7);
        cafe.restockMilk(100);

        //When
        Coffee coffee = cafe.brew(Espresso);

        //Then
        Assert.assertEquals("Wrong coffee type",Espresso,coffee.getType());
        Assert.assertEquals("Wrong amount of milk",NO_MILK,coffee.getMilk());
        Assert.assertEquals("Wrong number of beans",7,coffee.getBeans());
    }

    @Test
    public void brewingEspressoConsumesBeans(){
        //Given
        Cafe cafe = new Cafe();
        cafe.restockBeans(7);
        cafe.restockMilk(100);

        //When
        Coffee coffee = cafe.brew(Espresso);

        //Then
        Assert.assertEquals(NO_BEANS,cafe.getBeansInStock());
    }


    @Test
    public void canBrewLatte(){
        Cafe cafe = new Cafe();
        cafe.restockBeans(Latte.getRequiredBeans());
        cafe.restockMilk(Latte.getRequiredMilk());

        Coffee coffee = cafe.brew(Latte);

        assertEquals("Wrong Coffe Type",Latte,coffee.getType());

    }

    //then
    @Test(expected = IllegalStateException.class)
    public void latteRequiresMilk(){
        //Given
        Cafe cafe = new Cafe();
        cafe.restockBeans(7);

        //when
        cafe.brew(CoffeeType.Latte);

    }
}