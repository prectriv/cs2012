import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class myTests {

    @Test
    public void test_coord1() {
        Coord c1 = new Coord(0, 0);
        Coord c2 = new Coord(3, 4);
        assertEquals(5.0d, c1.distanceFrom(c2), 0.01d);
    }

}
