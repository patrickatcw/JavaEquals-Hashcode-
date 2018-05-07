package me;

import java.util.HashSet;
import java.util.Set;

//step 1 class
//step 2 make final class
@SuppressWarnings("ALL")
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

    //step 4 this program, override method
    @Override
    //public boolean equals(HeavenlyBody obj){   //done to get rid of error on override
    public boolean equals(Object obj) {
        if (this==obj) {    //first check to see if equal to itself
            return true;    //and if = to itsself it will return true, if object
        }                   //you are comparing is same object in memory

        System.out.println("obj.getClass() is " + obj.getClass());  //use to see when our equals method is called
        System.out.println("this.getClass() is " + this.getClass()); //as well as what it is doing
        if ((obj==null) || (obj.getClass())!=this.getClass()) { //test for null first,
            return false;
        }

        //another test
        String objName = ((HeavenlyBody) obj).getName();
        return this.name.equals(objName);

    }

    //step 5 this program, implement our hashcode, override hashcode
    @Override
    public int hashCode() {
        System.out.println("hashcode called"); //added this for our benifit to see called
        //return super.hashCode();, changed to.....
        return this.name.hashCode() + 57;  //number garantees we have a non-zero number for each of our hashes

        //step 6 this program to main to run

    }

}
