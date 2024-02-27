import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DesignTest {
    @Test
    public void test_getTemp() {
        double[][] temps = { { 98.6d, 100.0d, 99.0d },
                { 99.2d, 101.1d },
                { 102.5d, 96.6d, 93.0d, 99.9d } };
        Temps test1 = Design.getTemps(temps);
        assertEquals(0.0, 0, 0);
        assertEquals(test1.low, temps[2][2], 0.0d);
        assertEquals(test1.high, temps[2][0], 0.0d);

    }
}
