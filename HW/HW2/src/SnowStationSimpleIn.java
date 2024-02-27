import java.util.LinkedList;

public class SnowStationSimpleIn implements IWeatherStation {
    LinkedList<SensorReading> readings = new LinkedList<>();

    /**
     * Reads an ordered sequence of data from the weather sensors to store in the
     * station
     * When called multiple times, appends the new readings after the current sensor
     * readings
     *
     * @param values A sequence of readings
     *               If the sensor has an error, the tempC or cm might be -999
     */
    @Override
    public void readSensorData(LinkedList<SensorReading> values) {
        this.readings.addAll(values);
    }

    /**
     * Retrieves the current sensor data
     *
     * @return the current sensor data (append together of multiple readings have
     *         occurred)
     *         returns an empty list if there is no data
     */
    @Override
    public LinkedList<SensorReading> getCurrentSensorData() {
        return this.readings;
    }

    /**
     * produces a sensor value of the median temperature and cm (respectively) from
     * the stored readings ignoring error values (-999s)
     *
     * @return a new SensorReading object that has the median temperature of all the
     *         sensor values
     *         and the median cm of all the sensor values
     *         If there are no valid temp or cm values, then the resulting sensor
     *         reading should have -999 for that data, respectively
     */
    @Override
    public SensorReading medianReading() {
        if (this.readings.isEmpty()) {
            return new SnowReading();
        }

        // get LL of only temp values to sort
        LinkedList<Integer> tempSorted = new LinkedList<>();
        LinkedList<Integer> cmSorted = new LinkedList<>();
        for (SensorReading s : this.readings) {
            tempSorted.add(s.tempC);
            cmSorted.add(s.cm);
        }

        tempSorted.sort(Integer::compare);
        cmSorted.sort(Integer::compare);

        int mid = this.readings.size() / 2;
        // odd
        if (this.readings.size() % 2 == 1) {
            return new SnowReading(tempSorted.get(mid + 1), cmSorted.get(mid + 1));
        } else { // even, must average middle 2 values.
            SensorReading s1 = new SnowReading(tempSorted.get(mid), cmSorted.get(mid));
            SensorReading s2 = new SnowReading(tempSorted.get(mid - 1), cmSorted.get(mid - 1));
            return new SnowReading(((s1.tempC + s2.tempC) / 2) + 1, ((s1.cm + s2.cm) / 2) + 1);
        }
    }
}
