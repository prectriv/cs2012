import org.junit.Test;
import static org.junit.Assert.*;

public class Examples {
    @Test
    public void test_adoptale_totalYoungins() {
        CatastropheZone cz = new CatastropheZone();
        cz.registerAdoptable("Fluffy", 9.0d, 4000.0d, new Coord(0, 0));
        cz.registerAdoptable("Sprinkles", 24.0d, 5000.0d, new Coord(1, 1));

        assertEquals(1, cz.totalYoungins());
    }

    @Test
    public void test_catast_totalYounginsNoCats() {
        CatastropheZone cz = new CatastropheZone();
        assertEquals(0, cz.totalYoungins());
    }

    @Test
    public void test_cattast_averageAge() {
        CatastropheZone cz = new CatastropheZone();
        cz.registerAdoptable("Fluffy", 9.0d, 4000.0d, new Coord(0, 0));
        cz.registerAdoptable("Sprinkles", 24.0d, 5000.0d, new Coord(1, 1));
        assertEquals((24d + 9d) / 2, cz.averageAge(), 0.01);
    }

    @Test
    public void test_catast_catFeed() {
        CatastropheZone cz = new CatastropheZone();
        String s = cz.changeFeed("dry", 100);

        assertEquals("Cat: 100 lbs. of dry food | 0 cans of wet food", s);
    }

    @Test
    public void test_catast_catFeed2() {
        CatastropheZone cz = new CatastropheZone();
        String s = cz.changeFeed("wet", 100);

        assertEquals("Cat: 0 lbs. of dry food | 100 cans of wet food", s);
    }

    @Test
    public void test_catast_noCatFeed() {
        CatastropheZone cz = new CatastropheZone();
        String s = cz.changeFeed("wet", -10);

        assertEquals("Cat: 0 lbs. of dry food | unknown cans of wet food", s);
        String s2 = cz.changeFeed("dry", -10);

        assertEquals("Cat: unknown lbs. of dry food | unknown cans of wet food", s2);
    }

    /*
     * @Test
     * public void test_catast_closestTo(){
     * CatastropheZone cz = new CatastropheZone();
     * cz.registerAdoptable("Fluffy", 9.0d, 4000.0d, new Coord(-1,-1));
     * cz.registerAdoptable("Fluffy", 9.0d, 4000.0d, new Coord(0,0));
     * cz.registerAdoptable("Sprinkles", 24.0d, 5000.0d, new Coord(1,1));
     * 
     * CatastropheZone cz2 = new CatastropheZone();
     * 
     * 
     * assertEquals(cz.cats.get(1), cz.closestTo(new Coord(0,0)));
     * assertEquals(cz.cats.get(2), cz.closestTo(new Coord(-2,-2)));
     * assertNull(cz2.closestTo(new Coord(-2,-2)));
     * }
     */

    @Test
    public void test_cat_delta() {
        Cat test = new Cat("Fluffy", 9.0d, 4000.0d, new Coord(0, 0));
        assertEquals(0d, test.deltaWeight(), 0.0);

        Cat test2 = new Cat("Fluffy", 24d, 4000.0d, new Coord(0, 0));
        assertEquals(500d, test2.deltaWeight(), 0.0);

    }

    @Test
    public void test_cattast_weighIn() {
        CatastropheZone cz = new CatastropheZone();
        cz.registerAdoptable("Fluffy", 9.0d, 4000.0d, new Coord(0, 0));
        cz.registerAdoptable("Sprinkles", 24.0d, 5000.0d, new Coord(1, 1));

        assertEquals(1, cz.weighIn(1d).size());
        assertEquals(0, cz.weighIn(1000d).size());

        cz.registerAdoptable("Sprinkles", 25.0d, 5000.0d, new Coord(1, 1));
        assertEquals(0, cz.weighIn(1000d).size());

        cz.registerAdoptable("Sprinkles", 25.0d, 4700.0d, new Coord(1, 1));
        assertEquals(2, cz.weighIn(300d).size());
    }

    @Test
    public void test_cat_honorablyTitled() {
        assertFalse(new Cat("Dr. Duke Dog", 9d, 9d, new Coord(0, 0)).honorablyTitled());
        assertFalse(new Cat("Duke Dog", 9d, 9d, new Coord(0, 0)).honorablyTitled());
        assertFalse(new Cat("Dr. Dog", 9d, 9d, new Coord(0, 0)).honorablyTitled());
        assertFalse(new Cat("Dog, PhD", 9d, 9d, new Coord(0, 0)).honorablyTitled());

    }

    @Test
    public void test_chinchilla_delta() {
        TheHutchZone hz = new TheHutchZone();
        hz.registerAdoptable("Fluffy", 9.0d, 4000.0d, new Coord(0, 0));

        assertEquals(0d, hz.chinchillas.get(0).deltaWeight(), 0.0);

        hz.registerAdoptable("Fluffy", 24d, 4500.0d, new Coord(0, 0));
        assertEquals(250d, hz.chinchillas.get(1).deltaWeight(), 0.0);

    }

    @Test
    public void test_chinchilla_noFeed() {
        TheHutchZone hz = new TheHutchZone();
        String s = hz.changeFeed("fruit", -10);
        assertEquals("Chinchilla: 0 lbs. of pellets | 0 oz. of hay | unknown units of dried fruit", s);

        String s2 = hz.changeFeed("hay", -10);
        assertEquals("Chinchilla: 0 lbs. of pellets | unknown oz. of hay | unknown units of dried fruit", s2);

        String s3 = hz.changeFeed("pellets", -10);
        assertEquals("Chinchilla: unknown lbs. of pellets | unknown oz. of hay | unknown units of dried fruit", s3);
    }

    @Test
    public void test_goat_delta() {
        Goat g1 = new Goat("Fluffy", 9.0d, 45000d, new Coord(0, 0));
        assertEquals(10000d, g1.deltaWeight(), 0.0);

        Goat g2 = new Goat("Fluffy", 24d, 45000d, new Coord(0, 0));
        assertEquals(12000d, g2.deltaWeight(), 0.0);
    }

    @Test
    public void test_GoateryZone_changeFeed() {
        GoateryZone gz = new GoateryZone();
        String s = gz.changeFeed("anything", -10);
        assertEquals("Goat: unknown piles of edible substance", s);

        String s2 = gz.changeFeed("anything", 30);
        assertEquals("Goat: 20 piles of edible substance", s2);
    }

    public void test() {
        org.junit.runner.JUnitCore.main("Examples");
    }

}
