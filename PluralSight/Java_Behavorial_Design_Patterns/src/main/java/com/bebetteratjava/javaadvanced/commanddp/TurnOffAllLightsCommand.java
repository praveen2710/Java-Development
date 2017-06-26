package com.bebetteratjava.javaadvanced.commanddp;

import com.bebetteratjava.javaadvanced.mediatordp.Mediator;

/**
 * This is to demo usage of Mediator pattern
 * Created by PB033954 on 6/24/2017.
 */
public class TurnOffAllLightsCommand implements Command {
    private Mediator med;

    public TurnOffAllLightsCommand(Mediator med){
        this.med = med;
    }

    @Override
    public void execute() {
        med.turnOffAllLights();
    }
}
