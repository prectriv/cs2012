import java.util.LinkedList;

public class TheHutchZone extends UniZone {
    LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
    int pellets = 0;
    int hay = 0;
    int fruit = 0;

    /**
     * Creates an appropriate adoptable pet-to-be's profile
     *
     * @param name
     * @param age
     * @param currentWeight
     * @param whereabouts
     * @return
     */
    @Override
    public IZone registerAdoptable(String name, Double age, Double currentWeight, Coord whereabouts) {
        Chinchilla c = new Chinchilla(name, age, currentWeight, whereabouts);
        c.hutch = this;
        this.adoptables = this.chinchillas;
        this.chinchillas.add(c);
        return this;
    }

    /**
     * Using the last known sensor data for an adoptable, finds the closest
     * adoptable to some location
     *
     * @param location the 2D top-down coordinate we are searching near
     * @return The data profile of the adoptable last-seen nearest to that
     *         coordinate or null if the zone is empty
     *         If two adoptables are equal distances from a coord, produce the one
     *         added to the zone latest.
     */
    @Override
    public Adoptable closestTo(Coord location) {
        if (this.chinchillas.size() == 0)
            return null;

        Adoptable answer = this.chinchillas.get(0);
        Double value = answer.whereabouts.distanceFrom(location);

        for (int i = 1; i < this.chinchillas.size(); i++) {
            double v = this.chinchillas.get(i).whereabouts.distanceFrom(location);
            if (v < value) {
                answer = this.chinchillas.get(i);
                value = v;
            }
        }
        return answer;
    }

    /**
     * changes the feed stores of the zone,
     * Generates a string label for the zone pantry marquee
     *
     * @param food     the type of food being added
     * @param quantity the amount of food being added or subtracked
     * @return a string of the form "Species: # unit of food-type | ..."
     *         where # is either a number or the text "unknown" if the amount is
     *         currently < 0
     */
    @Override
    public String changeFeed(String food, Integer quantity) {
        if (food.equals("pellets")) {
            this.pellets += quantity;
        } else if (food.equals("hay")) {
            this.hay += quantity;
        } else if (food.equals("fruit")) {
            this.fruit += quantity;
        }

        String p = this.pellets < 0 ? "unknown" : Integer.toString(this.pellets);
        String h = this.hay < 0 ? "unknown" : Integer.toString(this.hay);
        String f = this.fruit < 0 ? "unknown" : Integer.toString(this.fruit);

        return String.format("Chinchilla: %s lbs. of pellets | %s oz. of hay | %s units of dried fruit", p, h, f);
    }

    /**
     * Find the adoptable pets-to-be in the zone that are strictly over or under
     * weight
     *
     * @param threshold a threshold of how over or under weight each adoptable
     *                  pet-to-be can be
     * @return The list of adoptable animals that are currently beyond (> or <) the
     *         threshold of their target weight
     */
    @Override
    public LinkedList<Adoptable> weighIn(Double threshold) {
        LinkedList<Adoptable> answer = new LinkedList<>();

        for (Chinchilla c : this.chinchillas) {
            if (c.deltaWeight() > threshold) {
                answer.add(c);
            }
        }
        return answer;
    }
}
