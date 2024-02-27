import java.util.LinkedList;

public class Main {
    /** a simple program using it */
    public static void main(String[] args){
        LinkedList<Integer> numbers = new LinkedList<>();
        LinkedList<Integer> divisors = new LinkedList<>();

        numbers.add(4);
        numbers.add(6);
        numbers.add(9);
        numbers.add(25);
        numbers.add(33);
        numbers.add(97);

        divisors.add(2);
        divisors.add(3);

        LLNumbers llnumbers = new LLNumbers(numbers);
        DivisibilityCounter dc = new DivisibilityCounter(divisors, llnumbers);

        System.out.println("Common Dividends: " + dc.divisibleBy());
    }
}
