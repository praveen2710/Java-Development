package com.bebetteratjava.inheritance.travelAir;

import com.bebetteratjava.classes.Flight;

/**
 * Created by pb033954 on 3/24/2017.
 */
public class FullLicensePilot extends Pilot {
    @Override
    public boolean canAccept(Flight f) {
        return true;
    }
}
