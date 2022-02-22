package assignment7;
/**REF:
 * https://howtodoinjava.com/java/enum/enum-tutorial/
 * https://www.baeldung.com/java-enum-values
 *
* */

public class TestPlanet{
    // universal gravitational constant  (m3 kg-1 s-2)
    public static final double G = 6.67300E-11;

    public static double surfaceGravity(Planet planet) {
        return G * (planet.mass() / (planet.radius() * planet.radius()));
    }
    public static double surfaceWeight(double otherMass, Planet planet) {
        return otherMass * surfaceGravity(planet);
    }

    public static void main(String[] args) {

        double earthWeight = 60;
        double mass = earthWeight/surfaceGravity(Planet.EARTH);
        for (Planet p : Planet.values())
            System.out.printf("Your weight on %s is %f%n",
                    p, surfaceWeight(mass,p));
    }
}