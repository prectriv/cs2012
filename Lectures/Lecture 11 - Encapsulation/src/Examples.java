import org.junit.Test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Examples {

    @Test
    public void test_mutabilityError(){
        LinkedList<Integer> divisors = new LinkedList<>();
        LinkedList<Integer> numbers = new LinkedList<>();

        divisors.add(2);

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        LLNumbers llnumbers = new LLNumbers(numbers);

        DivisibilityCounter dc = new DivisibilityCounter(divisors, llnumbers);

        List<Integer> dividends1 = dc.divisibleBy();

        numbers.add(4);

        List<Integer> dividends2 = dc.divisibleBy();

        assertEquals("Encapsulation check:", dividends1, dividends2);

    }
    @Test
    public void test_lots_o_numbers(){
        LinkedList<Integer> divisors = new LinkedList<>();
        HashSet<Integer> numbers = new HashSet<>();

        Random r = new Random();

        for(int i = 0; i < 10000; i++){
            numbers.add(r.nextInt(10000) + 1);
            divisors.add(r.nextInt(10000) + 1);
        }
        HSNumbers hsnumbers = new HSNumbers(numbers);
        DivisibilityCounter dc = new DivisibilityCounter(divisors, hsnumbers);
        long pre = System.currentTimeMillis();
        List<Integer> dividends = dc.divisibleBy();
        long post = System.currentTimeMillis();
        System.out.println("Dividends: " + dividends);
        System.out.printf("Took: %d\n", post - pre);
        assertTrue( String.format("took: %d ms", post - pre), post - pre < 1000);
    }
}
