import java.util.LinkedList;
import java.util.List;

public interface ProtectedNums {

    /**
     * Takes in a list of divisors and deletes numbers not divisible by the divisors
     * @param divisors
     */
    public void clean(LinkedList<Integer> divisors);

    /**
     * get the current list of numbers that are divisble by any divisors we've seen
     * @return the list of dividends
     */
    List<Integer> dividends();
}
