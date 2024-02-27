public class SnowReading extends SensorReading{
    /**
     * Construct a weather reading from a temperature and amount (snow, rain, dust/debris, fog, etc)
     *
     * @param tempC the temperature of the sensor reading in degrees Celsius
     * @param cm    the amount of some weather phenomenon in centimeters
     */
    public SnowReading(Integer tempC, Integer cm) {
        super(tempC, cm);
    }

    public SnowReading() {
        super(-999, -999);
    }

    @Override
    public boolean equals(Object o){
        if(! (o instanceof SnowReading)){
            return false;
        }

        SnowReading other = (SnowReading) o;

        return this.tempC.equals(other.tempC) &&
                this.cm.equals(other.cm);

    };

    @Override
    public String toString() {
        String temp = this.tempC == -999 ? "Err" : Integer.toString(this.tempC) + "C";
        String cm = this.cm == -999 ? "Err" : Integer.toString(this.cm) + "cm";
        return(String.format("%s:%s", temp, cm));
    }
}
