package com.bebetteratjava.javaadvanced.mediatordp;

import com.bebetteratjava.javaadvanced.commanddp.Command;
import com.bebetteratjava.javaadvanced.commanddp.Light;
import com.bebetteratjava.javaadvanced.commanddp.TurnOffAllLightsCommand;
import com.bebetteratjava.javaadvanced.commanddp.TurnOnAllLightsCommand;

/**
 * Created by PB033954 on 6/24/2017.
 */
public class MediatorDemoMain {

    public static void main(String[] args){
        Mediator mediator = new Mediator();

        Light bedroomLight = new Light();
        Light kitchenLight = new Light();

        mediator.registerList(bedroomLight);
        mediator.registerList(kitchenLight);

        Command turnOnAllLightsCommand = new TurnOnAllLightsCommand(mediator);

        turnOnAllLightsCommand.execute();

        Command turnOffAllLightsCommand = new TurnOffAllLightsCommand(mediator);

        turnOffAllLightsCommand.execute();
    }
}
