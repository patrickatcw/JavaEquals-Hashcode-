package me;
//starting with code from JavaSetAndHashset
//set will ensure no duplicates in a collection, as opposed to a list
//https://www.javaworld.com/article/2074996/hashcode-and-equals-method-in-java-object---a-pragmatic-concept.html
//hashcode will check to see if objects are equal before storing
//there has to be a strict relationship between hashcode and equals
//**if 2 objects compare equal, than they must have the same hashcode
//how to override hashcode....
//https://www.mkyong.com/java/java-how-to-overrides-equals-and-hashcode/
//the rules of equals
//https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://docs.oracle.com/javase/8/docs/technotes/guides/vm/performance-enhancements-7.html
//set will ensure no duplicates in a collection, as opposed to a list
public class Main {

    //step 9 makes some variables
    private static Map<String, HeavenlyBody> solarSystem = new HashMap<String, HeavenlyBody>();
    private static Set<HeavenlyBody> planets = new HashSet<HeavenlyBody>();

    public static void main(String[] args) {

        //step 10 instances to create objects to add 3 planets
        HeavenlyBody temp = new HeavenlyBody("Mercury", 88);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Venus", 225);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Earth", 365);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        //step 11 instances to create objects to add moons
        HeavenlyBody tempMoon = new HeavenlyBody("Moon", 27);
        solarSystem.put(temp.getName(), tempMoon);
        temp.addMoon(tempMoon);

        //step 12 add more planets and moons
        temp = new HeavenlyBody("Mars", 687);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new HeavenlyBody("Deimos", 1.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Mars

        tempMoon = new HeavenlyBody("Phobos", 0.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Mars

        temp = new HeavenlyBody("Jupiter", 4332);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new HeavenlyBody("Io", 1.8);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new HeavenlyBody("Europa", 3.5);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new HeavenlyBody("Ganymede", 7.1);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new HeavenlyBody("Callisto", 16.7);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        temp = new HeavenlyBody("Saturn", 10759);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Uranus", 30660);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Neptune", 165);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Pluto", 248);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        //step 13 code for printing planets
        System.out.println("Planets");
        for(HeavenlyBody planet : planets) {
            System.out.println("\t" + planet.getName());//\t is indent
            //step 14 run to test...good shape
        }

        System.out.println("---------------------------------------------------");

        //step 15 code for printing moons for Jupiter
        HeavenlyBody body = solarSystem.get("Jupiter"); //grabbing planet jupiter
        System.out.println("Moons of " + body.getName());
        for (HeavenlyBody jupiterMoon : body.getSatellites()){
            System.out.println("\t" + jupiterMoon.getName());
            //step 16 run to test.....good shape
        }

        System.out.println("---------------------------------------------------");

        //step 17 code for printing moons for Mars
        HeavenlyBody body2 = solarSystem.get("Mars"); //grabbing planet Mars
        System.out.println("Moons of " + body2.getName());
        for (HeavenlyBody marsMoon : body2.getSatellites()){
            System.out.println("\t" + marsMoon.getName());
            //step 18 run to test.....good shape
        }

        System.out.println("---------------------------------------------------");

        //step 19 creating all moons object with a new instance
        Set<HeavenlyBody> moons = new HashSet<HeavenlyBody>();
        for(HeavenlyBody planet : planets){
            moons.addAll(planet.getSatellites());
        }
        //step 20 printout
        System.out.println("All Moons");
        for(HeavenlyBody moon : moons){
            System.out.println("\t" + moon.getName());
            //step 21 run to test.....heck yeah!
        }

        //what happens when you don't override
        //step 1 this program create a new pluto object
        //note the original pluto with 248 in original code
        HeavenlyBody pluto = new HeavenlyBody("Pluto", 842);
        planets.add(pluto);
        for(HeavenlyBody planet : planets){
            System.out.println(planet.getName() + ": " + planet.getOrbitalPeriod());
            //step 2 this program run.....Pluto is shown twice
            //we have 2 objects(not typical in sets) because the 2
            //pluto objects do not compare equal, this is why we need
            //to overwrite
        }

        //step 3 this program, but before we override here is base object code built into Java
        //press control & click on equals to see code to see what doing
        //shows how the plutos are equal which we do not want
        //and you can do the same with the string equals, the 2nd one
        //equals() for String compares the content, not the object itself
        Object o = new Object();
        o.equals(o);
        "pluto".equals("");

        //step 4 this program go to heavenlybody class

    }

}

