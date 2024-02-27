import org.junit.Assert; // make sure to use junit 4!!!
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import static org.junit.Assert.*;

public class Examples {

    // It's better form to have 1 assert per test, but here are a few
    @Test
    public void testTotalKittens() {
        int[] ex1 = { 0, 0, 0, 0 };
        assertEquals("should return 0", 0, Rescue.totalKittens(ex1));
        int[] ex2 = { 0, -10, 1, 0 };
        assertEquals("should return 1", 1, Rescue.totalKittens(ex2));
        int[] ex3 = { 1, 2, 3, 4 };
        assertEquals("should return 10", 10, Rescue.totalKittens(ex3));
        int[] ex4 = {};
        assertEquals("should return 0", 0, Rescue.totalKittens(ex4));
    }

    @Test
    public void testAveragePuppyAge() {
        double[] ex1 = { 0d, 0d, 0d, 0d };
        assertEquals(0, Rescue.averagePuppyAge(ex1), 0.0d);
        double[] ex2 = { 1.0, 1.5d, 1.5d, 1d };
        assertEquals(1.25d, Rescue.averagePuppyAge(ex2), 0.0d);
        double[] ex3 = { 5d, 10d };
        assertEquals(7.5d, Rescue.averagePuppyAge(ex3), 0.0d);
        double[] ex4 = {};
        assertEquals(0, Rescue.averagePuppyAge(ex4), 0.0d);
    }

    @Test
    public void testHonorablyTitled() {
        assertTrue(Rescue.honorablyTitled("Dr. Dog, PhD"));
        assertTrue(Rescue.honorablyTitled("Pres. Dog, PhD"));

        assertTrue(Rescue.honorablyTitled("Duke dog, MD"));

        assertFalse(Rescue.honorablyTitled("Dr. Duke Dog"));
        assertFalse(Rescue.honorablyTitled("Duke dog"));
        assertFalse(Rescue.honorablyTitled("Dr. Dog"));
        assertFalse(Rescue.honorablyTitled("Dog, PhD"));

    }

    @Test
    public void testChinchillaFeed() {
        assertEquals("Chinchilla: 0 lbs. of pellets | 0 oz. of hay | 0 units of dried fruit",
                Rescue.chinchillaFeed(0, 0, 0));
        assertEquals("Chinchilla: 4 lbs. of pellets | 13 oz. of hay | 22 units of dried fruit",
                Rescue.chinchillaFeed(4, 13, 22));
        assertEquals("Chinchilla: unknown lbs. of pellets | unknown oz. of hay | unknown units of dried fruit",
                Rescue.chinchillaFeed(-1, -1, -1));
    }

    @Test
    public void testHeardingCats() {
        LinkedList<Coord> ex1 = new LinkedList<>();
        ex1.add(new Coord(1, 1));
        ex1.add(new Coord(0, 0));
        ex1.add(new Coord(-1, -2));

        assertEquals(ex1.get(1), Rescue.heardingCats(ex1, new Coord(0, 0)));
        assertEquals(ex1.get(2), Rescue.heardingCats(ex1, new Coord(-2, -2)));

        assertNull(Rescue.heardingCats(new LinkedList<>(), new Coord(-2, -2)));

    }

    @Test
    public void testGoatBloat() {
        ArrayList<Double> current1 = new ArrayList<>();
        current1.add(45.0d);
        current1.add(75.5d);
        current1.add(100d);

        ArrayList<Double> target1 = new ArrayList<>();
        target1.add(50.0);
        target1.add(75d);
        target1.add(105d);

        assertEquals("should return 2", 2, Rescue.goatBloat(current1, target1, 1));
        assertEquals("should return 0", 0, Rescue.goatBloat(current1, target1, 5));

        ArrayList<Double> target2 = new ArrayList<>();
        target2.add(51.0);
        target2.add(75d);
        assertEquals("should return 1", 1, Rescue.goatBloat(current1, target2, 5));

        ArrayList<Double> current2 = new ArrayList<>();
        current2.add(45.0d);
        current2.add(75.5d);
        assertEquals("should return 0", 0, Rescue.goatBloat(current2, target1, 5));

        assertEquals("should return 0", 0, Rescue.goatBloat(current2, new ArrayList<Double>(), 5));
        assertEquals("should return 0", 0, Rescue.goatBloat(new ArrayList<Double>(), target2, 5));
        assertEquals("should return 0", 0, Rescue.goatBloat(new ArrayList<Double>(), new ArrayList(), 5));

        ArrayList<Double> current3 = new ArrayList<>();
        current3.add(0d);
        current3.add(5d);

        ArrayList<Double> target3 = new ArrayList<>();
        target3.add(5d);
        target3.add(0d);

        assertEquals("should return 1", 1, Rescue.goatBloat(current3, target2, 5));
        assertEquals("should return 1", 1, Rescue.goatBloat(current2, target3, 5));

    }

    public void test() {
        org.junit.runner.JUnitCore.main("Examples");
    }

}
