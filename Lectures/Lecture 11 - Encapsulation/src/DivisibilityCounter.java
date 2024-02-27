
import java.util.LinkedList;
import java.util.List;

/**
 * Lecture 11 - Encapsulation Activity
 * A class for finding dividends
 * Vocab:
 * - Mutable: The value in memory can be modified
 * - Immutable: The value in memory cannot be modified (only accessed/copied)
 * - Reference: How a variable "points to" a value in memory
 * - Encapsulation: Where access AND modification of fields are ONLY done via an object's methods
 *   - Separation of Concerns: Where each class only manages/manipulates its own data and not the fields of others
 *   - Modularity: The ability to swap out classes that share a common interface for different use cases
 *   - Invariants: Properties that must ALWAYS be true about the data/fields for methods to work as advertised
 *     - Often we assume/require invariants are true when data enters the system
 *     - Often we ensure invariants are true when data leaves the system or mutation is performed
 *     - Often we prevent external objects from breaking our invariants.
 *     TODO:
 *     - Make the fields private
 *     - See what breaks
 *     - add methods / change constructor to unbreak things
 *     - Hide numbers field behind an interface
 *     - implement that interface with a class that has the list of numbers
 *     - see what breaks
 *     - change methods / change tests/main until things are no longer broken.
 */
public class DivisibilityCounter {
    /** a list of divisors */
    private LinkedList<Integer> divisors;
    /** a list of numbers we want use to find dividends for our divisors */
    private ProtectedNums numbers;

    /** a no-argument constructor for initializing empty divisors and numbers */
//    public DivisibilityCounter(){
//        this.divisors = new LinkedList<>();
//        this.numbers = ProtectedNums.empty();
//    }

    /**
     * A two argument constructor for initializing our fields with pre-chosen divisors and numbers
     * @param divisors the list of divisors
     * @param numbers the list of potential dividends
     */
    public DivisibilityCounter(LinkedList<Integer> divisors, ProtectedNums numbers){
        this.divisors = divisors;
        this.numbers = numbers;
    }

    /**
     * Calculate the dividends accumulated into a list
     * @return the sublist of numbers from numbers such that there exists at least one divisor for that number
     *         INVARIANT: the returned list contains NO repeats
     */
    public List<Integer> divisibleBy(){
        this.numbers.clean(this.divisors);
        return this.numbers.dividends();
    }

}