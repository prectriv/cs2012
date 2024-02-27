import java.util.ArrayList;
import java.util.LinkedList;

public class Rescue {
    /**
     * Find the total amount of kittens
     * 
     * @param litters is an int[]
     * @return int of kittens
     */
    public static int totalKittens(int[] litters) {
        int answer = 0;
        for (int i = 0; i < litters.length; i++) {
            if (litters[i] > 0) {
                answer = answer + litters[i];
            }
        }
        return answer;
    }

    /**
     * Averages the age of puppies
     * 
     * @param puppyAges is a double[]
     * @return average age as an int
     */
    public static double averagePuppyAge(double[] puppyAges) {
        if (puppyAges.length == 0)
            return 0;

        double answer = 0;
        int ctr = 0;
        for (int i = 0; i < puppyAges.length; i++) {
            if (puppyAges[i] < 0)
                continue;
            answer = answer + puppyAges[i];
            ctr++;
        }
        return answer / puppyAges.length;
    };

    /**
     * Tests if a name has both a proper title and credentials
     * 
     * @param name is a name
     * @return boolean expressing if it passed tests
     */
    public static boolean honorablyTitled(String name) {
        if (name == "")
            return false;
        Boolean test1 = (name.contains("Prince") ||
                name.contains("Princess") ||
                name.contains("Duke") ||
                name.contains("Dutchess") ||
                name.contains("Baron") ||
                name.contains("Baroness") ||
                name.contains("Count") ||
                name.contains("Countess") ||
                name.contains("Judge"));

        Boolean test2 = !test1 && name.substring(0, 5).contains(".");
        Boolean test3 = name.contains(",");

        return (!(test1 && test2 && test3) && ((test1 && test3) || (test2 && test3)));
    }

    /**
     * Creates a string to display the consumed chinchilla feed values
     * 
     * @param pellets is an int
     * @param hay     is an int
     * @param fruit   is an int
     * @return a string summarizing the inputs
     */
    public static String chinchillaFeed(int pellets, int hay, int fruit) {
        String p = pellets < 0 ? "unknown" : Integer.toString(pellets);
        String h = hay < 0 ? "unknown" : Integer.toString(hay);
        String f = fruit < 0 ? "unknown" : Integer.toString(fruit);

        return String.format("Chinchilla: %s lbs. of pellets | %s oz. of hay | %s units of dried fruit", p, h, f);
    }

    /**
     * @param catCoords is a LinkedList of cat positions in the Coords object
     * @param location  the Coord that is being tested for proximity
     * @return the Coord that is closest in proximity
     */
    public static Coord heardingCats(LinkedList<Coord> catCoords, Coord location) {
        if (catCoords.size() == 0)
            return null;
        Coord answer = catCoords.get(0);
        double value = Math.hypot((location.x - catCoords.get(0).x), (location.y - catCoords.get(0).y));

        for (int i = 1; i < catCoords.size(); i++) {
            double v = Math.hypot((location.x - catCoords.get(i).x), (location.y - catCoords.get(i).y));
            if (v < value) {
                answer = catCoords.get(i);
                value = v;
            }
        }

        return answer;
    }

    /**
     * Calculates the number of goats who are bloated
     * 
     * @param currentWeights a list of current goat weights
     * @param targetWeights  a list of target goat weights
     * @param errorTolerance the error tolerance between current and target
     * @return the number of bloated goats
     */
    public static int goatBloat(ArrayList<Double> currentWeights, ArrayList<Double> targetWeights,
            double errorTolerance) {
        int index = Math.min(currentWeights.size(), targetWeights.size());
        // int index = currentWeights.size() > targetWeights.size() ?
        // targetWeights.size() : currentWeights.size();
        int answer = 0;

        for (int i = 0; i < index; i++) {
            if (currentWeights.get(i) <= 0 || targetWeights.get(i) <= 0)
                continue;
            if (Math.abs(targetWeights.get(i) - currentWeights.get(i)) > errorTolerance)
                answer++;
        }

        return answer;
    }

}
