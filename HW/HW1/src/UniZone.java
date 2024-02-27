import java.util.LinkedList;

public abstract class UniZone implements IZone {

    public LinkedList<? extends Adoptable> adoptables;

    /**
     * Calculates the total number of adoptable pets-to-be in the zone that are >= 0
     * and <= 12 months old
     *
     * @return the calculated total
     */
    @Override
    public int totalYoungins() {
        int total = 0;
        if (this.adoptables == null)
            return 0;
        for (Adoptable a : this.adoptables) {
            if (a.age >= 0.0d && a.age <= 12.0d) {
                total++; // total = total + 1;
            }
        }
        return total;
    }

    /**
     * Calculates the average age of the adoptable pets-to-be in the zone.
     *
     * @return the average age
     */
    @Override
    public double averageAge() {
        double total = 0;
        for (Adoptable a : this.adoptables) {
            total += a.age;
        }
        return total / this.adoptables.size();
    }
}