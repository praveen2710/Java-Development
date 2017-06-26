package com.bebetteratjava.javaadvanced.mediatordp;

import com.bebetteratjava.javaadvanced.commanddp.Light;

import java.util.ArrayList;
import java.util.List;

/**
 * This usually implements an interface but since I
 * don't have multiple mediators I skipped on it.
 * Created by PB033954 on 6/24/2017.
 */
public class Mediator {

    private List<Light> lights= new ArrayList<>();

    public void registerList(Light light){
        lights.add(light);
    }

    public void turnOnAllLights(){
        for(Light light:lights){
            if(!light.isOn()){
                light.toggle();
            }
        }
    }

    public void turnOffAllLights(){
        for(Light light:lights){
            if(light.isOn()){
                light.toggle();
            }
        }
    }

}
