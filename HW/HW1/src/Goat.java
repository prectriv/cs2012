import java.util.LinkedList;

public class Goat extends UniAdopt {
    /**
     * Creates a profile for an adoptable pet-to-be
     *
     * @param name          the name of the animal with no title(s) nor
     *                      credential(s)
     * @param age           the age of the pet in months
     * @param currentWeight the current weight of the pet in grams
     * @param whereabouts   the last known location of the pet as a 2D coordinate
     */
    public Goat(String name, Double age, Double currentWeight, Coord whereabouts) {
        super(name, age, currentWeight, whereabouts);
    }

    /**
     * Calculates the difference between this adoptable pet-to-be's current weight
     * and the target weight for it's species
     *
     * @return the magnitude (non-negative) value of the difference
     */
    @Override
    public Double deltaWeight() {
        Double target = 55000d + Math.floor(this.age / 12) * 1000;
        return Math.abs(Adoptable.weightRound(this.currentWeight, 2) - target);
    }
}