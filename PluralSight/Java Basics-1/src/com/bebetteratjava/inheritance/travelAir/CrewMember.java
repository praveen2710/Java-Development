package com.bebetteratjava.inheritance.travelAir;

/**
 * Created by pb033954 on 3/25/2017.
 */
public class CrewMember extends Person {
    private FlightCrewJob job;

    public  CrewMember(String name,FlightCrewJob job){
        super(name);
        this.job = job;
    }

    public void setJob(FlightCrewJob job){
        this.job = job;
    }

    public void setCrewMemeberName(String name){
        super.setName(name);
    }
}
