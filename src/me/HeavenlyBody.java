package me;

import java.util.HashSet;
import java.util.Set;

//step 1 class
//step 2 make final class
public final class HeavenlyBody {

    //step 3 fields or variables
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    //step 4 constructor for name and orbital period
    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        //step 5 initialize Set<HeavenlyBody> satellites; manually
        this.satellites = new HashSet<HeavenlyBody>();
    }

    //step 6 getters for all
    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Set<HeavenlyBody> getSatellites() {
        //return satellites;
        //step 7 put this in manually.....
        return new HashSet<HeavenlyBody>(this.satellites);
    }

    //step 8 method to add moon
    public boolean addMoon(HeavenlyBody moon) {
        return this.satellites.add(moon);

        //step 9 to main

    }

}
