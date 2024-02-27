import java.util.LinkedList;

public class CatastropheZone extends UniZone {

    LinkedList<Cat> cats = new LinkedList<Cat>();
    int dry = 0;
    int wet = 0;

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
    public UniZone registerAdoptable(String name, Double age, Double currentWeight, Coord whereabouts) {
        Cat c = new Cat(name, age, currentWeight, whereabouts);
        this.adoptables = this.cats;
        this.cats.add(c);
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
        if(this.cats.size() == 0) return null;

        Adoptable answer = this.cats.get(0);
        Double value = answer.whereabouts.distanceFrom(location);

        for (int i = 1; i < this.cats.size(); i++) {
            double v = this.cats.get(i).whereabouts.distanceFrom(location);
            if (v  < value) {
                answer = this.cats.get(i);
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
     * @param quantity the amount of food being added or subtracted
     * @return a string of the form "Species: # unit of food-type | ..."
     * where # is either a number or the text "unknown" if the amount is currently < 0
     */
    @Override
    public String changeFeed(String food, Integer quantity) {
        if(food.equals("dry")) {
            this.dry += quantity;
        }
        else if(food.equals("wet")) {
            this.wet += quantity;
        }
        String d = this.dry < 0 ? "unknown" : Integer.toString(this.dry);
        String w = this.wet < 0 ? "unknown" : Integer.toString(this.wet);

        return String.format("Cat: %s lbs. of dry food | %s cans of wet food", d, w);
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

        for (Cat c : this.cats) {
            if (c.deltaWeight() > threshold) {
                answer.add(c);
            }
        }
        return answer;
    }
}
