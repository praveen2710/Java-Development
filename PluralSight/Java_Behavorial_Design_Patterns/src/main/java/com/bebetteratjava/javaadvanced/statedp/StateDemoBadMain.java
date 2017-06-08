package com.bebetteratjava.javaadvanced.statedp;

/**
 * Created by PB033954 on 6/8/2017.
 */
public class StateDemoBadMain {

    public static void main(String args[]){
        FanBad fb = new FanBad();

        fb.pullChain();

        System.out.println(fb);

        fb.pullChain();

        System.out.println(fb);
    }
}
