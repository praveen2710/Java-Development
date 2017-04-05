package com.bebetteratjava.inheritance.travelAir;

import com.bebetteratjava.classes.Flight;

/**
 * Created by pb033954 on 3/24/2017.
 */
public abstract class Pilot {
    private Flight currentFlight;

    public void fly(Flight f){
        if(canAccept(f))
            currentFlight = f;
        else
            handleCannotAccept();
    }

    public abstract boolean canAccept(Flight f);

    private void handleCannotAccept() {
        System.out.println("Cannot fly this flight");
    }
}
