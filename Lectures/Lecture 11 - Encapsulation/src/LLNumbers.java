import java.util.LinkedList;
import java.util.List;

public class LLNumbers implements ProtectedNums{
    private LinkedList<Integer> numbers;

    public LLNumbers(LinkedList<Integer> numbers){
        this.numbers = numbers;
    }

    @Override
    public void clean(LinkedList<Integer> divisors) {
        LinkedList<Integer> cleanedNumbers = new LinkedList<Integer>();
        for (int n : this.numbers) {
            for (int d : divisors) {
                //n is divisible by d AND n is not in the result list.
                if (n % d == 0 && !cleanedNumbers.contains(n)) {
                    cleanedNumbers.add(n);
                }
            }
        }
        this.numbers = cleanedNumbers;
    }

    @Override
    public List<Integer> dividends() {
        return this.numbers;
    }
}
