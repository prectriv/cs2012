import java.util.LinkedList;

public class GoateryZone extends UniZone {
    LinkedList<Goat> goats = new LinkedList<Goat>();
    int piles = 0;

    /**
     * Creates a goat
     *
     * @param name
     * @param age
     * @param currentWeight
     * @param whereabouts
     * @return
     */
    @Override
    public IZone registerAdoptable(String name, Double age, Double currentWeight, Coord whereabouts) {
        Goat g = new Goat(name, age, currentWeight, whereabouts);
        this.adoptables = this.goats;
        this.goats.add(g);
        return this;
    }

    /**
     * Using the last known sensor data for an adoptable, finds the closest adoptable to some location
     *
     * @param location the 2D top-down coordinate we are searching near
     * @return The data profile of the adoptable last-seen nearest to that coordinate or null if the zone is empty
     * If two adoptables are equal distances from a coord, produce the one added to the zone latest.
     */
    @Override
    public Adoptable closestTo(Coord location) {
        if(this.goats.size() == 0) return null;

        Adoptable answer = this.goats.get(0);
        Double value = answer.whereabouts.distanceFrom(location);

        for (int i = 1; i < this.goats.size(); i++) {
            double v = this.goats.get(i).whereabouts.distanceFrom(location);
            if (v  < value) {
                answer = this.goats.get(i);
                value = v;
            }
        }
        return answer;
    }

    /**
     * changes the feed stores of the zone,
     * Generates a string label for the zone pantry marquee
     *
     * @param food     any string of food being added
     * @param quantity the amount of food being added or subtracted
     * @return a string of the form "Goat: # piles of edible substance"
     * where # is either a number or the text "unknown" if the amount is currently < 0
     */
    @Override
    public String changeFeed(String food, Integer quantity) {
        this.piles += quantity;

        String p = this.piles < 0 ? "unknown" : Integer.toString(this.piles);

        return String.format("Goat: %s piles of edible substance", p);
    }

    /**
     * Find the adoptable pets-to-be in the zone that are strictly over or under weight
     *
     * @param threshold a threshold of how over or under weight each adoptable pet-to-be can be
     * @return The list of adoptable animals that are currently beyond (> or <) the threshold of their target weight
     */
    @Override
    public LinkedList<Adoptable> weighIn(Double threshold) {
        LinkedList<Adoptable> answer = new LinkedList<>();

        for (Goat g : this.goats) {
            if (g.deltaWeight() > threshold) {
                answer.add(g);
            }
        }
        return answer;
    }
}
