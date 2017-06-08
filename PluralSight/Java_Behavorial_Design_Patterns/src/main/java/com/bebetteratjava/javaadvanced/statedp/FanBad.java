package com.bebetteratjava.javaadvanced.statedp;

/**
 * Created by PB033954 on 6/8/2017.
 */

public class FanBad {

    final static int OFF = 0;
    final static int LOW = 1;
    final static int MED = 2;

    int state = OFF;

    public void pullChain(){
        if(state == OFF){
            System.out.println("Turning fan to low");
            state = LOW;
        }else if(state == LOW){
            System.out.println("Turning fan to med");
            state = MED;
        }else if(state == MED){
            System.out.println("Turning fan to off");
            state = OFF;
        }
    }

    public String toString(){
        if(state == OFF){
            return "fan is off";
        }else if(state == LOW){
            return "fan is low";
        }else if(state == MED){
            return "fan is med";
        }
        return "fan in invalid state";
    }
}

