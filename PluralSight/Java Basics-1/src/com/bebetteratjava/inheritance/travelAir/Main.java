package com.bebetteratjava.inheritance.travelAir;

import com.bebetteratjava.classes.Flight;
import com.bebetteratjava.classes.Passenger;
import com.bebetteratjava.inheritance.travelAir.CargoFlight;
import com.bebetteratjava.inheritance.travelAir.CrewMember;
import com.bebetteratjava.inheritance.travelAir.FlightCrewJob;
import com.bebetteratjava.inheritance.travelAir.Person;

/**
 * Created by pb033954 on 3/23/2017.
 */
public class Main {
    public static void main(String args[]){

//        CargoFlightDetals();
//        MyFlightDetails();
//          WrapperClassEquality();
//        FlightCrewMembersJob();
        ListPeopleInFlight();
//        SortFlightByArrival();
    }

    private static void SortFlightByArrival() {

    }

    private static void ListPeopleInFlight() {
        Flight lax45 = new Flight(45);
        CrewMember judy = new CrewMember("judy", FlightCrewJob.CoPilot);
        CrewMember bob = new CrewMember("bob",FlightCrewJob.Pilot);
        CrewMember james = new CrewMember("james",FlightCrewJob.FlightAttendant);
        CrewMember tina = new CrewMember("tina",FlightCrewJob.FlightAttendant);
        CrewMember adam = new CrewMember("adam",FlightCrewJob.AirMarshal);
        lax45.setCrew(judy,bob,james,tina,adam);

        Passenger jane=  new Passenger(0,2);
        jane.setPassengerName("jane");
        Passenger andy=  new Passenger(0,2);
        andy.setPassengerName("andy");
        Passenger sugar=  new Passenger(0,2);
        sugar.setPassengerName("sugar");
        Passenger jim=  new Passenger(0,2);
        jim.setPassengerName("jim");
        lax45.setRoster(jane,andy,sugar,jim);

        for(Person p:lax45){
            System.out.println(p.getName());
        }

    }

    /**
     * Example showing basic usage of enum
     */
    private static void FlightCrewMembersJob() {
        CrewMember judy = new CrewMember("judy",FlightCrewJob.CoPilot);
        judy.setJob(FlightCrewJob.Pilot);
    }


    private static void WrapperClassEquality() {
        Integer i1000A = 10*10*10;
        Integer i1000B = 100*10;

        if(i1000A == i1000B)
            System.out.println("i1000A ==i1000B");

        if (i1000A.equals(i1000B))
            System.out.println("i1000A equals i1000B");

        //In certain range equals point to same object instance range
        // int,short,long -128 to 127
        //char  00 to 00ff
        //boolean true,false
        Integer i8A = 4*2;
        Integer i8B = 2*2*2;


        if(i8A == i8B)
            System.out.println("i8A ==i8B");

        if (i8A.equals(i8B))
            System.out.println("i8A equals i8B");

    }

    /**
     * This is example of using string builder
     */
    private static void MyFlightDetails() {
        //for best performance give a buffer size
        StringBuilder sb = new StringBuilder(40);
        Flight myFlight = new Flight(186);
        System.out.println("My Flight is "+myFlight);
        String location = "Florida";

        sb.append("I flew to ");
        sb.append(location);
        sb.append(" on ");
        sb.append(myFlight);

        int time = 9;
        int pos = sb.length() - (" on ".length() + myFlight.toString().length());

        sb.insert(pos," at ");
        sb.insert(pos+4,time);

        System.out.println(sb.toString());
    }

    private static void CargoFlightDetals() {
        CargoFlight cf1 = new CargoFlight();
        cf1.add1Package(1.0f,2.0f,3.0f);

        Passenger jane=  new Passenger(0,2);
        cf1.add1Passenger(jane);
        System.out.println(cf1.getSeats());

        Flight f = new CargoFlight();
        System.out.println(f.getSeats());
        //f.add1Package

    }
}
