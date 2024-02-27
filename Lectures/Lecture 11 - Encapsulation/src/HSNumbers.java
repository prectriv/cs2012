import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class HSNumbers implements ProtectedNums{
    private HashSet<Integer> numbers;
    public HSNumbers(HashSet<Integer> numbers){
        this.numbers = numbers;
    }

    @Override
    public void clean(LinkedList<Integer> divisors) {
        HashSet<Integer> cleanedNumbers = new HashSet<Integer>();
        for (int n : this.numbers) {
            for (int d : divisors) {
                //n is divisible by d AND n is not in the result list.
                if (n % d == 0 ) { // a HS will remove duplicate elements
                    cleanedNumbers.add(n);
                }
            }
        }
        this.numbers = cleanedNumbers;
    }
    @Override
    public List<Integer> dividends() {
        LinkedList<Integer> nums = new LinkedList<Integer>();
        nums.addAll(this.numbers);
        return nums;
    }
}
