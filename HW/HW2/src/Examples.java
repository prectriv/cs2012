import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class Examples {

    @Test
    public void testSnowReading() {
        SnowReading s1 = new SnowReading();
        assertEquals("Err:Err", s1.toString());

        SnowReading s2 = new SnowReading();
        assertTrue(s1.equals(s2));

        SnowReading s3 = new SnowReading(1, 1);
        assertEquals("1C:1cm", s3.toString());
        assertFalse(s3.equals(s1));

        SnowReading s4 = new SnowReading(-19, -100);
        assertEquals("-19C:0cm", s4.toString());

    }

    @Test
    public void testSimpleIn() {
        SnowReading s1 = new SnowReading(5, 5);
        SnowReading s2 = new SnowReading(10, 10);
        SnowReading s3 = new SnowReading(15, 15);
        SnowReading s4 = new SnowReading(20, 20);
        SnowReading s5 = new SnowReading();
        LinkedList<SensorReading> l1 = new LinkedList<>();
        l1.add(s1);
        l1.add(s3);
        l1.add(s2);
        l1.add(s4);

        SnowStationSimpleIn station = new SnowStationSimpleIn();
        station.readSensorData(l1);

        assertEquals(l1, station.getCurrentSensorData());
        assertEquals(13, station.medianReading().cm, 0.01);
        assertEquals(13, station.medianReading().tempC, 0.01);

        LinkedList<SensorReading> l2 = new LinkedList<>();
        l2.add(s5);
        l1.add(s5);

        station.readSensorData(l2);
        assertEquals(l1, station.getCurrentSensorData());
        assertEquals(15, station.medianReading().cm, 0.01);
        assertEquals(15, station.medianReading().tempC, 0.01);

    }

    @Test
    public void testSimpleOut() {
        SnowReading s1 = new SnowReading(5, 5);
        SnowReading s2 = new SnowReading(10, 10);
        SnowReading s3 = new SnowReading(15, 15);
        SnowReading s4 = new SnowReading(20, 20);
        SnowReading s5 = new SnowReading();
        LinkedList<SensorReading> l1 = new LinkedList<>();
        l1.add(s1);
        l1.add(s2);
        l1.add(s3);
        l1.add(s4);

        SnowStationSimpleOut station = new SnowStationSimpleOut();
        station.readSensorData(l1);

        assertEquals(l1, station.getCurrentSensorData());
        assertEquals(13, station.medianReading().cm, 0.01);
        assertEquals(13, station.medianReading().tempC, 0.01);

        LinkedList<SensorReading> l2 = new LinkedList<>();
        l2.add(s5);
        l1.add(s5);

        station.readSensorData(l2);
        assertEquals(l1, station.getCurrentSensorData());
        assertEquals(8, station.medianReading().cm, 0.01);
        assertEquals(8, station.medianReading().tempC, 0.01);
    }

    public void test() {
        org.junit.runner.JUnitCore.main("Examples");
    }
}
